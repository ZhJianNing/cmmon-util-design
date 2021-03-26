package com.zjn.util.message;

import java.util.HashMap;
import java.util.Map;

public enum Message {

    Success(200, "成功"),
    Auth_Error(4001, "权限校验未通过"),
    Param_Error(4002, "参数错误"),
    Username_Error(4003, "用户名已注册"),
    Password_Error(4004, "密码不合规"),
    Fail_Error(4005, "操作失败"),
    Login_Error(4006, "用户名或密码错误"),
    Captcha_Error(4007, "验证码错误"),
    Other_Error(5001, "未知异常");


    private Message(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code;

    public String msg;

    public static final String KEY_CODE = "code";
    public static final String KEY_MSG = "message";
    public static final String KEY_DATA = "data";
    public static final String KEY_PAGENUMBER = "pageNumber";
    public static final String KEY_PAGESIZE = "pageSize";
    public static final String KEY_TOTALPAGENUMBER = "totalPageNumber";
    public static final String KEY_TOTALDATACOUNT = "totalDataCount";

    public Map<String, Object> createWithData(Object data) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(KEY_CODE, code);
        result.put(KEY_MSG, msg);
        result.put(KEY_DATA, data);
        return result;
    }

    public Map<String, Object> createWithList(Object list, long pageNumber, int pageSize, long totalNumber) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(KEY_CODE, code);
        result.put(KEY_MSG, msg);
        result.put(KEY_DATA, list);
        result.put(KEY_PAGENUMBER, pageNumber);
        result.put(KEY_PAGESIZE, pageSize);

        long totalPageNumber = (totalNumber % pageSize == 0) ? totalNumber / pageSize : totalNumber / pageSize + 1;

        result.put(KEY_TOTALPAGENUMBER, totalPageNumber);
        result.put(KEY_TOTALDATACOUNT, totalNumber);

        return result;
    }

    public Map<String, Object> createWithList(Object list) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(KEY_CODE, code);
        result.put(KEY_MSG, msg);
        result.put(KEY_DATA, list);
        return result;
    }

    public Map<String, Object> create() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(KEY_CODE, code);
        result.put(KEY_MSG, msg);
        return result;
    }

    public String createJson() {
        String result = "{";
        result += "\"" + KEY_CODE + "\":" + code + ",";
        result += "\"" + KEY_MSG + "\":\"" + msg + "\"}";
        return result;
    }

}
