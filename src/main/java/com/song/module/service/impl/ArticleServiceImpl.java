package com.song.module.service.impl;

import com.song.module.entity.Article;
import com.song.module.mapper.ArticleMapper;
import com.song.module.service.ArticleService;
import com.song.module.param.ArticleQueryParam;
import com.song.module.vo.ArticleQueryVo;
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
 * 文章表 服务实现类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@Service
public class ArticleServiceImpl extends BaseServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveArticle(Article article) throws Exception {
        return super.save(article);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateArticle(Article article) throws Exception {
        return super.updateById(article);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteArticle(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public ArticleQueryVo getArticleById(Serializable id) throws Exception {
        return articleMapper.getArticleById(id);
    }

    @Override
    public Paging<ArticleQueryVo> getArticlePageList(ArticleQueryParam articleQueryParam) throws Exception {
        Page page = setPageParam(articleQueryParam, OrderItem.desc("create_time"));
        IPage<ArticleQueryVo> iPage = articleMapper.getArticlePageList(page, articleQueryParam);
        return new Paging(iPage);
    }

}
