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

package com.song.shiro.controller;

import com.song.common.api.ApiResult;
import com.song.shiro.param.LoginParam;
import com.song.shiro.service.LoginService;
import com.song.shiro.util.JwtTokenUtil;
import com.song.system.vo.LoginSysUserTokenVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 登陆控制器
 *
 * @author geekidea
 * @date 2019-09-28
 * @since 1.3.0.RELEASE
 **/
@Slf4j
@RestController
@Api(description = "登录、注销API", value = "LoginController")
public class LoginController {

    @Autowired
    private LoginService loginService;



    @PostMapping("/login")
    @ApiOperation(value = "登陆", notes = "系统用户登陆", response = LoginSysUserTokenVo.class)
    public ApiResult login(@Valid @RequestBody LoginParam loginParam, HttpServletResponse response, HttpSession httpSession) throws Exception {
        LoginSysUserTokenVo loginSysUserTokenVo = loginService.login(loginParam);
        // 设置token响应头
        response.setHeader(JwtTokenUtil.getTokenName(), loginSysUserTokenVo.getToken());
        return ApiResult.ok(loginSysUserTokenVo, "登陆成功");
    }

    @PostMapping("/logout")
    @ApiOperation(value = "用户注销", notes = "用户注销")
    public ApiResult logout(HttpServletRequest request, HttpSession httpSession) throws Exception {
        loginService.logout(request);
        return ApiResult.ok("退出成功");
    }
}