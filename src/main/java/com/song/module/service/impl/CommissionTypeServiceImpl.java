package com.song.module.service.impl;

import com.song.module.entity.CommissionType;
import com.song.module.mapper.CommissionTypeMapper;
import com.song.module.service.CommissionTypeService;
import com.song.module.param.CommissionTypeQueryParam;
import com.song.module.vo.CommissionTypeQueryVo;
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
 * 代办类型表 服务实现类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@Service
public class CommissionTypeServiceImpl extends BaseServiceImpl<CommissionTypeMapper, CommissionType> implements CommissionTypeService {

    @Autowired
    private CommissionTypeMapper commissionTypeMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveCommissionType(CommissionType commissionType) throws Exception {
        return super.save(commissionType);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateCommissionType(CommissionType commissionType) throws Exception {
        return super.updateById(commissionType);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteCommissionType(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public CommissionTypeQueryVo getCommissionTypeById(Serializable id) throws Exception {
        return commissionTypeMapper.getCommissionTypeById(id);
    }

    @Override
    public Paging<CommissionTypeQueryVo> getCommissionTypePageList(CommissionTypeQueryParam commissionTypeQueryParam) throws Exception {
        Page page = setPageParam(commissionTypeQueryParam, OrderItem.desc("create_time"));
        IPage<CommissionTypeQueryVo> iPage = commissionTypeMapper.getCommissionTypePageList(page, commissionTypeQueryParam);
        return new Paging(iPage);
    }

}
