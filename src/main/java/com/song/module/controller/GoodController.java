package com.song.module.controller;

import com.song.module.entity.Good;
import com.song.module.service.GoodService;
import com.song.module.param.GoodQueryParam;
import com.song.module.vo.GoodQueryVo;
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
 * 商品表 前端控制器
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@RestController
@RequestMapping("/good")
@Api("商品表 API")
public class GoodController extends BaseController {

    @Autowired
    private GoodService goodService;

    /**
     * 添加商品表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加Good对象", notes = "添加商品表", response = ApiResult.class)
    public ApiResult<Boolean> addGood(@Valid @RequestBody Good good) throws Exception {
            boolean flag = goodService.saveGood(good);
            return ApiResult.result(flag);
    }

    /**
     * 修改商品表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改Good对象", notes = "修改商品表", response = ApiResult.class)
    public ApiResult<Boolean> updateGood(@Valid @RequestBody Good good) throws Exception {
            boolean flag = goodService.updateGood(good);
            return ApiResult.result(flag);
    }

    /**
     * 删除商品表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除Good对象", notes = "删除商品表", response = ApiResult.class)
    public ApiResult<Boolean> deleteGood(@PathVariable("id") Long id) throws Exception {
            boolean flag = goodService.deleteGood(id);
            return ApiResult.result(flag);
    }

    /**
     * 获取商品表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取Good对象详情", notes = "查看商品表", response = GoodQueryVo.class)
    public ApiResult<GoodQueryVo> getGood(@PathVariable("id") Long id) throws Exception {
        GoodQueryVo goodQueryVo = goodService.getGoodById(id);
        return ApiResult.ok(goodQueryVo);
    }

    /**
     * 商品表分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取Good分页列表", notes = "商品表分页列表", response = GoodQueryVo.class)
    public ApiResult<Paging<GoodQueryVo>> getGoodPageList(@Valid @RequestBody GoodQueryParam goodQueryParam) throws Exception {
        Paging<GoodQueryVo> paging = goodService.getGoodPageList(goodQueryParam);
        return ApiResult.ok(paging);
    }

}

