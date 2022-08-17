package com.lym.service;

import com.lym.entity.Song;

import java.util.List;

/**
 * @author liyumin
 * @date 2022/08/11 8:29
 * 歌曲service层
 */
public interface SongService {
    /**
     * 增加
     *
     * @param song
     * @return
     */
    public boolean insertSong(Song song);

    /**
     * 修改
     *
     * @param song
     * @return
     */
    public boolean updateSong(Song song);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public boolean deleteSong(Integer id);

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
    public List<Song> selectByNameLikeSong(String name);

    /**
     * 根据歌手名字准确查询歌手信息
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
