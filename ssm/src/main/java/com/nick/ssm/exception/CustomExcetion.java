package com.nick.ssm.exception;

public class CustomExcetion extends Exception{

    private String msg;

    public CustomExcetion(String msg) {
        super();
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
