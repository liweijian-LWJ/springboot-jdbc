package com.lwj.springboot.jdbc.util;

public class Result {

    public static final String YES = "成功";
    public static final String NO = "失败";

    private String code;

    private boolean success = false;

    private String msg;

    private Object obj;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
