package com.lym.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author liyumin
 * @date 2022/08/09 7:53
 * <p>
 * 管理员实体类
 */
public class Admin implements Serializable {
    /**
     * 管理员id
     */
    private Integer id;
    /**
     * 管理员账号
     */
    private String name;
    /**
     * 管理员密码
     */
    private String password;

    public Admin() {
    }

    public Admin(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
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
        Admin admin = (Admin) o;
        return id.equals(admin.id) && Objects.equals(name, admin.name) && Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password);
    }
}
