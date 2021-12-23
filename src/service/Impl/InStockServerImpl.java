package service.Impl;

import dao.Impl.InStockDaoImpl;
import dao.InStockDao;
import domain.Instock;
import service.InStockServer;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 23:03
 */
public class InStockServerImpl implements InStockServer {
    private InStockDao inStockDao = new InStockDaoImpl();

    /**
     * 添加捐赠名单
     *
     * @param instock
     * @return
     */
    @Override
    public Boolean insert(Instock instock) {
        return inStockDao.insert(instock);
    }
}
