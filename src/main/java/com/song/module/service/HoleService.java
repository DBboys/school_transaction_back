package com.song.module.service;

import com.song.module.entity.Hole;
import com.song.common.service.BaseService;
import com.song.module.param.HoleQueryParam;
import com.song.module.vo.HoleQueryVo;
import com.song.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 树洞表 服务类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
public interface HoleService extends BaseService<Hole> {

    /**
     * 保存
     *
     * @param hole
     * @return
     * @throws Exception
     */
    boolean saveHole(Hole hole) throws Exception;

    /**
     * 修改
     *
     * @param hole
     * @return
     * @throws Exception
     */
    boolean updateHole(Hole hole) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteHole(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    HoleQueryVo getHoleById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param holeQueryParam
     * @return
     * @throws Exception
     */
    Paging<HoleQueryVo> getHolePageList(HoleQueryParam holeQueryParam) throws Exception;

}
