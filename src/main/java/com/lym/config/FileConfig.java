package com.lym.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liyumin
 * @date 2022/08/11 15:03
 * 定位图片地址
 */
@Configuration
public class FileConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //对歌手头像地址定位
        //表示文件路径，这里的意思是/img/singerPic/包下的所有文件
        //表示要开放的此包里面的资源，拼成路径，获得歌手头像图像的路径
        //System.getProperty;获取路径
        //user.dir;表示项目目录
        //file.separator;表示斜杠
        registry.addResourceHandler("/img/singerPic/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator")
                        + "img" + System.getProperty("file.separator")
                        + "singerPic" + System.getProperty("file.separator"));
        //对歌曲图片地址的定位
        registry.addResourceHandler("/img/songPic/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator")
                        + "img" + System.getProperty("file.separator")
                        + "songPic" + System.getProperty("file.separator"));
        //对歌单图片地址的定位
        registry.addResourceHandler("/img/songListPic/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator")
                        + "img" + System.getProperty("file.separator")
                        + "songListPic" + System.getProperty("file.separator"));
        //对歌曲地址的定位
        registry.addResourceHandler("/song/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") + System.getProperty("file.separator")
                        + "song" + System.getProperty("file.separator"));
        //用户头像默认地址
        registry.addResourceHandler("/avatorImages/**").addResourceLocations(
                "file:" + System.getProperty("user.dir") +
                        System.getProperty("file.separator")
                        + "avatorImages" + System.getProperty("file.separator"));
    }
}
