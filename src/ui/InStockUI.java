package ui;

import domain.Instock;
import domain.Stock;
import service.Impl.InStockServerImpl;
import service.Impl.StockServerImpl;
import service.InStockServer;
import service.StockServer;
import util.DateUtil;
import util.IsNumberUtil;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 23:10
 */
public class InStockUI {
    private InStockServer inStockServer = new InStockServerImpl();
    private Instock inStock = new Instock();

    private StockServer stockServer = new StockServerImpl();
    private Stock stock = new Stock();

    //创建扫描器
    private Scanner sc = new Scanner(System.in);

    /**
     * 续自菜单1选项，开始登记捐助人，捐助物资，捐助数量
     */
    public void inStock() {
        System.out.println("现在开始登记");
        System.out.println("请输入捐赠人姓名：");
        String donor = sc.nextLine().trim();
        System.out.println("请输入捐赠人捐助的物品名称：");
        String donation = sc.nextLine().trim();
        System.out.println("请输入捐赠人捐助的物品数量：");
        String inNumStr = sc.nextLine().trim();
        boolean isNumber = IsNumberUtil.isNumeric(inNumStr);
        if (isNumber) {
            Integer inNum = Integer.valueOf(inNumStr);
            inStock.setDonor(donor);
            inStock.setDonation(donation);
            inStock.setInNum(inNum);

            //将登记的物资放入进库记录表中
            inStockServer.insert(inStock);

            //通过物资名称查询仓库中是否已经有该物资
            stock.setThingName(donation);
            Stock isStock = stockServer.queryOne(stock);

            //如果仓库中没有，就将我们的物资放入
            if (isStock == null) {
                stock.setThingNum(inNum);
                stockServer.insert(stock);
                System.out.println("更新后的仓库清单打印如下：");
                List<Stock> stocks = stockServer.queryAll();
                for (Stock everyStock : stocks) {
                    everyStock.toString();
                }
            } else {
                //既然仓库中已经有了，只需要把物资加上即可
                Integer nowNum = isStock.getThingNum();

                //新旧相加
                int newNum = nowNum + inNum;

                //更新仓库对象，用更新过的仓库对象更新仓库表
                stock.setThingNum(newNum);
                stockServer.update(stock);

                System.out.println("更新后的仓库清单打印如下：");
                List<Stock> stocks = stockServer.queryAll();
                for (Stock everyStock : stocks) {
                    everyStock.toString();
                }
            }
            System.out.println("好的，这位捐赠者的打印清单我们登记如下：");
            inStock.setCreatetime(DateUtil.dateToString(new Date()));
            inStock.toString();
            System.out.println("真的万分感谢！");
            System.out.println();
            new UserUI().choose();
            System.out.println();
        } else {
            System.out.println("请做一个合格的管理者，疫情不是儿戏，我们捐赠人物品的数量应该是正整数，请重新登记！");
            inStock();
        }
    }
}
