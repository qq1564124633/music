package com.lym.dao;

import com.lym.entity.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liyumin
 * @date 2022/08/11 8:28
 * 歌曲Mapper接口
 */
@Repository
public interface SongMapper {
    /**
     * 增加
     *
     * @param song
     * @return
     */
    public int insertSong(Song song);

    /**
     * 修改
     *
     * @param song
     * @return
     */
    public int updateSong(Song song);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public int deleteSong(Integer id);

    /**
     * 根据主键查询整个对象
     *
     * @param id
     * @return
     */
    public Song selectByIdOfSong(Integer id);

    /**
     * 查询所有歌手
     *
     * @return
     */
    public List<Song> allSong();

    /**
     * 根据歌手名字模糊查询歌手信息
     *
     * @param name
     * @return
     */
    public List<Song> selectByNameOfSong(String name);

    /**
     * 根据歌手id查询歌曲信息
     *
     * @param singerId
     * @return
     */
    public List<Song> selectBySingerIdOfSong(Integer singerId);
}
