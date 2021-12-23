package domain;

import java.io.Serializable;

/**
 * 管理员表(User)实体类
 *
 * @author cheung
 * @since 2021-12-16 18:58:49
 */
public class User implements Serializable {
    private static final long serialVersionUID = -70003838509459409L;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;


    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
}

