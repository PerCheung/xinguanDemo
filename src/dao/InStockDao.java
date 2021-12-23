package dao;

import domain.Instock;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 22:44
 */
public interface InStockDao {
    /**
     * 添加
     */
    Boolean insert(Instock instock);
}
