package com.gbicc.person.creditMemo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单
 * @author monstar..lzq
 *
 */
public class Order implements Serializable{

	private static final long serialVersionUID = 49538603048610790L;
	
    private String orderId;// id
    private Date createTime;// 创建时间
    private String shippingName;// 物流名称
    private String shippingCode;// 物流单号
    private String userId;// 用户id
    private String receiver; // 收货人全名
    private String receiverMobile; // 移动电话
    private String receiverState; // 省份
    private String receiverCity; // 城市
    private String receiverAddress; // 收货地址，如：xx路xx号
    private String receiverZip; // 邮政编码,如：310001
    private Integer invoiceType;// 发票类型，0无发票，1普通发票，2电子发票，3增值税发票
    private Integer sourceType;// 订单来源 1:app端，2：pc端，3：M端，4：微信端，5：手机qq端
    
    public Order() {
    }

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public Order(String orderId, Date createTime, String shippingName, String shippingCode, String userId, String receiver, String receiverMobile, String receiverState, String receiverCity, String receiverAddress, String receiverZip, Integer invoiceType, Integer sourceType) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.shippingName = shippingName;
        this.shippingCode = shippingCode;
        this.userId = userId;
        this.receiver = receiver;
        this.receiverMobile = receiverMobile;
        this.receiverState = receiverState;
        this.receiverCity = receiverCity;
        this.receiverAddress = receiverAddress;
        this.receiverZip = receiverZip;
        this.invoiceType = invoiceType;
        this.sourceType = sourceType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverState() {
        return receiverState;
    }

    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }
	
}
