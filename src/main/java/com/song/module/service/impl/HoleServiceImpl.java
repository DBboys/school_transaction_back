package com.song.module.service.impl;

import com.song.module.entity.Hole;
import com.song.module.mapper.HoleMapper;
import com.song.module.service.HoleService;
import com.song.module.param.HoleQueryParam;
import com.song.module.vo.HoleQueryVo;
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
 * 树洞表 服务实现类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@Service
public class HoleServiceImpl extends BaseServiceImpl<HoleMapper, Hole> implements HoleService {

    @Autowired
    private HoleMapper holeMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveHole(Hole hole) throws Exception {
        return super.save(hole);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateHole(Hole hole) throws Exception {
        return super.updateById(hole);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteHole(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public HoleQueryVo getHoleById(Serializable id) throws Exception {
        return holeMapper.getHoleById(id);
    }

    @Override
    public Paging<HoleQueryVo> getHolePageList(HoleQueryParam holeQueryParam) throws Exception {
        Page page = setPageParam(holeQueryParam, OrderItem.desc("create_time"));
        IPage<HoleQueryVo> iPage = holeMapper.getHolePageList(page, holeQueryParam);
        return new Paging(iPage);
    }

}
