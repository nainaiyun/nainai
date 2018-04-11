package com.nainai.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ProductOffer {
    private Integer id;

    private String shopId;

    private String classifyId;

    private String moduleId;

    private String navigationId;

    private String offerNo;

    private Integer userId;

    private Integer type;

    private Integer mode;

    private Byte subMode;

    private Integer productId;

    private String proName;

    private Integer oldOffer;

    private BigDecimal price;

    private BigDecimal priceL;

    private BigDecimal priceR;

    private Integer divide;

    private BigDecimal minimum;

    private BigDecimal minstep;

    private String acceptArea;

    private Integer acceptDay;

    private String accType;

    private BigDecimal offerFee;

    private String sign;

    private Integer status;

    private Integer isDel;

    private Date applyTime;

    private Date finishTime;

    private Date expireTime;

    private Integer kefu;

    private String risk;

    private Integer insurance;

    private String adminMsg;

    private String other;

    private String weightType;

    private Date startTime;

    private Date endTime;

    private BigDecimal maxNum;

    private BigDecimal sellNum;

    private BigDecimal jingStepprice;

    private Integer offerSort;

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

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId == null ? null : classifyId.trim();
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId == null ? null : moduleId.trim();
    }

    public String getNavigationId() {
        return navigationId;
    }

    public void setNavigationId(String navigationId) {
        this.navigationId = navigationId == null ? null : navigationId.trim();
    }

    public String getOfferNo() {
        return offerNo;
    }

    public void setOfferNo(String offerNo) {
        this.offerNo = offerNo == null ? null : offerNo.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public Byte getSubMode() {
        return subMode;
    }

    public void setSubMode(Byte subMode) {
        this.subMode = subMode;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public Integer getOldOffer() {
        return oldOffer;
    }

    public void setOldOffer(Integer oldOffer) {
        this.oldOffer = oldOffer;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceL() {
        return priceL;
    }

    public void setPriceL(BigDecimal priceL) {
        this.priceL = priceL;
    }

    public BigDecimal getPriceR() {
        return priceR;
    }

    public void setPriceR(BigDecimal priceR) {
        this.priceR = priceR;
    }

    public Integer getDivide() {
        return divide;
    }

    public void setDivide(Integer divide) {
        this.divide = divide;
    }

    public BigDecimal getMinimum() {
        return minimum;
    }

    public void setMinimum(BigDecimal minimum) {
        this.minimum = minimum;
    }

    public BigDecimal getMinstep() {
        return minstep;
    }

    public void setMinstep(BigDecimal minstep) {
        this.minstep = minstep;
    }

    public String getAcceptArea() {
        return acceptArea;
    }

    public void setAcceptArea(String acceptArea) {
        this.acceptArea = acceptArea == null ? null : acceptArea.trim();
    }

    public Integer getAcceptDay() {
        return acceptDay;
    }

    public void setAcceptDay(Integer acceptDay) {
        this.acceptDay = acceptDay;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType == null ? null : accType.trim();
    }

    public BigDecimal getOfferFee() {
        return offerFee;
    }

    public void setOfferFee(BigDecimal offerFee) {
        this.offerFee = offerFee;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getKefu() {
        return kefu;
    }

    public void setKefu(Integer kefu) {
        this.kefu = kefu;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk == null ? null : risk.trim();
    }

    public Integer getInsurance() {
        return insurance;
    }

    public void setInsurance(Integer insurance) {
        this.insurance = insurance;
    }

    public String getAdminMsg() {
        return adminMsg;
    }

    public void setAdminMsg(String adminMsg) {
        this.adminMsg = adminMsg == null ? null : adminMsg.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getWeightType() {
        return weightType;
    }

    public void setWeightType(String weightType) {
        this.weightType = weightType == null ? null : weightType.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(BigDecimal maxNum) {
        this.maxNum = maxNum;
    }

    public BigDecimal getSellNum() {
        return sellNum;
    }

    public void setSellNum(BigDecimal sellNum) {
        this.sellNum = sellNum;
    }

    public BigDecimal getJingStepprice() {
        return jingStepprice;
    }

    public void setJingStepprice(BigDecimal jingStepprice) {
        this.jingStepprice = jingStepprice;
    }

    public Integer getOfferSort() {
        return offerSort;
    }

    public void setOfferSort(Integer offerSort) {
        this.offerSort = offerSort;
    }
}