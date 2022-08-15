package com.lym.service.impl;

import com.lym.dao.SongMapper;
import com.lym.entity.Song;
import com.lym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liyumin
 * @date 2022/08/11 8:29
 * 歌曲service层实现类
 */
@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongMapper sm;

    /**
     * 增加
     *
     * @param song
     * @return
     */
    @Override
    public boolean insertSong(Song song) {
        return sm.insertSong(song) > 0;
    }

    /**
     * 修改
     *
     * @param song
     * @return
     */
    @Override
    public boolean updateSong(Song song) {
        return sm.updateSong(song) > 0;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteSong(Integer id) {
        return sm.deleteSong(id) > 0;
    }

    /**
     * 根据主键查询整个对象
     *
     * @param id
     * @return
     */
    @Override
    public Song selectByIdOfSong(Integer id) {
        Song song = sm.selectByIdOfSong(id);
        return song;
    }

    /**
     * 查询所有歌手
     *
     * @return
     */
    @Override
    public List<Song> allSong() {
        List<Song> songs = sm.allSong();
        return songs;
    }

    /**
     * 根据歌手名字模糊查询歌手信息
     *
     * @param name
     * @return
     */
    @Override
    public List<Song> selectByNameOfSong(String name) {
        List<Song> songs = sm.selectByNameOfSong(name);
        return songs;
    }

    /**
     * 根据歌手id查询歌曲信息
     *
     * @param singerId
     * @return
     */
    @Override
    public List<Song> selectBySingerIdOfSong(Integer singerId) {
        List<Song> songs = sm.selectBySingerIdOfSong(singerId);
        return songs;
    }
}
