package com.song.module.service;

import com.song.module.entity.ArticleType;
import com.song.common.service.BaseService;
import com.song.module.param.ArticleTypeQueryParam;
import com.song.module.vo.ArticleTypeQueryVo;
import com.song.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 文章类型表 服务类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
public interface ArticleTypeService extends BaseService<ArticleType> {

    /**
     * 保存
     *
     * @param articleType
     * @return
     * @throws Exception
     */
    boolean saveArticleType(ArticleType articleType) throws Exception;

    /**
     * 修改
     *
     * @param articleType
     * @return
     * @throws Exception
     */
    boolean updateArticleType(ArticleType articleType) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteArticleType(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    ArticleTypeQueryVo getArticleTypeById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param articleTypeQueryParam
     * @return
     * @throws Exception
     */
    Paging<ArticleTypeQueryVo> getArticleTypePageList(ArticleTypeQueryParam articleTypeQueryParam) throws Exception;

}
