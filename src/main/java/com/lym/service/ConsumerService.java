package com.lym.service;

import com.lym.entity.Consumer;

import java.util.List;

/**
 * @author liyumin
 * @date 2022/08/16 9:48
 */
public interface ConsumerService {
    /**
     * 增加
     *
     * @param consumer
     * @return
     */
    public boolean insertConsumer(Consumer consumer);

    /**
     * 修改
     *
     * @param consumer
     * @return
     */
    public boolean updateConsumer(Consumer consumer);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public boolean deleteConsumer(Integer id);

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
    public boolean verifyPassword(String username, String password);

    /**
     * 根据账号查询密码，验证账号的唯一性
     * @param username
     * @return
     */
    public Consumer getByUsername(String username);
}
