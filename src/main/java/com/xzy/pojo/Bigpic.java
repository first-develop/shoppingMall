package com.xzy.pojo;

public class Bigpic {
    private Integer bigpicId;

    private Integer goodsId;

    private String bigpic;

    public Integer getBigpicId() {
        return bigpicId;
    }

    public void setBigpicId(Integer bigpicId) {
        this.bigpicId = bigpicId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getBigpic() {
        return bigpic;
    }

    public void setBigpic(String bigpic) {
        this.bigpic = bigpic == null ? null : bigpic.trim();
    }
}