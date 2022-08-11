package com.yjq.programmer.enums;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2022-06-09 11:44
 */
public enum RoleEnum {

    CUSTOMER("ghakX3if","客户"),

    SELLER("rTPGL52v","销售"),

    ADMIN("bOkASbHt","管理员"),

    ;

    String code;

    String desc;

    RoleEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
