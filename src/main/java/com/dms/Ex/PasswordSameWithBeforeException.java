package com.dms.Ex;

public class PasswordSameWithBeforeException extends Exception{
    public PasswordSameWithBeforeException() {
        super("前后密码相同");
    }
}
