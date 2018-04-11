package com.nainai.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Bid {
    private Integer id;

    private String shopId;

    private String no;

    private String mode;

    private Integer userId;

    private String yqUser;

    private String doc;

    private Integer topCate;

    private String proName;

    private String proAddress;

    private Date beginTime;

    private Date endTime;

    private Date openTime;

    private String bidRequire;

    private String proBrief;

    private String bidContent;

    private Integer packType;

    private String eq;

    private Date docBegin;

    private BigDecimal docPrice;

    private BigDecimal supplyBail;

    private Integer openWay;

    private String payWay;

    private String other;

    private String bidPerson;

    private String contPerson;

    private String contAddress;

    private String contEmail;

    private String contPhone;

    private String contTax;

    private String agent;

    private String agentPerson;

    private String agentAddress;

    private String agentEmail;

    private String agentPhone;

    private String agentTax;

    private BigDecimal bail;

    private String bailPayWay;

    private Integer bailIsRefund;

    private Integer status;

    private Date createTime;

    private Integer admin;

    private String adminMessage;

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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode == null ? null : mode.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getYqUser() {
        return yqUser;
    }

    public void setYqUser(String yqUser) {
        this.yqUser = yqUser == null ? null : yqUser.trim();
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc == null ? null : doc.trim();
    }

    public Integer getTopCate() {
        return topCate;
    }

    public void setTopCate(Integer topCate) {
        this.topCate = topCate;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public String getProAddress() {
        return proAddress;
    }

    public void setProAddress(String proAddress) {
        this.proAddress = proAddress == null ? null : proAddress.trim();
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public String getBidRequire() {
        return bidRequire;
    }

    public void setBidRequire(String bidRequire) {
        this.bidRequire = bidRequire == null ? null : bidRequire.trim();
    }

    public String getProBrief() {
        return proBrief;
    }

    public void setProBrief(String proBrief) {
        this.proBrief = proBrief == null ? null : proBrief.trim();
    }

    public String getBidContent() {
        return bidContent;
    }

    public void setBidContent(String bidContent) {
        this.bidContent = bidContent == null ? null : bidContent.trim();
    }

    public Integer getPackType() {
        return packType;
    }

    public void setPackType(Integer packType) {
        this.packType = packType;
    }

    public String getEq() {
        return eq;
    }

    public void setEq(String eq) {
        this.eq = eq == null ? null : eq.trim();
    }

    public Date getDocBegin() {
        return docBegin;
    }

    public void setDocBegin(Date docBegin) {
        this.docBegin = docBegin;
    }

    public BigDecimal getDocPrice() {
        return docPrice;
    }

    public void setDocPrice(BigDecimal docPrice) {
        this.docPrice = docPrice;
    }

    public BigDecimal getSupplyBail() {
        return supplyBail;
    }

    public void setSupplyBail(BigDecimal supplyBail) {
        this.supplyBail = supplyBail;
    }

    public Integer getOpenWay() {
        return openWay;
    }

    public void setOpenWay(Integer openWay) {
        this.openWay = openWay;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getBidPerson() {
        return bidPerson;
    }

    public void setBidPerson(String bidPerson) {
        this.bidPerson = bidPerson == null ? null : bidPerson.trim();
    }

    public String getContPerson() {
        return contPerson;
    }

    public void setContPerson(String contPerson) {
        this.contPerson = contPerson == null ? null : contPerson.trim();
    }

    public String getContAddress() {
        return contAddress;
    }

    public void setContAddress(String contAddress) {
        this.contAddress = contAddress == null ? null : contAddress.trim();
    }

    public String getContEmail() {
        return contEmail;
    }

    public void setContEmail(String contEmail) {
        this.contEmail = contEmail == null ? null : contEmail.trim();
    }

    public String getContPhone() {
        return contPhone;
    }

    public void setContPhone(String contPhone) {
        this.contPhone = contPhone == null ? null : contPhone.trim();
    }

    public String getContTax() {
        return contTax;
    }

    public void setContTax(String contTax) {
        this.contTax = contTax == null ? null : contTax.trim();
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent == null ? null : agent.trim();
    }

    public String getAgentPerson() {
        return agentPerson;
    }

    public void setAgentPerson(String agentPerson) {
        this.agentPerson = agentPerson == null ? null : agentPerson.trim();
    }

    public String getAgentAddress() {
        return agentAddress;
    }

    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress == null ? null : agentAddress.trim();
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail == null ? null : agentEmail.trim();
    }

    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone == null ? null : agentPhone.trim();
    }

    public String getAgentTax() {
        return agentTax;
    }

    public void setAgentTax(String agentTax) {
        this.agentTax = agentTax == null ? null : agentTax.trim();
    }

    public BigDecimal getBail() {
        return bail;
    }

    public void setBail(BigDecimal bail) {
        this.bail = bail;
    }

    public String getBailPayWay() {
        return bailPayWay;
    }

    public void setBailPayWay(String bailPayWay) {
        this.bailPayWay = bailPayWay == null ? null : bailPayWay.trim();
    }

    public Integer getBailIsRefund() {
        return bailIsRefund;
    }

    public void setBailIsRefund(Integer bailIsRefund) {
        this.bailIsRefund = bailIsRefund;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public String getAdminMessage() {
        return adminMessage;
    }

    public void setAdminMessage(String adminMessage) {
        this.adminMessage = adminMessage == null ? null : adminMessage.trim();
    }
}