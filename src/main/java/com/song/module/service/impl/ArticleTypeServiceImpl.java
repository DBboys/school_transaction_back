package com.song.module.service.impl;

import com.song.module.entity.ArticleType;
import com.song.module.mapper.ArticleTypeMapper;
import com.song.module.service.ArticleTypeService;
import com.song.module.param.ArticleTypeQueryParam;
import com.song.module.vo.ArticleTypeQueryVo;
import com.song.common.service.impl.BaseServiceImpl;
import com.song.common.vo.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;


/**
 * <pre>
 * 文章类型表 服务实现类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@Service
public class ArticleTypeServiceImpl extends BaseServiceImpl<ArticleTypeMapper, ArticleType> implements ArticleTypeService {

    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveArticleType(ArticleType articleType) throws Exception {
        return super.save(articleType);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateArticleType(ArticleType articleType) throws Exception {
        return super.updateById(articleType);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteArticleType(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public ArticleTypeQueryVo getArticleTypeById(Serializable id) throws Exception {
        return articleTypeMapper.getArticleTypeById(id);
    }

    @Override
    public Paging<ArticleTypeQueryVo> getArticleTypePageList(ArticleTypeQueryParam articleTypeQueryParam) throws Exception {
        Page page = setPageParam(articleTypeQueryParam, OrderItem.desc("create_time"));
        IPage<ArticleTypeQueryVo> iPage = articleTypeMapper.getArticleTypePageList(page, articleTypeQueryParam);
        return new Paging(iPage);
    }

}
