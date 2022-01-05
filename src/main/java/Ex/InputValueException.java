package Ex;

public class InputValueException extends Exception{
    public InputValueException(double value) {
        super("您输入的 " + value + " 是一个负数");
    }
}
