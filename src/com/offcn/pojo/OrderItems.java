package com.offcn.pojo;

import java.math.BigDecimal;

public class OrderItems {
    private Integer orderId;

    private Integer itemId;

    private BigDecimal itemCurrentPrice;

    private Integer itemAmount;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getItemCurrentPrice() {
        return itemCurrentPrice;
    }

    public void setItemCurrentPrice(BigDecimal itemCurrentPrice) {
        this.itemCurrentPrice = itemCurrentPrice;
    }

    public Integer getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(Integer itemAmount) {
        this.itemAmount = itemAmount;
    }
}