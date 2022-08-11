package com.yjq.programmer.dto;

import com.yjq.programmer.annotation.ValidateEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-15 8:54
 */
public class RentalDTO {

    private String id;

    private Date createTime;

    private String userId;

    private UserDTO userDTO;

    private String carId;

    private Integer state;

    @ValidateEntity(required=true,errorRequiredMsg="租赁开始时间不能为空！")
    private Date startTime;

    @ValidateEntity(required=true,errorRequiredMsg="租赁结束时间不能为空！")
    private Date endTime;

    private BigDecimal totalPrice;

    private String name;

    private String photo;

    private BigDecimal dayPrice;

    private BigDecimal pledgePrice;

    private Integer rentalDay;

    @ValidateEntity(required=true,requiredMaxLength=true,maxLength=128,errorRequiredMsg="审核回复不能为空！",errorMaxLengthMsg="审核回复长度不能大于128！")
    private String reply;

    private String no;

    private String sellerId;

    private UserDTO sellerDTO;

    private String token;

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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public UserDTO getSellerDTO() {
        return sellerDTO;
    }

    public void setSellerDTO(UserDTO sellerDTO) {
        this.sellerDTO = sellerDTO;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
        sb.append(", userDTO=").append(userDTO);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", sellerDTO=").append(sellerDTO);
        sb.append(", token=").append(token);
        sb.append("]");
        return sb.toString();
    }
}
