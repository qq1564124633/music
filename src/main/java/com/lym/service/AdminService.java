package com.lym.service;

/**
 * @author liyumin
 * @date 2022/08/09 8:12
 *
 *管理员service接口
 */
public interface AdminService {
    /**
     * 验证密码是否正确
     * @param username
     * @param password
     * @return
     */
    public boolean verifyPassword(String username,String password);
}
