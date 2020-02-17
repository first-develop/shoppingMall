package com.xzy.model;

public class goods_tableVO extends goods_table {
    private String  seller_name;

    @Override
    public String toString() {
        return "goods_tableVO{" +
                "seller_name='" + seller_name + '\'' +
                "} " + super.toString();
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }
}
