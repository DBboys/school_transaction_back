package com.song.system.service.impl;

import com.song.shiro.util.SaltUtil;
import com.song.system.entity.SysUser;
import com.song.system.mapper.SysUserMapper;
import com.song.system.service.SysUserService;
import com.song.system.param.SysUserQueryParam;
import com.song.system.vo.SysUserQueryVo;
import com.song.common.service.impl.BaseServiceImpl;
import com.song.common.vo.Paging;
import com.song.util.PasswordUtil;
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
 * 系统用户 服务实现类
 * </pre>
 *
 * @author shizuku
 * @since 2022-10-24
 */
@Slf4j
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveSysUser(SysUser sysUser) throws Exception {
        String salt = SaltUtil.generateSalt();
        String newPassword = PasswordUtil.encrypt(sysUser.getPassword(), salt);
        sysUser.setPassword(newPassword);
        sysUser.setSalt(salt);
        sysUser.setRoleId(0);
        return super.save(sysUser);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateSysUser(SysUser sysUser) throws Exception {
        return super.updateById(sysUser);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteSysUser(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public SysUserQueryVo getSysUserById(Serializable id) throws Exception {
        return sysUserMapper.getSysUserById(id);
    }

    @Override
    public Paging<SysUserQueryVo> getSysUserPageList(SysUserQueryParam sysUserQueryParam) throws Exception {
        Page page = setPageParam(sysUserQueryParam, OrderItem.desc("create_time"));
        IPage<SysUserQueryVo> iPage = sysUserMapper.getSysUserPageList(page, sysUserQueryParam);
        return new Paging(iPage);
    }

}
