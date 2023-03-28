package com.song.system.service;

import com.song.system.entity.SysLog;
import com.song.common.service.BaseService;
import com.song.system.param.SysLogQueryParam;
import com.song.system.vo.SysLogQueryVo;
import com.song.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 系统日志 服务类
 * </pre>
 *
 * @author shizuku
 * @since 2022-10-24
 */
public interface SysLogService extends BaseService<SysLog> {

    /**
     * 保存
     *
     * @param sysLog
     * @return
     * @throws Exception
     */
    boolean saveSysLog(SysLog sysLog) throws Exception;

    /**
     * 修改
     *
     * @param sysLog
     * @return
     * @throws Exception
     */
    boolean updateSysLog(SysLog sysLog) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteSysLog(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    SysLogQueryVo getSysLogById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param sysLogQueryParam
     * @return
     * @throws Exception
     */
    Paging<SysLogQueryVo> getSysLogPageList(SysLogQueryParam sysLogQueryParam) throws Exception;

}
