package cn.yuan.entity;

import java.util.Date;

/**
 * 系统管理员类
 *
 * @author yuan
 */
public class SysUser {

    private String user_id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String mobile;
    private String status;
    private String dept_id;
    private Date create_time;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getStatus() {
        return status;
    }

    public String getDept_id() {
        return dept_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public String getUser_id() {

        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", status='" + status + '\'' +
                ", dept_id='" + dept_id + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
