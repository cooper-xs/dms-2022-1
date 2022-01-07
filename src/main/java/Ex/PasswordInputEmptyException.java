package Ex;

public class PasswordInputEmptyException extends Exception{
    public PasswordInputEmptyException() {
        super("密码为空");
    }
}
