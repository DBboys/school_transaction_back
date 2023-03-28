package com.song.module.service.impl;

import com.song.module.entity.Commission;
import com.song.module.mapper.CommissionMapper;
import com.song.module.service.CommissionService;
import com.song.module.param.CommissionQueryParam;
import com.song.module.vo.CommissionQueryVo;
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
 * 代办表 服务实现类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@Service
public class CommissionServiceImpl extends BaseServiceImpl<CommissionMapper, Commission> implements CommissionService {

    @Autowired
    private CommissionMapper commissionMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveCommission(Commission commission) throws Exception {
        return super.save(commission);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateCommission(Commission commission) throws Exception {
        return super.updateById(commission);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteCommission(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public CommissionQueryVo getCommissionById(Serializable id) throws Exception {
        return commissionMapper.getCommissionById(id);
    }

    @Override
    public Paging<CommissionQueryVo> getCommissionPageList(CommissionQueryParam commissionQueryParam) throws Exception {
        Page page = setPageParam(commissionQueryParam, OrderItem.desc("create_time"));
        IPage<CommissionQueryVo> iPage = commissionMapper.getCommissionPageList(page, commissionQueryParam);
        return new Paging(iPage);
    }

}
