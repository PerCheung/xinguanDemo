package dao.Impl;

import dao.InStockDao;
import domain.Instock;
import util.DBUtil;
import util.DateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 19:09
 */
public class InStockDaoImpl implements InStockDao {
    private DBUtil db = new DBUtil();

    /**
     * 添加
     */
    @Override
    public Boolean insert(Instock instock) {
        try {
            Connection connection = db.getConnection();
            String sql = "insert into instock values(null,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, DateUtil.dateToString(new Date()));
            pst.setString(2, instock.getDonor());
            pst.setString(3, instock.getDonation());
            pst.setInt(4, instock.getInNum());
            int i = pst.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
