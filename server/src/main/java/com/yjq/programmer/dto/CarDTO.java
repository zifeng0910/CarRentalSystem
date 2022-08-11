package com.yjq.programmer.dto;

import com.yjq.programmer.annotation.ValidateEntity;

import java.math.BigDecimal;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-13 8:27
 */
public class CarDTO {

    private String id;

    @ValidateEntity(required=true,requiredMaxLength=true,requiredMinLength=true,maxLength=16,minLength=1,errorRequiredMsg="汽车名称不能为空！",errorMaxLengthMsg="汽车名称长度不能大于16！",errorMinLengthMsg="汽车名称不能为空！")
    private String name;

    @ValidateEntity(required=true,requiredMaxLength=true,requiredMinLength=true,maxLength=8,minLength=1,errorRequiredMsg="上市时间不能为空！",errorMaxLengthMsg="上市时间长度不能大于8！",errorMinLengthMsg="上市时间不能为空！")
    private String time;

    @ValidateEntity(required=true,requiredMaxLength=true,requiredMinLength=true,maxLength=8,minLength=1,errorRequiredMsg="汽车品牌不能为空！",errorMaxLengthMsg="汽车品牌长度不能大于8！",errorMinLengthMsg="汽车品牌不能为空！")
    private String brand;

    @ValidateEntity(required=true,requiredMaxLength=true,requiredMinLength=true,maxLength=8,minLength=1,errorRequiredMsg="汽车档位不能为空！",errorMaxLengthMsg="汽车档位长度不能大于8！",errorMinLengthMsg="汽车档位不能为空！")
    private String gear;

    @ValidateEntity(required=true,requiredMaxLength=true,requiredMinLength=true,maxLength=8,minLength=1,errorRequiredMsg="汽车座位不能为空！",errorMaxLengthMsg="汽车座位长度不能大于8！",errorMinLengthMsg="汽车座位不能为空！")
    private String seat;

    @ValidateEntity(required=true,requiredMaxValue=true,requiredMinValue=true,maxValue=99999999.99,minValue=0.00,errorRequiredMsg="每日租金不能为空！",errorMaxValueMsg="每日租金不能大于99999999.99元！",errorMinValueMsg="每日租金不能小于0.00元！")
    private BigDecimal dayPrice;

    @ValidateEntity(required=true,requiredMaxLength=true,requiredMinLength=true,maxLength=8,minLength=1,errorRequiredMsg="汽车厢位不能为空！",errorMaxLengthMsg="汽车厢位长度不能大于8！",errorMinLengthMsg="汽车厢位不能为空！")
    private String cartonNum;

    @ValidateEntity(required=true,requiredMaxLength=true,requiredMinLength=true,maxLength=32,minLength=1,errorRequiredMsg="取车地点不能为空！",errorMaxLengthMsg="取车地点长度不能大于32！",errorMinLengthMsg="取车地点不能为空！")
    private String pickPlace;

    @ValidateEntity(required=true,requiredMaxLength=true,requiredMinLength=true,maxLength=32,minLength=1,errorRequiredMsg="还车地点不能为空！",errorMaxLengthMsg="还车地点长度不能大于32！",errorMinLengthMsg="还车地点不能为空！")
    private String returnPlace;

    private Integer state;

    @ValidateEntity(required=true,errorRequiredMsg="汽车所属销售不能为空！")
    private String userId;

    private UserDTO userDTO;

    private String photo;

    @ValidateEntity(required=true,requiredMaxValue=true,requiredMinValue=true,maxValue=99999999.99,minValue=0.00,errorRequiredMsg="汽车押金不能为空！",errorMaxValueMsg="汽车押金不能大于99999999.99元！",errorMinValueMsg="汽车押金不能小于0.00元！")
    private BigDecimal pledgePrice;

    private String token;

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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
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
        sb.append(", userDTO=").append(userDTO);
        sb.append(", token=").append(token);
        sb.append("]");
        return sb.toString();
    }
}
