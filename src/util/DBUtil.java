package util;

import java.sql.*;

/**
 * jdbc的便捷工具类
 *
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/8/22 15:11
 */
public class DBUtil {
    /**
     * 连接信息
     *
     * driverName 驱动名称
     * url 数据库连接路径，我使用了阿里云的数据库
     * username 数据库账户名
     * password 数据库密码
     */
    private static final String driverName = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://rm-bp1eb34u9vk19ll3vao.mysql.rds.aliyuncs.com:3306/xinguan?serverTimezone=Asia/Shanghai";
    private static final String username = "xinguan";
    private static final String password = "Xinguan1215";

    //注册驱动，使用静态块，只需注册一次
    static {
        //1、注册驱动
        try {
            //通过反射，注册驱动
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //jdbc对象
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    //获取连接
    public Connection getConnection() {
        try {
            //2、建立连接
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //更新操作：增删改
    public int update(String sql, Object[] objs) {
        int i = 0;
        try {
            getConnection();
            //3、创建sql对象
            preparedStatement = connection.prepareStatement(sql);
            for (int j = 0; j < objs.length; j++) {
                preparedStatement.setObject(j + 1, objs[j]);
            }
            //4、执行sql，返回改变的行数
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    //查询操作
    public ResultSet select(String sql, Object[] objs) {
        try {
            getConnection();
            //3、创建sql对象
            preparedStatement = connection.prepareStatement(sql);
            for (int j = 0; j < objs.length; j++) {
                preparedStatement.setObject(j + 1, objs[j]);
            }
            //4、执行sql，返回查询到的set集合
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    //断开连接
    public void closeConnection() {
        //5、断开连接
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}