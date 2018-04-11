package com.nainai.domain;

import java.util.Date;

public class ShopBrowse {
    private String id;

    private String shopId;

    private String name;

    private Integer totalBrowsing;

    private Integer monthlyBrowsing;

    private String remarks;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTotalBrowsing() {
        return totalBrowsing;
    }

    public void setTotalBrowsing(Integer totalBrowsing) {
        this.totalBrowsing = totalBrowsing;
    }

    public Integer getMonthlyBrowsing() {
        return monthlyBrowsing;
    }

    public void setMonthlyBrowsing(Integer monthlyBrowsing) {
        this.monthlyBrowsing = monthlyBrowsing;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}