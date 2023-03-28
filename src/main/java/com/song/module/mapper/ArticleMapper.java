package com.song.module.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.module.entity.Article;
import com.song.module.param.ArticleQueryParam;
import com.song.module.vo.ArticleQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 文章表 Mapper 接口
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ArticleQueryVo getArticleById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param articleQueryParam
     * @return
     */
    IPage<ArticleQueryVo> getArticlePageList(@Param("page") Page page, @Param("param") ArticleQueryParam articleQueryParam);

}
