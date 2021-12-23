package service.Impl;

import dao.Impl.UserDaoImpl;
import dao.UserDao;
import domain.User;
import service.UserServer;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 20:33
 */
public class UserServerImpl implements UserServer {
    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册管理员
     */
    @Override
    public Boolean reg(User user) {
        return userDao.insert(user);
    }

    /**
     * 通过密码查找管理员
     */
    @Override
    public Integer findUserByPassword(User user) {
        return userDao.findUserByPassword(user);
    }
}
