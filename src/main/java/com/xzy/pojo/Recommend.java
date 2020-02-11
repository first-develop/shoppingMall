package com.xzy.pojo;

import java.util.Date;

public class Recommend {
    private Integer commId;

    private Integer userId;

    private Integer goodsId;

    private Integer click;

    private Integer find;

    private Date time;

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Integer getFind() {
        return find;
    }

    public void setFind(Integer find) {
        this.find = find;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}