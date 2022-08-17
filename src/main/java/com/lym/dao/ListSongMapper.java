package com.lym.dao;

import com.lym.entity.ListSong;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liyumin
 * @date 2022/08/15 15:04
 */
@Repository
public interface ListSongMapper {
    /**
     * 增加
     *
     * @param listSong
     * @return
     */
    public int insertListSong(ListSong listSong);

    /**
     * 修改
     *
     * @param listSong
     * @return
     */
    public int updateListSong(ListSong listSong);

    /**
     * 删除
     *
     * @param songId
     * @param songListId
     * @return
     */
    public int deleteListSong(Integer songId, Integer songListId);

    /**
     * 根据主键查询整个对象
     *
     * @param id
     * @return
     */
    public ListSong selectByIdOfListSong(Integer id);

    /**
     * 查询所有歌单里面的歌曲
     *
     * @return
     */
    public List<ListSong> allListSong();

    /**
     * 根据歌单id查询歌曲信息
     *
     * @param songListId
     * @return
     */
    public List<ListSong> selectBySongListIdOfListSong(Integer songListId);


}
