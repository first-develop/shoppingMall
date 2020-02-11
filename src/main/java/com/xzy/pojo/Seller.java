package com.xzy.pojo;

public class Seller {
    private Integer sellerId;

    private String sellerName;

    private String sellerPic;

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName == null ? null : sellerName.trim();
    }

    public String getSellerPic() {
        return sellerPic;
    }

    public void setSellerPic(String sellerPic) {
        this.sellerPic = sellerPic == null ? null : sellerPic.trim();
    }
}