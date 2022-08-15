package com.lym.service;

import com.lym.entity.SongList;

import java.util.List;

/**
 * @author liyumin
 * @date 2022/08/15 9:03
 */
public interface SongListService {
    /**
     * 增加
     *
     * @param songList
     * @return
     */
    public boolean insertSongList(SongList songList);

    /**
     * 修改
     *
     * @param songList
     * @return
     */
    public boolean updateSongList(SongList songList);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    public boolean deleteSongList(Integer id);

    /**
     * 根据主键查询整个对象
     *
     * @param id
     * @return
     */
    public SongList selectByIdOfSongList(Integer id);

    /**
     * 查询所有歌单
     *
     * @return
     */
    public List<SongList> allSongList();

    /**
     * 根据歌单标题精确查询歌单信息
     *
     * @param title
     * @return
     */
    public List<SongList> selectByTitleOfSongList(String title);

    /**
     * 根据歌单标题模糊查询查询歌单信息
     *
     * @param title
     * @return
     */
    public List<SongList> selectLikeTitle(String title);

    /**
     * 根据歌单风格模糊查询查询歌单信息
     * @param style
     * @return
     */
    public List<SongList> selectListStyle(String style);
}
