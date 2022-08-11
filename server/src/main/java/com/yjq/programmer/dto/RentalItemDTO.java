package com.yjq.programmer.dto;

import com.yjq.programmer.annotation.ValidateEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-16 8:49
 */
public class RentalItemDTO {

    private String id;

    @ValidateEntity(required=true,requiredMaxLength=true,requiredMinLength=true,maxLength=128,minLength=1,errorRequiredMsg="详情内容不能为空！",errorMaxLengthMsg="详情内容长度不能大于128！",errorMinLengthMsg="详情内容不能为空！")
    private String info;

    private Date createTime;

    private String rentalId;

    @ValidateEntity(required=true,errorRequiredMsg="记录类型不能为空！")
    private Integer type;

    @ValidateEntity(required=true,requiredMaxValue=true,requiredMinValue=true,maxValue=99999999.99,minValue=0.00,errorRequiredMsg="赔偿金额不能为空！",errorMaxValueMsg="赔偿金额不能大于99999999.99元！",errorMinValueMsg="赔偿金额不能小于0.00元！")
    private BigDecimal price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRentalId() {
        return rentalId;
    }

    public void setRentalId(String rentalId) {
        this.rentalId = rentalId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", info=").append(info);
        sb.append(", createTime=").append(createTime);
        sb.append(", rentalId=").append(rentalId);
        sb.append(", type=").append(type);
        sb.append(", price=").append(price);
        sb.append("]");
        return sb.toString();
    }
}
