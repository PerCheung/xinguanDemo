package domain;

import java.io.Serializable;

/**
 * 出库表(Outstock)实体类
 *
 * @author cheung
 * @since 2021-12-16 18:58:49
 */
public class Outstock implements Serializable {
    private static final long serialVersionUID = -97690835124060841L;
    /**
     * 出库单号
     */
    private Integer outstockId;
    /**
     * 出库时间
     */
    private String createtime;
    /**
     * 出库物品
     */
    private String thing;
    /**
     * 出库物品数量
     */
    private Integer outNum;
    /**
     * 受捐助者
     */
    private String forWho;

    public Outstock() {
    }

    public Outstock(String createtime, String thing, Integer outNum, String forWho) {
        this.createtime = createtime;
        this.thing = thing;
        this.outNum = outNum;
        this.forWho = forWho;
    }

    @Override
    public String toString() {
        String s = "【" + "出库清单流水编号：" + outstockId + ", 物资名称：" + thing + ", 物资数量：" + outNum + ", 我们援助的地方或人：" + forWho + ", 出库时间：" + createtime + "】";
        System.out.println(s);
        return s;
    }

    public Integer getOutstockId() {
        return outstockId;
    }

    public void setOutstockId(Integer outstockId) {
        this.outstockId = outstockId;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public Integer getOutNum() {
        return outNum;
    }

    public void setOutNum(Integer outNum) {
        this.outNum = outNum;
    }

    public String getForWho() {
        return forWho;
    }

    public void setForWho(String forWho) {
        this.forWho = forWho;
    }
}

