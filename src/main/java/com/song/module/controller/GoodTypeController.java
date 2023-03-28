package com.song.module.controller;

import com.song.module.entity.GoodType;
import com.song.module.service.GoodTypeService;
import com.song.module.param.GoodTypeQueryParam;
import com.song.module.vo.GoodTypeQueryVo;
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
 * 商品类型表 前端控制器
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@RestController
@RequestMapping("/goodType")
@Api("商品类型表 API")
public class GoodTypeController extends BaseController {

    @Autowired
    private GoodTypeService goodTypeService;

    /**
     * 添加商品类型表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加GoodType对象", notes = "添加商品类型表", response = ApiResult.class)
    public ApiResult<Boolean> addGoodType(@Valid @RequestBody GoodType goodType) throws Exception {
            boolean flag = goodTypeService.saveGoodType(goodType);
            return ApiResult.result(flag);
    }

    /**
     * 修改商品类型表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改GoodType对象", notes = "修改商品类型表", response = ApiResult.class)
    public ApiResult<Boolean> updateGoodType(@Valid @RequestBody GoodType goodType) throws Exception {
            boolean flag = goodTypeService.updateGoodType(goodType);
            return ApiResult.result(flag);
    }

    /**
     * 删除商品类型表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除GoodType对象", notes = "删除商品类型表", response = ApiResult.class)
    public ApiResult<Boolean> deleteGoodType(@PathVariable("id") Long id) throws Exception {
            boolean flag = goodTypeService.deleteGoodType(id);
            return ApiResult.result(flag);
    }

    /**
     * 获取商品类型表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取GoodType对象详情", notes = "查看商品类型表", response = GoodTypeQueryVo.class)
    public ApiResult<GoodTypeQueryVo> getGoodType(@PathVariable("id") Long id) throws Exception {
        GoodTypeQueryVo goodTypeQueryVo = goodTypeService.getGoodTypeById(id);
        return ApiResult.ok(goodTypeQueryVo);
    }

    /**
     * 商品类型表分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取GoodType分页列表", notes = "商品类型表分页列表", response = GoodTypeQueryVo.class)
    public ApiResult<Paging<GoodTypeQueryVo>> getGoodTypePageList(@Valid @RequestBody GoodTypeQueryParam goodTypeQueryParam) throws Exception {
        Paging<GoodTypeQueryVo> paging = goodTypeService.getGoodTypePageList(goodTypeQueryParam);
        return ApiResult.ok(paging);
    }

}

