package domain;

import java.io.Serializable;

/**
 * 仓库表(Stock)实体类
 *
 * @author cheung
 * @since 2021-12-16 18:58:49
 */
public class Stock implements Serializable {
    private static final long serialVersionUID = -11059798445158638L;
    /**
     * 物品ID
     */
    private Integer stockId;
    /**
     * 物品名
     */
    private String thingName;
    /**
     * 物品数量
     */
    private Integer thingNum;
    /**
     * 更新时间
     */
    private String updatetime;

    public Stock() {
    }

    public Stock(String thingName, Integer thingNum, String updatetime) {
        this.thingName = thingName;
        this.thingNum = thingNum;
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        String s = "【" + "物资编号：" + stockId + ", 物资名称：" + thingName + ", 物资数量：" + thingNum + ", 更新时间：" + updatetime + "】";
        System.out.println(s);
        return s;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getThingName() {
        return thingName;
    }

    public void setThingName(String thingName) {
        this.thingName = thingName;
    }

    public Integer getThingNum() {
        return thingNum;
    }

    public void setThingNum(Integer thingNum) {
        this.thingNum = thingNum;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}

