package com.song.module.service;

import com.song.module.entity.CommissionType;
import com.song.common.service.BaseService;
import com.song.module.param.CommissionTypeQueryParam;
import com.song.module.vo.CommissionTypeQueryVo;
import com.song.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 代办类型表 服务类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
public interface CommissionTypeService extends BaseService<CommissionType> {

    /**
     * 保存
     *
     * @param commissionType
     * @return
     * @throws Exception
     */
    boolean saveCommissionType(CommissionType commissionType) throws Exception;

    /**
     * 修改
     *
     * @param commissionType
     * @return
     * @throws Exception
     */
    boolean updateCommissionType(CommissionType commissionType) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteCommissionType(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    CommissionTypeQueryVo getCommissionTypeById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param commissionTypeQueryParam
     * @return
     * @throws Exception
     */
    Paging<CommissionTypeQueryVo> getCommissionTypePageList(CommissionTypeQueryParam commissionTypeQueryParam) throws Exception;

}
