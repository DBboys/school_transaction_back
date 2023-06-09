/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.song.common.exception;

import com.alibaba.fastjson.JSON;
import com.song.common.api.ApiCode;
import com.song.common.api.ApiResult;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.song.system.exception.VerificationCodeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author geekidea
 * @date 2018-11-08
 */
@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 非法参数验证异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ApiResult handleMethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> list = new ArrayList<>();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            list.add(fieldError.getDefaultMessage());
        }
        Collections.sort(list);
        log.error("fieldErrors" + JSON.toJSONString(list));
        return ApiResult.fail(ApiCode.PARAMETER_EXCEPTION, list);
    }

    /**
     * 系统登录异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = SysLoginException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult sysLoginExceptionHandler(SysLoginException exception) {
        log.warn("系统登录异常:" + exception.getMessage());
        return ApiResult.fail(ApiCode.LOGIN_EXCEPTION);
    }


    /**
     * HTTP解析请求参数异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult httpMessageNotReadableException(HttpMessageNotReadableException exception) {
        log.error("httpMessageNotReadableException:", exception);
        return ApiResult.fail(ApiCode.PARAMETER_EXCEPTION, ApiCode.PARAMETER_PARSE_EXCEPTION);
    }

    /**
     * HTTP
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = HttpMediaTypeException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult httpMediaTypeException(HttpMediaTypeException exception) {
        log.error("httpMediaTypeException:", exception);
        return ApiResult.fail(ApiCode.PARAMETER_EXCEPTION, ApiCode.HTTP_MEDIA_TYPE_EXCEPTION);
    }

    /**
     * 自定义业务/数据异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = {SpringBootPlusException.class})
    @ResponseStatus(HttpStatus.OK)
    public ApiResult springBootPlusExceptionHandler(SpringBootPlusException exception) {
        log.error("springBootPlusException:", exception);
        int errorCode;
        if (exception instanceof BusinessException) {
            errorCode = ApiCode.BUSINESS_EXCEPTION.getCode();
        } else if (exception instanceof DaoException) {
            errorCode = ApiCode.DAO_EXCEPTION.getCode();
        } else if (exception instanceof VerificationCodeException) {
            errorCode = ApiCode.VERIFICATION_CODE_EXCEPTION.getCode();
        } else {
            errorCode = ApiCode.SPRING_BOOT_PLUS_EXCEPTION.getCode();
        }
        return new ApiResult()
                .setCode(errorCode)
                .setMsg(exception.getMessage());
    }

    @ExceptionHandler(value = {MySQLIntegrityConstraintViolationException.class})
    @ResponseStatus(HttpStatus.OK)
    public ApiResult handleSqlException(MySQLIntegrityConstraintViolationException mysqlException){
        log.error("MySQLNonTransientException : " ,mysqlException);
        int errorCode ;
        if(mysqlException instanceof MySQLIntegrityConstraintViolationException){
            errorCode = ApiCode.MYSQL_INSERT_DUPLICATE_ENTRY.getCode();
        }
        else{
            errorCode = ApiCode.SPRING_BOOT_PLUS_EXCEPTION.getCode();
        }
        return new ApiResult()
                .setCode(errorCode)
                .setMsg(mysqlException.getMessage());
    }


    /**
     * 登陆授权异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = AuthenticationException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult authenticationExceptionHandler(AuthenticationException exception) {
        log.error("authenticationException:", exception);
        return new ApiResult()
                .setCode(ApiCode.AUTHENTICATION_EXCEPTION.getCode())
                .setMsg(exception.getMessage());
    }

    /**
     * 未认证异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = UnauthenticatedException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult<Boolean> unauthenticatedExceptionHandler(UnauthenticatedException exception) {
        printApiCodeException(ApiCode.UNAUTHENTICATED_EXCEPTION, exception);
        return ApiResult.fail(ApiCode.UNAUTHENTICATED_EXCEPTION);
    }

    /**
     * 未授权异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult<Boolean> unauthorizedExceptionHandler(UnauthorizedException exception) {
        printApiCodeException(ApiCode.UNAUTHORIZED_EXCEPTION, exception);
        return ApiResult.fail(ApiCode.UNAUTHORIZED_EXCEPTION);
    }

//    /**
//     * 工业
//     * @param exception
//     * @return
//     */
//    @ExceptionHandler(value = IndustryException.class)
//    @ResponseStatus(HttpStatus.OK)
//    public ApiResult industryExceptionHandler(IndustryException exception){
//        log.error("IndustryException : " ,exception);
//        int errorCode = ApiCode.SYSTEM_EXCEPTION.getCode();
//        if(exception instanceof EmployeeNotExistException){
//            errorCode = ApiCode.INDUSTRY_EMPLOYEE_NOT_EXIST_EXCEPTION.getCode();
//        }
//        return new ApiResult().setCode(errorCode)
//                .setMsg(exception.getMessage());
//    }

    /**
     * 打印错误码及异常
     *
     * @param apiCode
     * @param exception
     */
    private void printApiCodeException(ApiCode apiCode, Exception exception) {
        log.error(getApiCodeString(apiCode), exception);
    }

    /**
     * 获取ApiCode格式化字符串
     *
     * @param apiCode
     * @return
     */
    private String getApiCodeString(ApiCode apiCode) {
        if (apiCode != null) {
            return String.format("errorCode: %s, errorMessage: %s", apiCode.getCode(), apiCode.getMsg());
        }
        return null;
    }

    /**
     * 默认的异常处理
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResult exceptionHandler(Exception exception) {
        log.error("exception:", exception);
        if(exception instanceof DuplicateKeyException){
            return new ApiResult().setCode(ApiCode.MYSQL_INSERT_DUPLICATE_ENTRY.getCode())
                    .setMsg(ApiCode.MYSQL_INSERT_DUPLICATE_ENTRY.getMsg());
        }
        return ApiResult.fail(ApiCode.SYSTEM_EXCEPTION);
    }

}
