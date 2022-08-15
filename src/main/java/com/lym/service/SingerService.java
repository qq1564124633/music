package com.lym.service;

import com.lym.entity.Singer;

import java.util.List;

/**
 * @author liyumin
 * @date 2022/08/11 8:25
 * 歌手service层
 */
public interface SingerService {
    /**
     * 增加
     *
     * @param singer
     * @return
     */
    public boolean insertSinger(Singer singer);

    /**
     * 修改
     *
     * @param singer
     * @return
     */
    public boolean updateSinger(Singer singer);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public boolean deleteSinger(Integer id);

    /**
     * 根据主键查询整个对象
     *
     * @param id
     * @return
     */
    public Singer selectByIdOfSinger(Integer id);

    /**
     * 查询所有歌手
     *
     * @return
     */
    public List<Singer> allSinger();

    /**
     * 根据歌手名字模糊查询歌手信息
     *
     * @param name
     * @return
     */
    public List<Singer> selectByNameOfSinger(String name);
}
