package com.dms.Ex;

public class PasswordWrongException extends Exception{
    public PasswordWrongException() {
        super("账号或密码错误！");
    }
}
