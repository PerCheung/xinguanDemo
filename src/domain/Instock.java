package domain;

import java.io.Serializable;

/**
 * 入库表(Instock)实体类
 *
 * @author cheung
 * @since 2021-12-16 18:58:49
 */
public class Instock implements Serializable {
    private static final long serialVersionUID = 816965622855802189L;
    /**
     * 入库单号
     */
    private Integer instockId;
    /**
     * 入库单创建时间
     */
    private String createtime;
    /**
     * 捐赠人
     */
    private String donor;
    /**
     * 捐赠物
     */
    private String donation;
    /**
     * 捐赠数量
     */
    private Integer inNum;

    public Instock() {
    }

    public Instock(String createtime, String donor, String donation, Integer inNum) {
        this.createtime = createtime;
        this.donor = donor;
        this.donation = donation;
        this.inNum = inNum;
    }

    @Override
    public String toString() {
        String s = "【捐赠者姓名：" + donor + ", 捐赠物资名称：" + donation + ", 捐赠数量：" + inNum + ", 捐赠时间：" + createtime + "】";
        System.out.println(s);
        return s;
    }

    public Integer getInstockId() {
        return instockId;
    }

    public void setInstockId(Integer instockId) {
        this.instockId = instockId;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDonor() {
        return donor;
    }

    public void setDonor(String donor) {
        this.donor = donor;
    }

    public String getDonation() {
        return donation;
    }

    public void setDonation(String donation) {
        this.donation = donation;
    }

    public Integer getInNum() {
        return inNum;
    }

    public void setInNum(Integer inNum) {
        this.inNum = inNum;
    }
}

