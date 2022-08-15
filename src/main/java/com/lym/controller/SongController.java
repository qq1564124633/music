package com.lym.controller;

import com.alibaba.fastjson.JSONObject;
import com.lym.entity.Song;
import com.lym.service.SongService;
import com.lym.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author liyumin
 * @date 2022/08/11 8:29
 * 歌曲Controller层
 */
@RestController
@RequestMapping(value = "/song")
public class SongController {
    @Autowired
    private SongService ss;

    /**
     * 添加歌曲
     *
     * @param request
     * @param multipartFile
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addSong(HttpServletRequest request, @RequestParam("file") MultipartFile multipartFile) {
        JSONObject jsonObject = new JSONObject();
        //获取前端传来的参数
        //所属歌手id
        String singerId = request.getParameter("singerId").trim();
        //歌名
        String name = request.getParameter("name").trim();
        //简介
        String introduction = request.getParameter("introduction").trim();
        //歌曲默认图片
        String pic = "/img/songPic/tubiao.jpg";
        //歌词
        String lyric = request.getParameter("lyric").trim();
        //上传歌曲文件
        //判断上传的文件是否为空，为空就返回前端文件上传失败
        if (multipartFile.isEmpty()) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "歌曲上传失败");
            return jsonObject;
        }
        //为了避免两次上传的文件相同而不被覆盖掉。
        //文件名=当前时间到毫秒值+原来文件名
        String fileName = System.currentTimeMillis() + multipartFile.getOriginalFilename();
        //歌曲文件路径
        //System.getProperty;获取路径
        //user.dir;表示项目目录
        //file.separator;表示斜杠
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator")
                + "song" + System.getProperty("file.separator");
        //如果文件路径不存在，新增该路径
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        //实际文件地址
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        //存储到数据库里面的相对文件地址
        String storePath = "/song/" + fileName;
        try {
            multipartFile.transferTo(dest);
            Song song = new Song();
            song.setSingerId(Integer.parseInt(singerId));
            song.setName(name);
            song.setIntroduction(introduction);
            song.setPic(pic);
            song.setLyric(lyric);
            song.setUrl(storePath);
            boolean flag = ss.insertSong(song);
            if (flag) {
                //上传成功
                jsonObject.put(Consts.CODE, 1);
                jsonObject.put(Consts.MSG, "添加成功");
                jsonObject.put("avator", storePath);
                return jsonObject;
            }
            //上传失败
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "添加失败");
            return jsonObject;
        } catch (IOException e) {
            //上传失败,把错误信息抛到前端页面去
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "添加失败" + e.getMessage());
            return jsonObject;
        }
    }

    /**
     * 修改歌曲信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object updateSong(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        //歌曲id
        String id = request.getParameter("id").trim();
        //歌曲姓名
        String name = request.getParameter("name").trim();
        //歌曲专辑
        String introduction = request.getParameter("introduction").trim();
        //歌曲歌词
        String lyric = request.getParameter("lyric").trim();
        //保存到歌手的对象中
        Song song = new Song();
        song.setId(Integer.parseInt(id));
        song.setName(name);
        song.setIntroduction(introduction);
        song.setLyric(lyric);

        boolean flag = ss.updateSong(song);
        if (flag) {
            //上传成功
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "修改成功");
            return jsonObject;
        }
        //上传失败
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "修改失败");
        return jsonObject;
    }

    /**
     * 删除歌曲
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object deleteSinger(HttpServletRequest request) {
        //trim();去空格
        //获取前端输入的歌手id
        String id = request.getParameter("id").trim();
        boolean flag = ss.deleteSong(Integer.parseInt(id));
        return flag;
    }

    /**
     * 按照歌手id查询歌手
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/singer/detail", method = RequestMethod.GET)
    public Object songOfSingId(HttpServletRequest request) {
        String singerId = request.getParameter("singerId");
        return ss.selectBySingerIdOfSong(Integer.parseInt(singerId));
    }

    /**
     * 返回指定歌手名的歌曲
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/song/singerName/detail", method = RequestMethod.GET)
    public Object songOfSingerName(HttpServletRequest req) {
        String name = req.getParameter("name");
        return ss.selectByNameOfSong('%' + name + '%');
    }

    /**
     * 更新歌曲图片
     *
     * @param urlFile
     * @param id
     * @return
     */
    @RequestMapping(value = "/img/update", method = RequestMethod.POST)
    public Object updateSongPic(@RequestParam("file") MultipartFile urlFile, @RequestParam("id") int id) {
        JSONObject jsonObject = new JSONObject();
        //判断上传的文件是否为空，为空就返回前端文件上传失败
        if (urlFile.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "音乐上传失败！");
            return jsonObject;
        }
        //为了避免两次上传的文件相同而不被覆盖掉。
        //文件名=当前时间到毫秒值+原来文件名
        String fileName = System.currentTimeMillis() + urlFile.getOriginalFilename();
        //文件路径
        //System.getProperty;获取路径
        //user.dir;表示项目目录
        //file.separator;表示斜杠
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "songPic";
        //如果文件路径不存在，新增该路径
        File file1 = new File(filePath);
        if (!file1.exists()) {
            file1.mkdir();
        }
        //实际文件地址
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        //存储到数据库里面的相对文件地址
        String storeUrlPath = "/img/songPic/" + fileName;
        try {
            urlFile.transferTo(dest);
            Song song = new Song();
            song.setId(id);
            song.setPic(storeUrlPath);
            boolean res = ss.updateSong(song);
            if (res) {
                //上传成功
                jsonObject.put("code", 1);
                jsonObject.put("avator", storeUrlPath);
                jsonObject.put("msg", "上传成功");
                return jsonObject;
            } else {
                //上传失败
                jsonObject.put("code", 0);
                jsonObject.put("msg", "上传失败");
                return jsonObject;
            }
        } catch (IOException e) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "上传失败" + e.getMessage());
            return jsonObject;
        }
    }

    /**
     * 更新歌曲url
     *
     * @param urlFile
     * @param id
     * @return
     */
    @RequestMapping(value = "/url/update", method = RequestMethod.POST)
    public Object updateSongUrl(@RequestParam("file") MultipartFile urlFile, @RequestParam("id") int id) {
        JSONObject jsonObject = new JSONObject();
        //判断上传的文件是否为空，为空就返回前端文件上传失败
        if (urlFile.isEmpty()) {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "音乐上传失败！");
            return jsonObject;
        }
        //为了避免两次上传的文件相同而不被覆盖掉。
        //文件名=当前时间到毫秒值+原来文件名
        String fileName = urlFile.getOriginalFilename();
        //文件路径
        //System.getProperty;获取路径
        //user.dir;表示项目目录
        //file.separator;表示斜杠
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "song";
        //如果文件路径不存在，新增该路径
        File file1 = new File(filePath);
        if (!file1.exists()) {
            file1.mkdir();
        }
        //实际文件地址
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        //存储到数据库里面的相对文件地址
        String storeUrlPath = "/song/" + fileName;
        try {
            urlFile.transferTo(dest);
            Song song = new Song();
            song.setId(id);
            song.setUrl(storeUrlPath);
            boolean res = ss.updateSong(song);
            if (res) {
                //上传成功
                jsonObject.put("code", 1);
                jsonObject.put("avator", storeUrlPath);
                jsonObject.put("msg", "上传成功");
                return jsonObject;
            } else {
                //上传失败
                jsonObject.put("code", 0);
                jsonObject.put("msg", "上传失败");
                return jsonObject;
            }
        } catch (IOException e) {
            //上传失败,把错误信息抛到前端页面去
            jsonObject.put("code", 0);
            jsonObject.put("msg", "上传失败" + e.getMessage());
            return jsonObject;
        }
    }
}
