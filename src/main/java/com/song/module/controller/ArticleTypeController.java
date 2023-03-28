package com.song.module.controller;

import com.song.module.entity.ArticleType;
import com.song.module.service.ArticleTypeService;
import com.song.module.param.ArticleTypeQueryParam;
import com.song.module.vo.ArticleTypeQueryVo;
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
 * 文章类型表 前端控制器
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@RestController
@RequestMapping("/articleType")
@Api("文章类型表 API")
public class ArticleTypeController extends BaseController {

    @Autowired
    private ArticleTypeService articleTypeService;

    /**
     * 添加文章类型表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加ArticleType对象", notes = "添加文章类型表", response = ApiResult.class)
    public ApiResult<Boolean> addArticleType(@Valid @RequestBody ArticleType articleType) throws Exception {
            boolean flag = articleTypeService.saveArticleType(articleType);
            return ApiResult.result(flag);
    }

    /**
     * 修改文章类型表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改ArticleType对象", notes = "修改文章类型表", response = ApiResult.class)
    public ApiResult<Boolean> updateArticleType(@Valid @RequestBody ArticleType articleType) throws Exception {
            boolean flag = articleTypeService.updateArticleType(articleType);
            return ApiResult.result(flag);
    }

    /**
     * 删除文章类型表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除ArticleType对象", notes = "删除文章类型表", response = ApiResult.class)
    public ApiResult<Boolean> deleteArticleType(@PathVariable("id") Long id) throws Exception {
            boolean flag = articleTypeService.deleteArticleType(id);
            return ApiResult.result(flag);
    }

    /**
     * 获取文章类型表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取ArticleType对象详情", notes = "查看文章类型表", response = ArticleTypeQueryVo.class)
    public ApiResult<ArticleTypeQueryVo> getArticleType(@PathVariable("id") Long id) throws Exception {
        ArticleTypeQueryVo articleTypeQueryVo = articleTypeService.getArticleTypeById(id);
        return ApiResult.ok(articleTypeQueryVo);
    }

    /**
     * 文章类型表分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取ArticleType分页列表", notes = "文章类型表分页列表", response = ArticleTypeQueryVo.class)
    public ApiResult<Paging<ArticleTypeQueryVo>> getArticleTypePageList(@Valid @RequestBody ArticleTypeQueryParam articleTypeQueryParam) throws Exception {
        Paging<ArticleTypeQueryVo> paging = articleTypeService.getArticleTypePageList(articleTypeQueryParam);
        return ApiResult.ok(paging);
    }

}

