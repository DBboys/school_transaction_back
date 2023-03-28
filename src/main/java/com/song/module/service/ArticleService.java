package com.song.module.service;

import com.song.module.entity.Article;
import com.song.common.service.BaseService;
import com.song.module.param.ArticleQueryParam;
import com.song.module.vo.ArticleQueryVo;
import com.song.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 文章表 服务类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
public interface ArticleService extends BaseService<Article> {

    /**
     * 保存
     *
     * @param article
     * @return
     * @throws Exception
     */
    boolean saveArticle(Article article) throws Exception;

    /**
     * 修改
     *
     * @param article
     * @return
     * @throws Exception
     */
    boolean updateArticle(Article article) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteArticle(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ArticleQueryVo getArticleById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param articleQueryParam
     * @return
     * @throws Exception
     */
    Paging<ArticleQueryVo> getArticlePageList(ArticleQueryParam articleQueryParam) throws Exception;

}
