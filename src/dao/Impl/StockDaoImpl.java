package dao.Impl;

import dao.StockDao;
import domain.Stock;
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
 * @date 2021/12/16 19:08
 */
public class StockDaoImpl implements StockDao {
    private DBUtil db = new DBUtil();

    /**
     * 查询物资
     */
    @Override
    public List<Stock> queryAll() {
        List<Stock> list = new ArrayList<>();
        String sql = "select stock_id,thing_name,thing_num,updatetime from stock";
        Object[] objs = {};
        ResultSet rs = db.select(sql, objs);
        try {
            while (rs.next()) {
                Stock stock = new Stock();
                stock.setStockId(rs.getInt("stock_id"));
                stock.setThingName(rs.getString("thing_name"));
                stock.setThingNum(rs.getInt("thing_num"));
                stock.setUpdatetime(rs.getString("updatetime"));
                list.add(stock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 通过物资名称查找
     */
    @Override
    public Stock queryOne(Stock stock) {
        String sql = "select stock_id,thing_name,thing_num,updatetime from stock where thing_name=?";
        Object[] obj = {stock.getThingName()};
        try {
            Connection con = db.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, String.valueOf(obj[0]));
            ResultSet resultSet = db.select(sql, obj);
            if (resultSet.next()) {
                stock.setStockId(resultSet.getInt("stock_id"));
                stock.setThingName(resultSet.getString("thing_name"));
                stock.setThingNum(resultSet.getInt("thing_num"));
                stock.setUpdatetime(resultSet.getString("updatetime"));
                return stock;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加物资入库
     *
     * @param stock
     * @return
     */
    @Override
    public Boolean insert(Stock stock) {
        try {
            Connection connection = db.getConnection();
            String sql = "insert into stock values(null,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, stock.getThingName());
            pst.setInt(2, stock.getThingNum());
            pst.setString(3, DateUtil.dateToString(new Date()));
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
     * 更改物资
     *
     * @param stock
     * @return
     */
    @Override
    public Stock update(Stock stock) {
        String sql = "update stock set thing_num=?,updatetime=? where thing_name=?";
        Object[] objs = {stock.getThingNum(), DateUtil.dateToString(new Date()), stock.getThingName()};
        int i = db.update(sql, objs);
        if (i > 0) {
            return queryOne(stock);
        }
        return stock;
    }
}
