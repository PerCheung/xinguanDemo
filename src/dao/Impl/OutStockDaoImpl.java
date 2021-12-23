package dao.Impl;

import dao.OutStockDao;
import domain.Outstock;
import util.DBUtil;
import util.DateUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 19:10
 */
public class OutStockDaoImpl implements OutStockDao {
    private DBUtil db = new DBUtil();

    /**
     * 查询所有
     */
    @Override
    public List<Outstock> queryAll() {
        List<Outstock> list = new ArrayList<>();
        String sql = "select outstock_id,thing,out_num,for_who,createtime from outstock";
        Object[] objs = {};
        ResultSet rs = db.select(sql, objs);
        try {
            while (rs.next()) {
                Outstock outstock = new Outstock();
                outstock.setOutstockId(rs.getInt("outstock_id"));
                outstock.setThing(rs.getString("thing"));
                outstock.setOutNum(rs.getInt("out_num"));
                outstock.setForWho(rs.getString("for_who"));
                outstock.setCreatetime(rs.getString("createtime"));
                list.add(outstock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 添加
     *
     * @param outstock
     * @return
     */
    @Override
    public Boolean insert(Outstock outstock) {
        try {
            Connection connection = db.getConnection();
            String sql = "insert into outstock values(null,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, DateUtil.dateToString(new Date()));
            pst.setString(2, outstock.getThing());
            pst.setInt(3, outstock.getOutNum());
            pst.setString(4, outstock.getForWho());
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
