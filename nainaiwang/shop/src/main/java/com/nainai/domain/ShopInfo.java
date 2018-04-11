package com.nainai.domain;

import java.util.Date;

public class ShopInfo {
    private String id;

    private Integer userId;

    private String logo;

    private String name;

    private String synopsis;

    private String mainProject;

    private String mainSupplies;

    private String introduce;

    private Integer authentication;

    private String operatingAddress;

    private String contactAddress;

    private Integer sort;

    private String remarks;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis == null ? null : synopsis.trim();
    }

    public String getMainProject() {
        return mainProject;
    }

    public void setMainProject(String mainProject) {
        this.mainProject = mainProject == null ? null : mainProject.trim();
    }

    public String getMainSupplies() {
        return mainSupplies;
    }

    public void setMainSupplies(String mainSupplies) {
        this.mainSupplies = mainSupplies == null ? null : mainSupplies.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Integer getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
    }

    public String getOperatingAddress() {
        return operatingAddress;
    }

    public void setOperatingAddress(String operatingAddress) {
        this.operatingAddress = operatingAddress == null ? null : operatingAddress.trim();
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress == null ? null : contactAddress.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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