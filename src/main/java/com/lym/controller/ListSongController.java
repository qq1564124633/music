package com.lym.controller;

import com.alibaba.fastjson.JSONObject;
import com.lym.entity.ListSong;
import com.lym.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liyumin
 * @date 2022/08/15 15:05
 */
@RestController
public class ListSongController {
    @Autowired
    private ListSongService lss;

    /**
     * 添加
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/listSong/add", method = RequestMethod.POST)
    public Object addListSong(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String songId = req.getParameter("songId").trim();
        String songListId = req.getParameter("songListId").trim();

        ListSong listsong = new ListSong();
        listsong.setSongId(Integer.parseInt(songId));
        listsong.setSongListId(Integer.parseInt(songListId));

        boolean res = lss.insertListSong(listsong);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "添加成功");
            return jsonObject;
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "添加失败");
            return jsonObject;
        }
    }

    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping(value = "/listSong", method = RequestMethod.GET)
    public Object allListSong() {
        return lss.allListSong();
    }

    /**
     * 根据歌单id查询所有
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/listSong/detail", method = RequestMethod.GET)
    public Object listSongOfSongId(HttpServletRequest req) {
        String songListId = req.getParameter("songListId");
        return lss.selectBySongListIdOfListSong(Integer.parseInt(songListId));
    }

    /**
     * 删除
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/listSong/delete", method = RequestMethod.GET)
    public Object deleteListSong(HttpServletRequest req) {
        //歌曲id
        String songId = req.getParameter("songId").trim();
        //歌单id
        String songListId = req.getParameter("songListId").trim();
        return lss.deleteListSong(Integer.parseInt(songId),Integer.parseInt(songListId));
    }
}
