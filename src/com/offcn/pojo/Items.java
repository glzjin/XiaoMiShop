package com.offcn.pojo;

import java.math.BigDecimal;

public class Items {
    private Integer id;

    private String itemName;

    private BigDecimal itemPrice;

    private Integer itemSku;

    private Integer itemSold;

    private Byte status;

    private Integer itemCategoryId;

    private Byte isHot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getItemSku() {
        return itemSku;
    }

    public void setItemSku(Integer itemSku) {
        this.itemSku = itemSku;
    }

    public Integer getItemSold() {
        return itemSold;
    }

    public void setItemSold(Integer itemSold) {
        this.itemSold = itemSold;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(Integer itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public Byte getIsHot() {
        return isHot;
    }

    public void setIsHot(Byte isHot) {
        this.isHot = isHot;
    }
}