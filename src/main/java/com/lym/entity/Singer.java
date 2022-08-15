package com.lym.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author liyumin
 * @date 2022/08/10 8:37
 * 歌手实体类
 */
public class Singer implements Serializable {
    /**
     * 歌手编号
     */
    private Integer id;
    /**
     * 歌手姓名
     */
    private String name;
    /**
     * 歌手性别
     */
    private String sex;
    /**
     * 歌手照片
     */
    private String pic;
    /**
     * 歌手生日
     */
    private Date birth;
    /**
     * 歌手地区
     */
    private String location;
    /**
     * 歌手简介
     */
    private String introduction;

    public Singer() {
    }

    public Singer(String name, String sex, String pic, Date birth, String location, String introduction) {
        this.name = name;
        this.sex = sex;
        this.pic = pic;
        this.birth = birth;
        this.location = location;
        this.introduction = introduction;
    }

    public Singer(Integer id, String name, String sex, String pic, Date birth, String location, String introduction) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.pic = pic;
        this.birth = birth;
        this.location = location;
        this.introduction = introduction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Singer singer = (Singer) o;
        return Objects.equals(id, singer.id) && Objects.equals(name, singer.name) && Objects.equals(sex, singer.sex) && Objects.equals(pic, singer.pic) && Objects.equals(birth, singer.birth) && Objects.equals(location, singer.location) && Objects.equals(introduction, singer.introduction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, pic, birth, location, introduction);
    }

    @Override
    public String toString() {
        return "Singer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", pic='" + pic + '\'' +
                ", birth=" + birth +
                ", location='" + location + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
