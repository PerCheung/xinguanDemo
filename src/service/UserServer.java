package service;

import domain.User;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 20:10
 */
public interface UserServer {
    /**
     * 注册管理员
     */
    Boolean reg(User user);

    /**
     * 通过密码查找管理员
     */
    Integer findUserByPassword(User user);
}
