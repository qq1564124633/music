package com.lym.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author liyumin
 * @date 2022/08/15 9:01
 * 歌单实体类
 */
public class SongList implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 歌单主题
     */
    private String title;
    /**
     * 歌单照片
     */
    private String pic;
    /**
     * 简介
     */
    private String introduction;
    /**
     * 风格
     */
    private String style;

    public SongList() {
    }

    public SongList(String title, String pic, String introduction, String style) {
        this.title = title;
        this.pic = pic;
        this.introduction = introduction;
        this.style = style;
    }

    public SongList(Integer id, String title, String pic, String introduction, String style) {
        this.id = id;
        this.title = title;
        this.pic = pic;
        this.introduction = introduction;
        this.style = style;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SongList songList = (SongList) o;
        return Objects.equals(id, songList.id) && Objects.equals(pic, songList.pic) && Objects.equals(introduction, songList.introduction) && Objects.equals(style, songList.style);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pic, introduction, style);
    }

    @Override
    public String toString() {
        return "SongList{" +
                "id=" + id +
                ", pic='" + pic + '\'' +
                ", introduction='" + introduction + '\'' +
                ", style='" + style + '\'' +
                '}';
    }
}
