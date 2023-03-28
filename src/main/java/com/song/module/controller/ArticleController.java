package com.song.module.controller;

import com.song.module.entity.Article;
import com.song.module.service.ArticleService;
import com.song.module.param.ArticleQueryParam;
import com.song.module.vo.ArticleQueryVo;
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
 * 文章表 前端控制器
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@RestController
@RequestMapping("/article")
@Api("文章表 API")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    /**
     * 添加文章表
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加Article对象", notes = "添加文章表", response = ApiResult.class)
    public ApiResult<Boolean> addArticle(@Valid @RequestBody Article article) throws Exception {
            boolean flag = articleService.saveArticle(article);
            return ApiResult.result(flag);
    }

    /**
     * 修改文章表
     */
    @PostMapping("/update")
    @ApiOperation(value = "修改Article对象", notes = "修改文章表", response = ApiResult.class)
    public ApiResult<Boolean> updateArticle(@Valid @RequestBody Article article) throws Exception {
            boolean flag = articleService.updateArticle(article);
            return ApiResult.result(flag);
    }

    /**
     * 删除文章表
     */
    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除Article对象", notes = "删除文章表", response = ApiResult.class)
    public ApiResult<Boolean> deleteArticle(@PathVariable("id") Long id) throws Exception {
            boolean flag = articleService.deleteArticle(id);
            return ApiResult.result(flag);
    }

    /**
     * 获取文章表
     */
    @GetMapping("/info/{id}")
    @ApiOperation(value = "获取Article对象详情", notes = "查看文章表", response = ArticleQueryVo.class)
    public ApiResult<ArticleQueryVo> getArticle(@PathVariable("id") Long id) throws Exception {
        ArticleQueryVo articleQueryVo = articleService.getArticleById(id);
        return ApiResult.ok(articleQueryVo);
    }

    /**
     * 文章表分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取Article分页列表", notes = "文章表分页列表", response = ArticleQueryVo.class)
    public ApiResult<Paging<ArticleQueryVo>> getArticlePageList(@Valid @RequestBody ArticleQueryParam articleQueryParam) throws Exception {
        Paging<ArticleQueryVo> paging = articleService.getArticlePageList(articleQueryParam);
        return ApiResult.ok(paging);
    }

}

