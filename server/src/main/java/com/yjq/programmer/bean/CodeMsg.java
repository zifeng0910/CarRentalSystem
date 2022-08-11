package com.yjq.programmer.bean;

/**
 * @author 杨杨吖
 * @QQ 823208782
 * @WX yjqi12345678
 * @create 2020-09-19 23:14
 */

/**
 * 错误码统一处理类，所有的错误码统一定义在这里
 */
public class CodeMsg {

    private Integer code;//错误码

    private String msg;//错误信息

    /**
     * 构造函数私有化即单例模式
     * 该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。
     * @param code
     * @param msg
     */
    private CodeMsg(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public CodeMsg() {

    }

    public Integer getCode() {
        return code;
    }



    public void setCode(Integer code) {
        this.code = code;
    }



    public String getMsg() {
        return msg;
    }



    public void setMsg(String msg) {
        this.msg = msg;
    }

    //通用错误码定义
    //处理成功消息码
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    //通用数据错误码
    public static CodeMsg DATA_ERROR = new CodeMsg(-1, "非法数据！");
    public static CodeMsg VALIDATE_ENTITY_ERROR = new CodeMsg(-2, "");
    public static CodeMsg CAPTCHA_EMPTY = new CodeMsg(-3, "验证码不能为空!");
    public static CodeMsg NO_PERMISSION = new CodeMsg(-4, "您没有当前操作的权限哦！");
    public static CodeMsg CAPTCHA_ERROR = new CodeMsg(-5, "验证码错误！");
    public static CodeMsg USER_SESSION_EXPIRED = new CodeMsg(-6, "还未登录或会话失效，请重新登录！");
    public static CodeMsg UPLOAD_PHOTO_SUFFIX_ERROR = new CodeMsg(-7, "图片格式不正确！");
    public static CodeMsg PHOTO_SURPASS_MAX_SIZE = new CodeMsg(-8, "上传的图片不能超过1MB！");
    public static CodeMsg PHOTO_FORMAT_NOT_CORRECT = new CodeMsg(-9, "上传的图片格式不正确！");
    public static CodeMsg SAVE_FILE_EXCEPTION = new CodeMsg(-10, "保存文件异常！");
    public static CodeMsg FILE_EXPORT_ERROR = new CodeMsg(-11, "文件导出失败！");
    public static CodeMsg SYSTEM_ERROR = new CodeMsg(-12, "系统出现了错误，请联系管理员！");
    public static CodeMsg NO_AUTHORITY = new CodeMsg(-13, "不好意思，您没有权限操作哦！");
    public static CodeMsg CAPTCHA_EXPIRED = new CodeMsg(-14, "验证码已过期，请刷新验证码！");
    public static CodeMsg COMMON_ERROR = new CodeMsg(-15, "");
    public static CodeMsg PHOTO_EMPTY = new CodeMsg(-16, "上传的图片不能为空！");


    //用户管理类错误码
    public static CodeMsg USER_ADD_ERROR = new CodeMsg(-1000, "用户信息添加失败，请联系管理员！");
    public static CodeMsg USER_NOT_EXIST  = new CodeMsg(-1001, "该用户不存在！");
    public static CodeMsg USER_EDIT_ERROR = new CodeMsg(-1002, "用户信息编辑失败，请联系管理员！");
    public static CodeMsg USER_DELETE_ERROR = new CodeMsg(-1003, "用户信息删除失败，请联系管理员！");
    public static CodeMsg USERNAME_EXIST = new CodeMsg(-1004, "用户名称重复，请换一个！");
    public static CodeMsg USERNAME_EMPTY = new CodeMsg(-1005, "用户名称不能为空！");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(-1006, "用户密码不能为空！");
    public static CodeMsg USERNAME_PASSWORD_ERROR = new CodeMsg(-1007, "用户名称或密码错误！");
    public static CodeMsg REPASSWORD_EMPTY = new CodeMsg(-1008, "确认密码不能为空！");
    public static CodeMsg REPASSWORD_ERROR = new CodeMsg(-1009, "确认密码不一致！");
    public static CodeMsg USER_REGISTER_ERROR = new CodeMsg(-1010, "注册用户失败，请联系管理员！");
    public static CodeMsg USER_NOT_IS_ADMIN = new CodeMsg(-1011, "只有管理员角色才能登录后台系统！");
    public static CodeMsg ROLE_EMPTY = new CodeMsg(-1012, "用户角色不能为空！");


    //角色管理类错误码
    public static CodeMsg ROLE_NAME_EXIST = new CodeMsg(-2000, "角色名称已存在，请换一个！");
    public static CodeMsg ROLE_ADD_ERROR = new CodeMsg(-2001, "添加角色信息失败，请联系管理员！");
    public static CodeMsg ROLE_EDIT_ERROR = new CodeMsg(-2002, "修改角色信息失败，请联系管理员！");
    public static CodeMsg ROLE_DELETE_ERROR = new CodeMsg(-2003, "删除角色信息失败，请联系管理员！");
    public static CodeMsg AUTHORITY_SAVE_ERROR = new CodeMsg(-2004, "保存权限信息失败，请联系管理员！");
    public static CodeMsg BASE_ROLE_CHANGE = new CodeMsg(-2005, "系统基本角色(客户、销售、管理员)不允许修改或删除！");

    //汽车管理类错误码
    public static CodeMsg CAR_ADD_ERROR = new CodeMsg(-3000, "添加汽车信息失败，请联系管理员！");
    public static CodeMsg CAR_EDIT_ERROR = new CodeMsg(-3001, "修改汽车信息失败，请联系管理员！");
    public static CodeMsg CAR_DELETE_ERROR = new CodeMsg(-3002, "删除汽车信息失败，请联系管理员！");
    public static CodeMsg CAR_NOT_EXIST = new CodeMsg(-3003, "该汽车已不存在！");

    //租赁管理类错误码
    public static CodeMsg RENTAL_ADD_ERROR = new CodeMsg(-4000, "添加租赁信息失败，请联系管理员！");
    public static CodeMsg RENTAL_EDIT_ERROR = new CodeMsg(-4001, "修改租赁信息失败，请联系管理员！");
    public static CodeMsg RENTAL_DELETE_ERROR = new CodeMsg(-4002, "删除租赁信息失败，请联系管理员！");
    public static CodeMsg START_TIME_ILLEGAL = new CodeMsg(-4003, "租赁开始时间不能小于当前时间！");
    public static CodeMsg CAR_ALREADY_RENTAL = new CodeMsg(-4004, "不好意思，来晚了哦，这车已经出租了！");
    public static CodeMsg REPLY_ERROR = new CodeMsg(-4005, "审核信息失败，请联系管理员！");

    //租赁记录管理类错误码
    public static CodeMsg RENTAL_ITEM_ADD_ERROR = new CodeMsg(-5000, "添加租赁记录信息失败，请联系管理员！");
    public static CodeMsg RENTAL_ITEM_EDIT_ERROR = new CodeMsg(-5001, "修改租赁记录信息失败，请联系管理员！");
    public static CodeMsg RENTAL_ITEM_DELETE_ERROR = new CodeMsg(-5002, "删除租赁记录信息失败，请联系管理员！");

    //评价管理类错误码
    public static CodeMsg COMMENT_ADD_ERROR = new CodeMsg(-6000, "评价租赁体验失败，请联系管理员！");
    public static CodeMsg COMMENT_DELETE_ERROR = new CodeMsg(-6001, "删除评价信息失败，请联系管理员！");
    public static CodeMsg COMMENT_ALREADY_EXIST = new CodeMsg(-6002, "请勿重复评论！");
}
