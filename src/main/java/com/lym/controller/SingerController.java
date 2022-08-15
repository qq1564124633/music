package com.lym.controller;

import com.alibaba.fastjson.JSONObject;
import com.lym.entity.Singer;
import com.lym.service.SingerService;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liyumin
 * @date 2022/08/11 8:27
 */
@RestController
@RequestMapping("/singer")
public class SingerController {

    @Autowired
    private SingerService ss;

    /**
     * 添加歌手
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addSinger(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        //trim();去空格
        //获取前端输入的歌手名字
        String name = request.getParameter("name").trim();
        //获取前端输入的歌手性别
        String sex = request.getParameter("sex").trim();
        //获取前端上传的歌手照片路径
        String pic = request.getParameter("pic").trim();
        //获取前端上传的歌手生日
        String birth = request.getParameter("birth").trim();
        //获取前端上传的歌手地区
        String location = request.getParameter("location").trim();
        //获取前端上传的歌手简介
        String introduction = request.getParameter("introduction").trim();
        //时间类型转换,将String类型转换为Date类型
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try {
            birthDate = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //保存到歌手对象中
        Singer singer = new Singer(name, sex, pic, birthDate, location, introduction);
        boolean flag = ss.insertSinger(singer);
        if (flag) {
            //保存成功
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "添加成功");
            return jsonObject;
        }
        //保存失败
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "添加失败");
        return jsonObject;
    }

    /**
     * 修改歌手
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object updateSinger(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        //trim();去空格
        //获取前端输入的歌手id
        Integer id = Integer.parseInt(request.getParameter("id").trim());
        //获取前端输入的歌手名字
        String name = request.getParameter("name").trim();
        //获取前端输入的歌手性别
        String sex = request.getParameter("sex").trim();
        //获取前端上传的歌手照片路径
        String pic = request.getParameter("pic").trim();
        //获取前端上传的歌手生日
        String birth = request.getParameter("birth").trim();
        //获取前端上传的歌手地区
        String location = request.getParameter("location").trim();
        //获取前端上传的歌手简介
        String introduction = request.getParameter("introduction").trim();
        //时间类型转换,将String类型转换为Date类型
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = new Date();
        try {
            birthDate = dateFormat.parse(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //保存到歌手对象中
        Singer singer = new Singer(id, name, sex, pic, birthDate, location, introduction);
        boolean flag = ss.updateSinger(singer);
        if (flag) {
            //保存成功
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "修改成功");
            return jsonObject;
        }
        //保存失败
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "修改失败");
        return jsonObject;
    }

    /**
     * 删除歌手
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object deleteSinger(HttpServletRequest request) {
        //trim();去空格
        //获取前端输入的歌手id
        String id = request.getParameter("id").trim();
        boolean flag = ss.deleteSinger(Integer.parseInt(id));
        return flag;
    }

    /**
     * 根据id查询数据
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/selectById", method = RequestMethod.GET)
    public Object selectById(HttpServletRequest request) {
        //trim();去空格
        //获取前端输入的歌手id
        String id = request.getParameter("id").trim();
        return ss.selectByIdOfSinger(Integer.parseInt(id));
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    @RequestMapping(value = "/allSinger", method = RequestMethod.GET)
    public Object allSinger() {
        return ss.allSinger();
    }

    /**
     * 根据名字查询数据
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/selectByNameOfSinger", method = RequestMethod.GET)
    public Object selectByNameOfSinger(HttpServletRequest request) {
        //trim();去空格
        //获取前端输入的歌手名字
        String name = request.getParameter("name").trim();
        return ss.selectByNameOfSinger("%" + name + "%");
    }

    /**
     * 更新图片的方法
     *
     * @param multipartFile
     * @param id
     * @return
     */
    @RequestMapping(value = "/updateSingerPic", method = RequestMethod.POST)
    public Object updateSingerPic(@RequestParam("file") MultipartFile multipartFile, @RequestParam("id") int id) {
        JSONObject jsonObject = new JSONObject();
        //判断上传的文件是否为空，为空就返回前端文件上传失败
        if (multipartFile.isEmpty()) {
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "文件上传失败");
            return jsonObject;
        }
        //为了避免两次上传的文件相同而不被覆盖掉。
        //文件名=当前时间到毫秒值+原来文件名
        String fileName = System.currentTimeMillis() + multipartFile.getOriginalFilename();
        //文件路径
        //System.getProperty;获取路径
        //user.dir;表示项目目录
        //file.separator;表示斜杠
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator")
                + "img" + System.getProperty("file.separator")
                + "singerPic" + System.getProperty("file.separator");
        //如果文件路径不存在，新增该路径
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        //实际文件地址
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        //存储到数据库里面的相对文件地址
        String storePath = "/img/singerPic/" + fileName;
        try {
            multipartFile.transferTo(dest);
            Singer singer = new Singer();
            singer.setId(id);
            singer.setPic(storePath);
            boolean flag = ss.updateSinger(singer);
            if (flag) {
                //上传成功
                jsonObject.put(Consts.CODE, 1);
                jsonObject.put(Consts.MSG, "上传成功");
                jsonObject.put("pic", storePath);
                return jsonObject;
            }
            //上传失败
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "上传失败");
            return jsonObject;
        } catch (IOException e) {
            //上传失败,把错误信息抛到前端页面去
            jsonObject.put(Consts.CODE, 0);
            jsonObject.put(Consts.MSG, "上传失败" + e.getMessage());
            return jsonObject;
        }
    }
}
