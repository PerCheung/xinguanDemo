package service;

import domain.Outstock;

import java.util.List;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 23:01
 */
public interface OutStockServer {
    /**
     * 查询所有
     */
    List<Outstock> queryAll();

    /**
     * 添加
     */
    Boolean insert(Outstock outstock);
}
