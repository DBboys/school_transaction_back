package com.song.module.controller;

import com.song.module.entity.Hole;
import com.song.module.service.HoleService;
import com.song.module.param.HoleQueryParam;
import com.song.module.vo.HoleQueryVo;
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
 * 树洞表 前端控制器
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@RestController
@RequestMapping("/hole")
@Api("树洞表 API")
public class HoleController extends BaseController {

    @Autowired
    private HoleService holeService;

    /**
     * 添加树洞表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加Hole对象", notes = "添加树洞表", response = ApiResult.class)
    public ApiResult<Boolean> addHole(@Valid @RequestBody Hole hole) throws Exception {
            boolean flag = holeService.saveHole(hole);
            return ApiResult.result(flag);
    }

    /**
     * 修改树洞表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改Hole对象", notes = "修改树洞表", response = ApiResult.class)
    public ApiResult<Boolean> updateHole(@Valid @RequestBody Hole hole) throws Exception {
            boolean flag = holeService.updateHole(hole);
            return ApiResult.result(flag);
    }

    /**
     * 删除树洞表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除Hole对象", notes = "删除树洞表", response = ApiResult.class)
    public ApiResult<Boolean> deleteHole(@PathVariable("id") Long id) throws Exception {
            boolean flag = holeService.deleteHole(id);
            return ApiResult.result(flag);
    }

    /**
     * 获取树洞表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取Hole对象详情", notes = "查看树洞表", response = HoleQueryVo.class)
    public ApiResult<HoleQueryVo> getHole(@PathVariable("id") Long id) throws Exception {
        HoleQueryVo holeQueryVo = holeService.getHoleById(id);
        return ApiResult.ok(holeQueryVo);
    }

    /**
     * 树洞表分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取Hole分页列表", notes = "树洞表分页列表", response = HoleQueryVo.class)
    public ApiResult<Paging<HoleQueryVo>> getHolePageList(@Valid @RequestBody HoleQueryParam holeQueryParam) throws Exception {
        Paging<HoleQueryVo> paging = holeService.getHolePageList(holeQueryParam);
        return ApiResult.ok(paging);
    }

}

