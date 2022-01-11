package com.dms.Ex;

public class PasswordNotSameException extends Exception{
    public PasswordNotSameException() {
        super("两次输入密码不同！");
    }
}
