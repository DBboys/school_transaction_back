package com.song.module.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.module.entity.ArticleType;
import com.song.module.param.ArticleTypeQueryParam;
import com.song.module.vo.ArticleTypeQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 文章类型表 Mapper 接口
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Repository
public interface ArticleTypeMapper extends BaseMapper<ArticleType> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    ArticleTypeQueryVo getArticleTypeById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param articleTypeQueryParam
     * @return
     */
    IPage<ArticleTypeQueryVo> getArticleTypePageList(@Param("page") Page page, @Param("param") ArticleTypeQueryParam articleTypeQueryParam);

}
