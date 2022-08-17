package com.lym.entity;

import java.util.Date;
import java.util.Objects;

/**
 * @author liyumin
 * @date 2022/08/16 9:48
 * <p>
 * 前端用户实体类
 */
public class Consumer {
    /**
     * id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别
     */
    private String sex;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 生日
     */
    private Date birth;
    /**
     * 签名
     */
    private String introduction;
    /**
     * 地区
     */
    private String location;
    /**
     * 头像
     */
    private String avator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public Consumer() {
    }

    public Consumer(String username, String password, String sex, String phone, String email, Date birth, String introduction, String location, String avator, Date createTime, Date updateTime) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.birth = birth;
        this.introduction = introduction;
        this.location = location;
        this.avator = avator;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Consumer(Integer id, String username, String password, String sex, String phone, String email, Date birth, String introduction, String location, String avator, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.birth = birth;
        this.introduction = introduction;
        this.location = location;
        this.avator = avator;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
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

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                ", introduction='" + introduction + '\'' +
                ", location='" + location + '\'' +
                ", avator='" + avator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Consumer consumer = (Consumer) o;
        return Objects.equals(id, consumer.id) && Objects.equals(username, consumer.username) && Objects.equals(password, consumer.password) && Objects.equals(sex, consumer.sex) && Objects.equals(phone, consumer.phone) && Objects.equals(email, consumer.email) && Objects.equals(birth, consumer.birth) && Objects.equals(introduction, consumer.introduction) && Objects.equals(location, consumer.location) && Objects.equals(avator, consumer.avator) && Objects.equals(createTime, consumer.createTime) && Objects.equals(updateTime, consumer.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, sex, phone, email, birth, introduction, location, avator, createTime, updateTime);
    }
}
