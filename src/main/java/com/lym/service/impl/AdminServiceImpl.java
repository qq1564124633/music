package com.lym.service.impl;

import com.lym.dao.AdminMapper;
import com.lym.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liyumin
 * @date 2022/08/09 8:14
 * <p>
 * 管理员service接口实现类
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper am;

    @Override
    public boolean verifyPassword(String username, String password) {
        return am.verifyPassword(username, password) > 0;
    }
}
