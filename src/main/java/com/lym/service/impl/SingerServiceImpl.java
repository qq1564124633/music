package com.lym.service.impl;

import com.lym.dao.SingerMapper;
import com.lym.entity.Singer;
import com.lym.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liyumin
 * @date 2022/08/11 8:26
 * 歌手service实现层
 */
@Service
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerMapper sm;

    @Override
    public boolean insertSinger(Singer singer) {
        return sm.insertSinger(singer) > 0;
    }

    @Override
    public boolean updateSinger(Singer singer) {
        return sm.updateSinger(singer) > 0;
    }

    @Override
    public boolean deleteSinger(Integer id) {
        return sm.deleteSinger(id) > 0;
    }

    @Override
    public Singer selectByIdOfSinger(Integer id) {
        Singer singer = sm.selectByIdOfSinger(id);
        return singer;
    }

    @Override
    public List<Singer> allSinger() {
        List<Singer> ls = sm.allSinger();
        return ls;
    }

    @Override
    public List<Singer> selectByNameOfSinger(String name) {
        List<Singer> ls = sm.selectByNameOfSinger(name);
        return ls;
    }
}
