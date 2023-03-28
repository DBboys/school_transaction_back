package com.song.module.service;

import com.song.module.entity.GoodType;
import com.song.common.service.BaseService;
import com.song.module.param.GoodTypeQueryParam;
import com.song.module.vo.GoodTypeQueryVo;
import com.song.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 商品类型表 服务类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
public interface GoodTypeService extends BaseService<GoodType> {

    /**
     * 保存
     *
     * @param goodType
     * @return
     * @throws Exception
     */
    boolean saveGoodType(GoodType goodType) throws Exception;

    /**
     * 修改
     *
     * @param goodType
     * @return
     * @throws Exception
     */
    boolean updateGoodType(GoodType goodType) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteGoodType(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    GoodTypeQueryVo getGoodTypeById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param goodTypeQueryParam
     * @return
     * @throws Exception
     */
    Paging<GoodTypeQueryVo> getGoodTypePageList(GoodTypeQueryParam goodTypeQueryParam) throws Exception;

}
