package com.xzy.pojo;

public class Address {
    private Integer addressId;

    private Integer userId;

    private String userhome;

    private String recName;

    private Integer postId;

    private String recPhone;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserhome() {
        return userhome;
    }

    public void setUserhome(String userhome) {
        this.userhome = userhome == null ? null : userhome.trim();
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName == null ? null : recName.trim();
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getRecPhone() {
        return recPhone;
    }

    public void setRecPhone(String recPhone) {
        this.recPhone = recPhone == null ? null : recPhone.trim();
    }
}