package com.lym.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author liyumin
 * @date 2022/08/09 7:57
 * 管理员dao
 */
@Repository
public interface AdminMapper {
    /**
     * 验证密码是否正确
     * @param username
     * @param password
     * @return
     */
    public Integer verifyPassword(String username, String password);
}
