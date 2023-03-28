package com.song.system.service.impl;

import com.song.system.entity.SysLog;
import com.song.system.mapper.SysLogMapper;
import com.song.system.service.SysLogService;
import com.song.system.param.SysLogQueryParam;
import com.song.system.vo.SysLogQueryVo;
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
 * 系统日志 服务实现类
 * </pre>
 *
 * @author shizuku
 * @since 2022-10-24
 */
@Slf4j
@Service
public class SysLogServiceImpl extends BaseServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveSysLog(SysLog sysLog) throws Exception {
        return super.save(sysLog);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateSysLog(SysLog sysLog) throws Exception {
        return super.updateById(sysLog);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteSysLog(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public SysLogQueryVo getSysLogById(Serializable id) throws Exception {
        return sysLogMapper.getSysLogById(id);
    }

    @Override
    public Paging<SysLogQueryVo> getSysLogPageList(SysLogQueryParam sysLogQueryParam) throws Exception {
        Page page = setPageParam(sysLogQueryParam, OrderItem.desc("create_time"));
        IPage<SysLogQueryVo> iPage = sysLogMapper.getSysLogPageList(page, sysLogQueryParam);
        return new Paging(iPage);
    }

}
