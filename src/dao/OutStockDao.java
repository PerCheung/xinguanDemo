package dao;

import domain.Outstock;

import java.util.List;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 22:39
 */
public interface OutStockDao {
    /**
     * 查询所有
     */
    List<Outstock> queryAll();

    /**
     * 添加
     */
    Boolean insert(Outstock outstock);
}
