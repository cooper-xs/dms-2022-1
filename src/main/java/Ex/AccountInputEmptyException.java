package Ex;

public class AccountInputEmptyException extends Exception{
    public AccountInputEmptyException() {
        super("账号为空");
    }
}
