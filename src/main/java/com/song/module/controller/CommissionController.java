package com.song.module.controller;

import com.song.module.entity.Commission;
import com.song.module.service.CommissionService;
import com.song.module.param.CommissionQueryParam;
import com.song.module.vo.CommissionQueryVo;
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
 * 代办表 前端控制器
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@RestController
@RequestMapping("/commission")
@Api("代办表 API")
public class CommissionController extends BaseController {

    @Autowired
    private CommissionService commissionService;

    /**
     * 添加代办表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加Commission对象", notes = "添加代办表", response = ApiResult.class)
    public ApiResult<Boolean> addCommission(@Valid @RequestBody Commission commission) throws Exception {
            boolean flag = commissionService.saveCommission(commission);
            return ApiResult.result(flag);
    }

    /**
     * 修改代办表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改Commission对象", notes = "修改代办表", response = ApiResult.class)
    public ApiResult<Boolean> updateCommission(@Valid @RequestBody Commission commission) throws Exception {
            boolean flag = commissionService.updateCommission(commission);
            return ApiResult.result(flag);
    }

    /**
     * 删除代办表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除Commission对象", notes = "删除代办表", response = ApiResult.class)
    public ApiResult<Boolean> deleteCommission(@PathVariable("id") Long id) throws Exception {
            boolean flag = commissionService.deleteCommission(id);
            return ApiResult.result(flag);
    }

    /**
     * 获取代办表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取Commission对象详情", notes = "查看代办表", response = CommissionQueryVo.class)
    public ApiResult<CommissionQueryVo> getCommission(@PathVariable("id") Long id) throws Exception {
        CommissionQueryVo commissionQueryVo = commissionService.getCommissionById(id);
        return ApiResult.ok(commissionQueryVo);
    }

    /**
     * 代办表分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取Commission分页列表", notes = "代办表分页列表", response = CommissionQueryVo.class)
    public ApiResult<Paging<CommissionQueryVo>> getCommissionPageList(@Valid @RequestBody CommissionQueryParam commissionQueryParam) throws Exception {
        Paging<CommissionQueryVo> paging = commissionService.getCommissionPageList(commissionQueryParam);
        return ApiResult.ok(paging);
    }

}

