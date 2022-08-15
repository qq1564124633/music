package com.lym.dao;

import com.lym.entity.Singer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liyumin
 * @date 2022/08/11 8:25
 * 歌手dao
 */
@Repository
public interface SingerMapper {
    /**
     * 增加
     *
     * @param singer
     * @return
     */
    public int insertSinger(Singer singer);

    /**
     * 修改
     *
     * @param singer
     * @return
     */
    public int updateSinger(Singer singer);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int deleteSinger(Integer id);

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
