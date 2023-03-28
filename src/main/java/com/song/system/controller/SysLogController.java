package com.song.system.controller;

import com.song.system.entity.SysLog;
import com.song.system.service.SysLogService;
import com.song.system.param.SysLogQueryParam;
import com.song.system.vo.SysLogQueryVo;
import com.song.common.api.ApiResult;
import com.song.common.controller.BaseController;
import com.song.common.vo.Paging;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

/**
 * <pre>
 * 系统日志 前端控制器
 * </pre>
 *
 * @author shizuku
 * @since 2022-10-24
 */
@Slf4j
@RestController
@RequestMapping("/sysLog")
@Api("系统日志 API")
public class SysLogController extends BaseController {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 添加系统日志
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加SysLog对象", notes = "添加系统日志", response = ApiResult.class)
    public ApiResult<Boolean> addSysLog(@Valid @RequestBody SysLog sysLog) throws Exception {
            boolean flag = sysLogService.saveSysLog(sysLog);
            return ApiResult.result(flag);
    }

    /**
     * 修改系统日志
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改SysLog对象", notes = "修改系统日志", response = ApiResult.class)
    public ApiResult<Boolean> updateSysLog(@Valid @RequestBody SysLog sysLog) throws Exception {
            boolean flag = sysLogService.updateSysLog(sysLog);
            return ApiResult.result(flag);
    }

    /**
     * 删除系统日志
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除SysLog对象", notes = "删除系统日志", response = ApiResult.class)
    public ApiResult<Boolean> deleteSysLog(@PathVariable("id") Long id) throws Exception {
            boolean flag = sysLogService.deleteSysLog(id);
            return ApiResult.result(flag);
    }

    /**
     * 获取系统日志
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取SysLog对象详情", notes = "查看系统日志", response = SysLogQueryVo.class)
    public ApiResult<SysLogQueryVo> getSysLog(@PathVariable("id") Long id) throws Exception {
        SysLogQueryVo sysLogQueryVo = sysLogService.getSysLogById(id);
        return ApiResult.ok(sysLogQueryVo);
    }

    /**
     * 系统日志分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取SysLog分页列表", notes = "系统日志分页列表", response = SysLogQueryVo.class)
    public ApiResult<Paging<SysLogQueryVo>> getSysLogPageList(@Valid @RequestBody SysLogQueryParam sysLogQueryParam) throws Exception {
        Paging<SysLogQueryVo> paging = sysLogService.getSysLogPageList(sysLogQueryParam);
        return ApiResult.ok(paging);
    }

}

