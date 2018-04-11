package com.nainai.domain;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private Integer id;

    private String shopId;

    private Byte type;

    private String username;

    private String trueName;

    private String password;

    private BigDecimal credit;

    private String mobile;

    private String email;

    private String headPhoto;

    private Integer pid;

    private Integer roles;

    private Short status;

    private Integer agent;

    private String agentPass;

    private Date createTime;

    private Date loginTime;

    private String sessionId;

    private Integer certStatus;

    private String gid;

    private String paySecret;

    private Integer yewu;

    private String loginIp;

    private String userNo;

    private Boolean vip;

    private Integer isFalse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getHeadPhoto() {
        return headPhoto;
    }

    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto == null ? null : headPhoto.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getRoles() {
        return roles;
    }

    public void setRoles(Integer roles) {
        this.roles = roles;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getAgent() {
        return agent;
    }

    public void setAgent(Integer agent) {
        this.agent = agent;
    }

    public String getAgentPass() {
        return agentPass;
    }

    public void setAgentPass(String agentPass) {
        this.agentPass = agentPass == null ? null : agentPass.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    public Integer getCertStatus() {
        return certStatus;
    }

    public void setCertStatus(Integer certStatus) {
        this.certStatus = certStatus;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    public String getPaySecret() {
        return paySecret;
    }

    public void setPaySecret(String paySecret) {
        this.paySecret = paySecret == null ? null : paySecret.trim();
    }

    public Integer getYewu() {
        return yewu;
    }

    public void setYewu(Integer yewu) {
        this.yewu = yewu;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public Boolean getVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    public Integer getIsFalse() {
        return isFalse;
    }

    public void setIsFalse(Integer isFalse) {
        this.isFalse = isFalse;
    }
}