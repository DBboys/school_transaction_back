package com.song.module.service.impl;

import com.song.module.entity.GoodType;
import com.song.module.mapper.GoodTypeMapper;
import com.song.module.service.GoodTypeService;
import com.song.module.param.GoodTypeQueryParam;
import com.song.module.vo.GoodTypeQueryVo;
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
 * 商品类型表 服务实现类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@Service
public class GoodTypeServiceImpl extends BaseServiceImpl<GoodTypeMapper, GoodType> implements GoodTypeService {

    @Autowired
    private GoodTypeMapper goodTypeMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveGoodType(GoodType goodType) throws Exception {
        return super.save(goodType);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateGoodType(GoodType goodType) throws Exception {
        return super.updateById(goodType);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteGoodType(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public GoodTypeQueryVo getGoodTypeById(Serializable id) throws Exception {
        return goodTypeMapper.getGoodTypeById(id);
    }

    @Override
    public Paging<GoodTypeQueryVo> getGoodTypePageList(GoodTypeQueryParam goodTypeQueryParam) throws Exception {
        Page page = setPageParam(goodTypeQueryParam, OrderItem.desc("create_time"));
        IPage<GoodTypeQueryVo> iPage = goodTypeMapper.getGoodTypePageList(page, goodTypeQueryParam);
        return new Paging(iPage);
    }

}
