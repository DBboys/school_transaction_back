package com.song.system.service;

import com.song.system.entity.SysUser;
import com.song.common.service.BaseService;
import com.song.system.param.SysUserQueryParam;
import com.song.system.vo.SysUserQueryVo;
import com.song.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 系统用户 服务类
 * </pre>
 *
 * @author shizuku
 * @since 2022-10-24
 */
public interface SysUserService extends BaseService<SysUser> {

    /**
     * 保存
     *
     * @param sysUser
     * @return
     * @throws Exception
     */
    boolean saveSysUser(SysUser sysUser) throws Exception;

    /**
     * 修改
     *
     * @param sysUser
     * @return
     * @throws Exception
     */
    boolean updateSysUser(SysUser sysUser) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteSysUser(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    SysUserQueryVo getSysUserById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param sysUserQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysUserQueryVo> getSysUserPageList(SysUserQueryParam sysUserQueryParam) throws Exception;

}
