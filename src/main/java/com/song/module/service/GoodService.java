package com.song.module.service;

import com.song.module.entity.Good;
import com.song.common.service.BaseService;
import com.song.module.param.GoodQueryParam;
import com.song.module.vo.GoodQueryVo;
import com.song.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 商品表 服务类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
public interface GoodService extends BaseService<Good> {

    /**
     * 保存
     *
     * @param good
     * @return
     * @throws Exception
     */
    boolean saveGood(Good good) throws Exception;

    /**
     * 修改
     *
     * @param good
     * @return
     * @throws Exception
     */
    boolean updateGood(Good good) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteGood(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    GoodQueryVo getGoodById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param goodQueryParam
     * @return
     * @throws Exception
     */
    Paging<GoodQueryVo> getGoodPageList(GoodQueryParam goodQueryParam) throws Exception;

}
