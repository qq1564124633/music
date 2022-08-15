package com.lym.service.impl;

import com.lym.dao.SongListMapper;
import com.lym.entity.SongList;
import com.lym.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liyumin
 * @date 2022/08/15 9:03
 */
@Service
public class SongListServiceImpl implements SongListService {
    @Autowired
    private SongListMapper slm;

    @Override
    public boolean insertSongList(SongList songList) {
        return slm.insertSongList(songList) > 0;
    }

    @Override
    public boolean updateSongList(SongList songList) {
        return slm.updateSongList(songList) > 0;
    }

    @Override
    public boolean deleteSongList(Integer id) {
        return slm.deleteSongList(id) > 0;
    }

    @Override
    public SongList selectByIdOfSongList(Integer id) {
        return slm.selectByIdOfSongList(id);
    }

    @Override
    public List<SongList> allSongList() {
        return slm.allSongList();
    }

    @Override
    public List<SongList> selectByTitleOfSongList(String title) {
        return slm.selectByTitleOfSongList(title);
    }

    @Override
    public List<SongList> selectLikeTitle(String title) {
        return slm.selectLikeTitle(title);
    }

    @Override
    public List<SongList> selectListStyle(String style) {
        return slm.selectListStyle(style);
    }
}
