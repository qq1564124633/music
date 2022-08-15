package com.lym.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author liyumin
 * @date 2022/08/11 8:28
 * 歌曲表
 */
public class Song implements Serializable {
    /**
     * 歌曲id
     */
    private Integer id;
    /**
     * 歌手id
     */
    private Integer singerId;
    /**
     * 歌名
     */
    private String name;
    /**
     * 歌曲简介
     */
    private String introduction;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 歌曲图片
     */
    private String pic;
    /**
     * 歌词
     */
    private String lyric;
    /**
     * 歌曲地址
     */
    private String url;

    public Song() {
    }

    public Song(Integer singerId, String name, String introduction, Date createTime, Date updateTime, String pic, String lyric, String url) {
        this.singerId = singerId;
        this.name = name;
        this.introduction = introduction;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.pic = pic;
        this.lyric = lyric;
        this.url = url;
    }

    public Song(Integer id, Integer singerId, String name, String introduction, Date createTime, Date updateTime, String pic, String lyric, String url) {
        this.id = id;
        this.singerId = singerId;
        this.name = name;
        this.introduction = introduction;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.pic = pic;
        this.lyric = lyric;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Song song = (Song) o;
        return Objects.equals(id, song.id) && Objects.equals(singerId, song.singerId) && Objects.equals(name, song.name) && Objects.equals(introduction, song.introduction) && Objects.equals(createTime, song.createTime) && Objects.equals(updateTime, song.updateTime) && Objects.equals(pic, song.pic) && Objects.equals(lyric, song.lyric) && Objects.equals(url, song.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, singerId, name, introduction, createTime, updateTime, pic, lyric, url);
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", singerId=" + singerId +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", pic='" + pic + '\'' +
                ", lyric='" + lyric + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
