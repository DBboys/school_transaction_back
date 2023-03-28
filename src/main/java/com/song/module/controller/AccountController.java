package com.song.module.controller;

import com.song.module.entity.Account;
import com.song.module.service.AccountService;
import com.song.module.param.AccountQueryParam;
import com.song.module.vo.AccountQueryVo;
import com.song.common.api.ApiResult;
import com.song.common.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

import com.song.common.vo.Paging;
import com.song.common.param.IdParam;

/**
 * <pre>
 * 用户表 前端控制器
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@RestController
@RequestMapping("/account")
@Api("用户表 API")
public class AccountController extends BaseController {

    @Autowired
    private AccountService accountService;

    /**
     * 添加用户表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加Account对象", notes = "添加用户表", response = ApiResult.class)
    public ApiResult<Boolean> addAccount(@Valid @RequestBody Account account) throws Exception {
            boolean flag = accountService.saveAccount(account);
            return ApiResult.result(flag);
    }

    /**
     * 修改用户表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改Account对象", notes = "修改用户表", response = ApiResult.class)
    public ApiResult<Boolean> updateAccount(@Valid @RequestBody Account account) throws Exception {
            boolean flag = accountService.updateAccount(account);
            return ApiResult.result(flag);
    }

    /**
     * 删除用户表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除Account对象", notes = "删除用户表", response = ApiResult.class)
    public ApiResult<Boolean> deleteAccount(@PathVariable("id") Long id) throws Exception {
            boolean flag = accountService.deleteAccount(id);
            return ApiResult.result(flag);
    }

    /**
     * 获取用户表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取Account对象详情", notes = "查看用户表", response = AccountQueryVo.class)
    public ApiResult<AccountQueryVo> getAccount(@PathVariable("id") Long id) throws Exception {
        AccountQueryVo accountQueryVo = accountService.getAccountById(id);
        return ApiResult.ok(accountQueryVo);
    }

    /**
     * 用户表分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取Account分页列表", notes = "用户表分页列表", response = AccountQueryVo.class)
    public ApiResult<Paging<AccountQueryVo>> getAccountPageList(@Valid @RequestBody AccountQueryParam accountQueryParam) throws Exception {
        Paging<AccountQueryVo> paging = accountService.getAccountPageList(accountQueryParam);
        return ApiResult.ok(paging);
    }

}

