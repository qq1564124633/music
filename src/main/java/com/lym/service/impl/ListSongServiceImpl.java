package com.lym.service.impl;

import com.lym.dao.ListSongMapper;
import com.lym.entity.ListSong;
import com.lym.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liyumin
 * @date 2022/08/15 15:07
 */
@Service
public class ListSongServiceImpl implements ListSongService {
    @Autowired
    private ListSongMapper lsm;

    @Override
    public boolean insertListSong(ListSong listSong) {
        return lsm.insertListSong(listSong) > 0;
    }

    @Override
    public boolean updateListSong(ListSong listSong) {
        return lsm.updateListSong(listSong) > 0;
    }

    @Override
    public boolean deleteListSong(Integer songId, Integer songListId) {
        return lsm.deleteListSong(songId, songListId)>0;
    }

    @Override
    public ListSong selectByIdOfListSong(Integer id) {
        return lsm.selectByIdOfListSong(id);
    }

    @Override
    public List<ListSong> allListSong() {
        return lsm.allListSong();
    }

    @Override
    public List<ListSong> selectBySongListIdOfListSong(Integer songListId) {
        return lsm.selectBySongListIdOfListSong(songListId);
    }
}
