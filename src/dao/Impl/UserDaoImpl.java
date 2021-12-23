package dao.Impl;

import dao.UserDao;
import domain.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 19:08
 */
public class UserDaoImpl implements UserDao {
    private DBUtil db = new DBUtil();

    /**
     * 注册管理员
     */
    @Override
    public Boolean insert(User user) {
        try {
            Connection connection = db.getConnection();
            String sql = "insert into user values(null,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            int i = pst.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 通过密码查找管理员
     */
    @Override
    public Integer findUserByPassword(User user) {
        String sql = "select password from user where username=?";
        Object[] obj = {user.getUsername()};
        try {
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, String.valueOf(obj[0]));
            ResultSet resultSet = db.select(sql, obj);
            if (resultSet.next()) {
                if (user.getPassword().equals(resultSet.getString("password"))) {
                    return 1;
                } else {
                    return 2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}