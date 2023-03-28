package com.song.module.controller;

import com.song.module.entity.CommissionType;
import com.song.module.service.CommissionTypeService;
import com.song.module.param.CommissionTypeQueryParam;
import com.song.module.vo.CommissionTypeQueryVo;
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
 * 代办类型表 前端控制器
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@RestController
@RequestMapping("/commissionType")
@Api("代办类型表 API")
public class CommissionTypeController extends BaseController {

    @Autowired
    private CommissionTypeService commissionTypeService;

    /**
     * 添加代办类型表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加CommissionType对象", notes = "添加代办类型表", response = ApiResult.class)
    public ApiResult<Boolean> addCommissionType(@Valid @RequestBody CommissionType commissionType) throws Exception {
            boolean flag = commissionTypeService.saveCommissionType(commissionType);
            return ApiResult.result(flag);
    }

    /**
     * 修改代办类型表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改CommissionType对象", notes = "修改代办类型表", response = ApiResult.class)
    public ApiResult<Boolean> updateCommissionType(@Valid @RequestBody CommissionType commissionType) throws Exception {
            boolean flag = commissionTypeService.updateCommissionType(commissionType);
            return ApiResult.result(flag);
    }

    /**
     * 删除代办类型表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除CommissionType对象", notes = "删除代办类型表", response = ApiResult.class)
    public ApiResult<Boolean> deleteCommissionType(@PathVariable("id") Long id) throws Exception {
            boolean flag = commissionTypeService.deleteCommissionType(id);
            return ApiResult.result(flag);
    }

    /**
     * 获取代办类型表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取CommissionType对象详情", notes = "查看代办类型表", response = CommissionTypeQueryVo.class)
    public ApiResult<CommissionTypeQueryVo> getCommissionType(@PathVariable("id") Long id) throws Exception {
        CommissionTypeQueryVo commissionTypeQueryVo = commissionTypeService.getCommissionTypeById(id);
        return ApiResult.ok(commissionTypeQueryVo);
    }

    /**
     * 代办类型表分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取CommissionType分页列表", notes = "代办类型表分页列表", response = CommissionTypeQueryVo.class)
    public ApiResult<Paging<CommissionTypeQueryVo>> getCommissionTypePageList(@Valid @RequestBody CommissionTypeQueryParam commissionTypeQueryParam) throws Exception {
        Paging<CommissionTypeQueryVo> paging = commissionTypeService.getCommissionTypePageList(commissionTypeQueryParam);
        return ApiResult.ok(paging);
    }

}

