package service;

import domain.Instock;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 23:02
 */
public interface InStockServer {

    /**
     * 添加
     */
    Boolean insert(Instock instock);
}
