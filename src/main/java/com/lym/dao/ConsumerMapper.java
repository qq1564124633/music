package com.lym.dao;

import com.lym.entity.Consumer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liyumin
 * @date 2022/08/16 9:47
 */
@Repository
public interface ConsumerMapper {
    /**
     * 增加
     *
     * @param consumer
     * @return
     */
    public int insertConsumer(Consumer consumer);

    /**
     * 修改
     *
     * @param consumer
     * @return
     */
    public int updateConsumer(Consumer consumer);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int deleteConsumer(Integer id);

    /**
     * 根据主键查询整个对象
     *
     * @param id
     * @return
     */
    public Consumer selectByIdOfConsumer(Integer id);

    /**
     * 查询所有用户
     *
     * @return
     */
    public List<Consumer> allConsumer();

    /**
     * 根据账号验证密码
     *
     * @param username
     * @param password
     * @return
     */
    public int verifyPassword(String username, String password);

    /**
     * 根据账号查询密码，验证账号的唯一性
     * @param username
     * @return
     */
    public Consumer getByUsername(String username);
}
