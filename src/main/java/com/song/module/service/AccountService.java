package com.song.module.service;

import com.song.module.entity.Account;
import com.song.common.service.BaseService;
import com.song.module.param.AccountQueryParam;
import com.song.module.vo.AccountQueryVo;
import com.song.common.vo.Paging;

import java.io.Serializable;

/**
 * <pre>
 * 用户表 服务类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
public interface AccountService extends BaseService<Account> {

    /**
     * 保存
     *
     * @param account
     * @return
     * @throws Exception
     */
    boolean saveAccount(Account account) throws Exception;

    /**
     * 修改
     *
     * @param account
     * @return
     * @throws Exception
     */
    boolean updateAccount(Account account) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteAccount(Long id) throws Exception;

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     * @throws Exception
     */
    AccountQueryVo getAccountById(Serializable id) throws Exception;

    /**
     * 获取分页对象
     *
     * @param accountQueryParam
     * @return
     * @throws Exception
     */
    Paging<AccountQueryVo> getAccountPageList(AccountQueryParam accountQueryParam) throws Exception;

}
