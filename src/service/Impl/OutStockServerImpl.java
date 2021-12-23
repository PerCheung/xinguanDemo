package service.Impl;

import dao.Impl.OutStockDaoImpl;
import dao.OutStockDao;
import domain.Outstock;
import service.OutStockServer;

import java.util.List;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 23:02
 */
public class OutStockServerImpl implements OutStockServer {
    private OutStockDao outStockDao = new OutStockDaoImpl();

    /**
     * 查找所有出库清单
     *
     * @return
     */
    @Override
    public List<Outstock> queryAll() {
        return outStockDao.queryAll();
    }

    /**
     * 添加清单
     *
     * @param outstock
     * @return
     */
    @Override
    public Boolean insert(Outstock outstock) {
        return outStockDao.insert(outstock);
    }
}
