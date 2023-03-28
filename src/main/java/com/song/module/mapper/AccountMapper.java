package com.song.module.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.song.module.entity.Account;
import com.song.module.param.AccountQueryParam;
import com.song.module.vo.AccountQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 用户表 Mapper 接口
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Repository
public interface AccountMapper extends BaseMapper<Account> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    AccountQueryVo getAccountById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param accountQueryParam
     * @return
     */
    IPage<AccountQueryVo> getAccountPageList(@Param("page") Page page, @Param("param") AccountQueryParam accountQueryParam);

}
