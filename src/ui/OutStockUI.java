package ui;

import domain.Outstock;
import domain.Stock;
import service.Impl.OutStockServerImpl;
import service.Impl.StockServerImpl;
import service.OutStockServer;
import service.StockServer;
import util.IsNumberUtil;

import java.util.List;
import java.util.Scanner;

/**
 * @author Peter Cheung
 * @user PerCheung
 * @date 2021/12/16 23:09
 */
public class OutStockUI {
    private OutStockServer outStockServer = new OutStockServerImpl();
    private Outstock outstock = new Outstock();

    private StockServer stockServer = new StockServerImpl();
    private Stock stock = new Stock();

    //创建扫描器
    private Scanner sc = new Scanner(System.in);

    /**
     * 续自菜单2选项，开始发放我们的物资
     */
    public void outStock() {
        System.out.println("现在开始发放我们的物资，物资仓库的物品如下：");

        //查询物资表
        List<Stock> stocks = stockServer.queryAll();
        for (Stock everyStock : stocks) {
            System.out.println("【物品名称：" + everyStock.getThingName() + "，目前剩余数量：" + everyStock.getThingNum() + "】");
        }

        System.out.println("请输入你要捐赠的物品名称：");
        String thing = sc.nextLine().trim();
        System.out.println("请输入你要捐赠的数量：");
        String outNumStr = sc.nextLine().trim();
        System.out.println("请输入被捐赠者的姓名或者所属省份地区：");
        String forWho = sc.nextLine().trim();
        boolean isNumber = IsNumberUtil.isNumeric(outNumStr);

        //捐赠数量是否是数字的判断
        if (isNumber) {
            Integer outNum = Integer.valueOf(outNumStr);
            stock.setThingName(thing);

            //查找这个用户发放的物资在仓库中是否存在
            Stock isStock = stockServer.queryOne(stock);
            if (isStock == null) {
                System.out.println("请做一个合格的管理者，物资来之不易，不要乱写物资，我们应当发放我们物资仓库当中存在的物资，请重新发放我们的物资！");
                outStock();
            } else {
                //得到当前物资的数量
                Integer thingNum = isStock.getThingNum();
                int nowNum = thingNum - outNum;

                //判断发放后物资剩余数量是否为正，这是在判断发放者是否发放了超过仓库总数的物资
                if (nowNum >= 0) {
                    outstock.setThing(thing);
                    outstock.setOutNum(outNum);
                    outstock.setForWho(forWho);

                    //存入物资去向表
                    outStockServer.insert(outstock);

                    //更新仓库表
                    stock.setThingNum(nowNum);
                    stockServer.update(stock);

                    System.out.println("十分感谢你为疫情做出了一份努力，你所作的工作凭单打印如下：");
                    List<Outstock> outstocks = outStockServer.queryAll();
                    for (Outstock everyOutstock : outstocks) {
                        everyOutstock.toString();
                    }
                    System.out.println("让我们继续努力工作吧！");
                    System.out.println();
                    new UserUI().choose();
                    System.out.println();
                } else {
                    System.out.println("我们应当有作为管理者的常识，物资来之不易，不要发放超出仓库物资数量的物资，请重新发放我们的物资！");
                    outStock();
                }
            }

        } else {
            System.out.println("请做一个合格的管理者，物资来之不易，我们发放物资的数量应该是正整数，请重新发放我们的物资！");
            outStock();
        }
    }
}
