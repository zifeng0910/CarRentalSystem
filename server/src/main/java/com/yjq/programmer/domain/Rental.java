package com.yjq.programmer.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Rental {
    private String id;

    private Date createTime;

    private String userId;

    private String carId;

    private Integer state;

    private Date startTime;

    private Date endTime;

    private BigDecimal totalPrice;

    private String name;

    private String photo;

    private BigDecimal dayPrice;

    private BigDecimal pledgePrice;

    private Integer rentalDay;

    private String reply;

    private String no;

    private String sellerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public BigDecimal getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(BigDecimal dayPrice) {
        this.dayPrice = dayPrice;
    }

    public BigDecimal getPledgePrice() {
        return pledgePrice;
    }

    public void setPledgePrice(BigDecimal pledgePrice) {
        this.pledgePrice = pledgePrice;
    }

    public Integer getRentalDay() {
        return rentalDay;
    }

    public void setRentalDay(Integer rentalDay) {
        this.rentalDay = rentalDay;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", userId=").append(userId);
        sb.append(", carId=").append(carId);
        sb.append(", state=").append(state);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", name=").append(name);
        sb.append(", photo=").append(photo);
        sb.append(", dayPrice=").append(dayPrice);
        sb.append(", pledgePrice=").append(pledgePrice);
        sb.append(", rentalDay=").append(rentalDay);
        sb.append(", reply=").append(reply);
        sb.append(", no=").append(no);
        sb.append(", sellerId=").append(sellerId);
        sb.append("]");
        return sb.toString();
    }
}