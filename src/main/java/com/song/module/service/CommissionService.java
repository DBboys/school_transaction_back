package com.song.module.service;

import com.song.module.entity.Commission;
import com.song.common.service.BaseService;
import com.song.module.param.CommissionQueryParam;
import com.song.module.vo.CommissionQueryVo;
import com.song.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 代办表 服务类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
public interface CommissionService extends BaseService<Commission> {

    /**
     * 保存
     *
     * @param commission
     * @return
     * @throws Exception
     */
    boolean saveCommission(Commission commission) throws Exception;

    /**
     * 修改
     *
     * @param commission
     * @return
     * @throws Exception
     */
    boolean updateCommission(Commission commission) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteCommission(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    CommissionQueryVo getCommissionById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param commissionQueryParam
     * @return
     * @throws Exception
     */
    Paging<CommissionQueryVo> getCommissionPageList(CommissionQueryParam commissionQueryParam) throws Exception;

}
