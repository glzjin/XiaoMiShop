package com.offcn.pojo;

public class ItemsWithBLOBs extends Items {
    private String itemDescription;

    private String itemImgUri;

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription == null ? null : itemDescription.trim();
    }

    public String getItemImgUri() {
        return itemImgUri;
    }

    public void setItemImgUri(String itemImgUri) {
        this.itemImgUri = itemImgUri == null ? null : itemImgUri.trim();
    }
}