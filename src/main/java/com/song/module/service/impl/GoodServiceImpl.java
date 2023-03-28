package com.song.module.service.impl;

import com.song.module.entity.Good;
import com.song.module.mapper.GoodMapper;
import com.song.module.service.GoodService;
import com.song.module.param.GoodQueryParam;
import com.song.module.vo.GoodQueryVo;
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
 * 商品表 服务实现类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@Service
public class GoodServiceImpl extends BaseServiceImpl<GoodMapper, Good> implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveGood(Good good) throws Exception {
        return super.save(good);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateGood(Good good) throws Exception {
        return super.updateById(good);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteGood(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public GoodQueryVo getGoodById(Serializable id) throws Exception {
        return goodMapper.getGoodById(id);
    }

    @Override
    public Paging<GoodQueryVo> getGoodPageList(GoodQueryParam goodQueryParam) throws Exception {
        Page page = setPageParam(goodQueryParam, OrderItem.desc("create_time"));
        IPage<GoodQueryVo> iPage = goodMapper.getGoodPageList(page, goodQueryParam);
        return new Paging(iPage);
    }

}
