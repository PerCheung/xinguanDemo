package service;

import domain.Stock;

import java.util.List;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 23:01
 */
public interface StockServer {
    /**
     * 查询物资
     */
    List<Stock> queryAll();

    /**
     * 通过物资名称查找
     */
    Stock queryOne(Stock stock);

    /**
     * 添加物资
     */
    Boolean insert(Stock stock);

    /**
     * 修改物资
     */
    Stock update(Stock stock);

}
