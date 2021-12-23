package service.Impl;

import dao.Impl.StockDaoImpl;
import dao.StockDao;
import domain.Stock;
import service.StockServer;

import java.util.List;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 23:02
 */
public class StockServerImpl implements StockServer {
    private StockDao stockDao = new StockDaoImpl();

    /**
     * 查询物资
     */
    @Override
    public List<Stock> queryAll() {
        return stockDao.queryAll();
    }

    /**
     * 通过物资名称查找
     */
    @Override
    public Stock queryOne(Stock stock) {
        return stockDao.queryOne(stock);
    }

    /**
     * 添加物资
     */
    @Override
    public Boolean insert(Stock stock) {
        return stockDao.insert(stock);
    }

    /**
     * 修改物资
     */
    @Override
    public Stock update(Stock stock) {
        return stockDao.update(stock);
    }
}
