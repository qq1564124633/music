package com.lym.service.impl;

import com.lym.dao.ConsumerMapper;
import com.lym.entity.Consumer;
import com.lym.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liyumin
 * @date 2022/08/16 9:49
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private ConsumerMapper cm;

    @Override
    public boolean insertConsumer(Consumer consumer) {
        return cm.insertConsumer(consumer) > 0;
    }

    @Override
    public boolean updateConsumer(Consumer consumer) {
        return cm.updateConsumer(consumer) > 0;
    }

    @Override
    public boolean deleteConsumer(Integer id) {
        return cm.deleteConsumer(id) > 0;
    }

    @Override
    public Consumer selectByIdOfConsumer(Integer id) {
        return cm.selectByIdOfConsumer(id);
    }

    @Override
    public List<Consumer> allConsumer() {
        return cm.allConsumer();
    }

    @Override
    public boolean verifyPassword(String username, String password) {
        return cm.verifyPassword(username, password)>0;
    }

    @Override
    public Consumer getByUsername(String username) {
        return cm.getByUsername(username);
    }
}
