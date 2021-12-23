package dao;

import domain.User;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 20:05
 */
public interface UserDao {
    /**
     * 添加
     */
    Boolean insert(User user);

    /**
     * 通过用户名查找
     */
    Integer findUserByPassword(User user);
}
