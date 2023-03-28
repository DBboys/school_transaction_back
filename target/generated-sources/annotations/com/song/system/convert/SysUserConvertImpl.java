package com.song.system.convert;

import com.song.shiro.vo.LoginSysUserRedisVo;
import com.song.shiro.vo.SysUserQueryVo;
import com.song.system.entity.SysUser;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-24T15:18:34+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class SysUserConvertImpl implements SysUserConvert {

    @Override
    public SysUserQueryVo sysUserToLoginSysUserVo(SysUser sysUser) {
        if ( sysUser == null ) {
            return null;
        }

        SysUserQueryVo sysUserQueryVo = new SysUserQueryVo();

        sysUserQueryVo.setId( sysUser.getId() );
        sysUserQueryVo.setUsername( sysUser.getUsername() );
        sysUserQueryVo.setSalt( sysUser.getSalt() );
        sysUserQueryVo.setPassword( sysUser.getPassword() );
        sysUserQueryVo.setRoleId( sysUser.getRoleId() );
        sysUserQueryVo.setStatus( sysUser.getStatus() );
        sysUserQueryVo.setCreateTime( sysUser.getCreateTime() );
        sysUserQueryVo.setHead( sysUser.getHead() );

        return sysUserQueryVo;
    }

    @Override
    public LoginSysUserRedisVo loginSysUserVoToLoginSysUserRedisVo(SysUserQueryVo loginSysUserVo) {
        if ( loginSysUserVo == null ) {
            return null;
        }

        LoginSysUserRedisVo loginSysUserRedisVo = new LoginSysUserRedisVo();

        loginSysUserRedisVo.setId( loginSysUserVo.getId() );
        loginSysUserRedisVo.setUsername( loginSysUserVo.getUsername() );
        loginSysUserRedisVo.setPassword( loginSysUserVo.getPassword() );
        loginSysUserRedisVo.setMobile( loginSysUserVo.getMobile() );
        loginSysUserRedisVo.setRoleId( loginSysUserVo.getRoleId() );
        loginSysUserRedisVo.setRoleName( loginSysUserVo.getRoleName() );
        loginSysUserRedisVo.setStatus( loginSysUserVo.getStatus() );
        loginSysUserRedisVo.setDeptName( loginSysUserVo.getDeptName() );
        loginSysUserRedisVo.setUnitName( loginSysUserVo.getUnitName() );
        loginSysUserRedisVo.setCreateTime( loginSysUserVo.getCreateTime() );
        loginSysUserRedisVo.setHead( loginSysUserVo.getHead() );
        loginSysUserRedisVo.setDelFlag( loginSysUserVo.getDelFlag() );
        loginSysUserRedisVo.setSalt( loginSysUserVo.getSalt() );

        return loginSysUserRedisVo;
    }
}
