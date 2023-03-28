package com.song.module.service.impl;

import com.song.module.entity.Account;
import com.song.module.mapper.AccountMapper;
import com.song.module.service.AccountService;
import com.song.module.param.AccountQueryParam;
import com.song.module.vo.AccountQueryVo;
import com.song.common.service.impl.BaseServiceImpl;
import com.song.common.vo.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;


/**
 * <pre>
 * 用户表 服务实现类
 * </pre>
 *
 * @author song
 * @since 2023-03-24
 */
@Slf4j
@Service
public class AccountServiceImpl extends BaseServiceImpl<AccountMapper, Account> implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveAccount(Account account) throws Exception {
        return super.save(account);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateAccount(Account account) throws Exception {
        return super.updateById(account);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteAccount(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public AccountQueryVo getAccountById(Serializable id) throws Exception {
        return accountMapper.getAccountById(id);
    }

    @Override
    public Paging<AccountQueryVo> getAccountPageList(AccountQueryParam accountQueryParam) throws Exception {
        Page page = setPageParam(accountQueryParam, OrderItem.desc("create_time"));
        IPage<AccountQueryVo> iPage = accountMapper.getAccountPageList(page, accountQueryParam);
        return new Paging(iPage);
    }

}
