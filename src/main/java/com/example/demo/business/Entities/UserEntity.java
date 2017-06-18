package com.example.demo.business.Entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by davblain on 20.05.2017.
 */
@Entity
@Table(name = "user", schema = "mydb", catalog = "")
public class UserEntity  implements Serializable {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private Timestamp createTime;
    private Timestamp lastLog;
    private Integer ugroup;

    @Id
    @GenericGenerator(name="gen",strategy="increment")
    @GeneratedValue(generator="gen")
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 16,unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "last_log", nullable = true)
    public Timestamp getLastLog() {
        return lastLog;
    }

    public void setLastLog(Timestamp lastLog) {
        this.lastLog = lastLog;
    }

    @Basic
    @Column(name = "Ugroup", nullable = true)
    public Integer getUgroup() {
        return ugroup;
    }

    public void setUgroup(Integer ugroup) {
        this.ugroup = ugroup;
    }

}
