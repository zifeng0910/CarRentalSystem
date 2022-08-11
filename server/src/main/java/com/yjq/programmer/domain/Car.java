package com.yjq.programmer.domain;

import java.math.BigDecimal;

public class Car {
    private String id;

    private String name;

    private String time;

    private String brand;

    private String gear;

    private String seat;

    private BigDecimal dayPrice;

    private String cartonNum;

    private String pickPlace;

    private String returnPlace;

    private Integer state;

    private String userId;

    private String photo;

    private BigDecimal pledgePrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public BigDecimal getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(BigDecimal dayPrice) {
        this.dayPrice = dayPrice;
    }

    public String getCartonNum() {
        return cartonNum;
    }

    public void setCartonNum(String cartonNum) {
        this.cartonNum = cartonNum;
    }

    public String getPickPlace() {
        return pickPlace;
    }

    public void setPickPlace(String pickPlace) {
        this.pickPlace = pickPlace;
    }

    public String getReturnPlace() {
        return returnPlace;
    }

    public void setReturnPlace(String returnPlace) {
        this.returnPlace = returnPlace;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public BigDecimal getPledgePrice() {
        return pledgePrice;
    }

    public void setPledgePrice(BigDecimal pledgePrice) {
        this.pledgePrice = pledgePrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", time=").append(time);
        sb.append(", brand=").append(brand);
        sb.append(", gear=").append(gear);
        sb.append(", seat=").append(seat);
        sb.append(", dayPrice=").append(dayPrice);
        sb.append(", cartonNum=").append(cartonNum);
        sb.append(", pickPlace=").append(pickPlace);
        sb.append(", returnPlace=").append(returnPlace);
        sb.append(", state=").append(state);
        sb.append(", userId=").append(userId);
        sb.append(", photo=").append(photo);
        sb.append(", pledgePrice=").append(pledgePrice);
        sb.append("]");
        return sb.toString();
    }
}