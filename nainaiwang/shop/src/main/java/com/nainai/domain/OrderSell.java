package com.nainai.domain;

import java.math.BigDecimal;
import java.util.Date;

public class OrderSell {
    private Integer id;

    private String shopId;

    private String offerNo;

    private Integer offerId;

    private Integer mode;

    private String orderNo;

    private BigDecimal num;

    private BigDecimal amount;

    private Integer userId;

    private BigDecimal payDeposit;

    private String buyerDepositPayment;

    private Date payDepositTime;

    private String buyerDepositClientid;

    private BigDecimal payRetainage;

    private String retainagePayment;

    private String retainageClientid;

    private Integer payment;

    private Integer contractStatus;

    private BigDecimal sellerDeposit;

    private String sellerDepositPayment;

    private String sellerDepositClientid;

    private String proof;

    private String jiesuanProve;

    private BigDecimal reduceAmount;

    private String reduceRemark;

    private Integer invoice;

    private Date createTime;

    private Date endTime;

    private Integer isLock;

    private String risk;

    private String complateProve;

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

    public String getOfferNo() {
        return offerNo;
    }

    public void setOfferNo(String offerNo) {
        this.offerNo = offerNo == null ? null : offerNo.trim();
    }

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getPayDeposit() {
        return payDeposit;
    }

    public void setPayDeposit(BigDecimal payDeposit) {
        this.payDeposit = payDeposit;
    }

    public String getBuyerDepositPayment() {
        return buyerDepositPayment;
    }

    public void setBuyerDepositPayment(String buyerDepositPayment) {
        this.buyerDepositPayment = buyerDepositPayment == null ? null : buyerDepositPayment.trim();
    }

    public Date getPayDepositTime() {
        return payDepositTime;
    }

    public void setPayDepositTime(Date payDepositTime) {
        this.payDepositTime = payDepositTime;
    }

    public String getBuyerDepositClientid() {
        return buyerDepositClientid;
    }

    public void setBuyerDepositClientid(String buyerDepositClientid) {
        this.buyerDepositClientid = buyerDepositClientid == null ? null : buyerDepositClientid.trim();
    }

    public BigDecimal getPayRetainage() {
        return payRetainage;
    }

    public void setPayRetainage(BigDecimal payRetainage) {
        this.payRetainage = payRetainage;
    }

    public String getRetainagePayment() {
        return retainagePayment;
    }

    public void setRetainagePayment(String retainagePayment) {
        this.retainagePayment = retainagePayment == null ? null : retainagePayment.trim();
    }

    public String getRetainageClientid() {
        return retainageClientid;
    }

    public void setRetainageClientid(String retainageClientid) {
        this.retainageClientid = retainageClientid == null ? null : retainageClientid.trim();
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(Integer contractStatus) {
        this.contractStatus = contractStatus;
    }

    public BigDecimal getSellerDeposit() {
        return sellerDeposit;
    }

    public void setSellerDeposit(BigDecimal sellerDeposit) {
        this.sellerDeposit = sellerDeposit;
    }

    public String getSellerDepositPayment() {
        return sellerDepositPayment;
    }

    public void setSellerDepositPayment(String sellerDepositPayment) {
        this.sellerDepositPayment = sellerDepositPayment == null ? null : sellerDepositPayment.trim();
    }

    public String getSellerDepositClientid() {
        return sellerDepositClientid;
    }

    public void setSellerDepositClientid(String sellerDepositClientid) {
        this.sellerDepositClientid = sellerDepositClientid == null ? null : sellerDepositClientid.trim();
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof == null ? null : proof.trim();
    }

    public String getJiesuanProve() {
        return jiesuanProve;
    }

    public void setJiesuanProve(String jiesuanProve) {
        this.jiesuanProve = jiesuanProve == null ? null : jiesuanProve.trim();
    }

    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public String getReduceRemark() {
        return reduceRemark;
    }

    public void setReduceRemark(String reduceRemark) {
        this.reduceRemark = reduceRemark == null ? null : reduceRemark.trim();
    }

    public Integer getInvoice() {
        return invoice;
    }

    public void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk == null ? null : risk.trim();
    }

    public String getComplateProve() {
        return complateProve;
    }

    public void setComplateProve(String complateProve) {
        this.complateProve = complateProve == null ? null : complateProve.trim();
    }
}