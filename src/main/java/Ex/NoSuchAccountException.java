package Ex;

public class NoSuchAccountException extends Exception{
    public NoSuchAccountException(String account) {
        super("用户 [ " + account + " ] 不存在");
    }
}
