package com.yjq.programmer.enums;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-15 8:51
 */
public enum RentalStateEnum {

    SUCCESS(1,"审核通过"),

    RENTAL(2,"租赁中"),

    FINISH(3,"租赁完成"),

    CANCEL(4,"已取消"),

    WAIT(5,"等待审核"),

    FAIL(6,"审核不通过")

    ;

    Integer code;

    String desc;

    RentalStateEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
