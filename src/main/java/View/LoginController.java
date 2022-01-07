package View;

import Service.Implementation.BizImpl;
import Service.Interfaces.Biz;
import Ex.AccountInputEmptyException;
import Ex.NoSuchAccountException;
import Ex.PasswordInputEmptyException;
import Ex.PasswordWrongException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LoginController {
    public static Biz biz = new BizImpl();
    @FXML
    public Label lab_message;
    @FXML
    private TextField id_accountIn;
    @FXML
    private PasswordField id_passwordIn;
    @FXML
    protected void on_reset() {
        id_accountIn.setText("");
        id_passwordIn.setText("");
        lab_message.setText("");
    }
    @FXML
    protected void on_ok() {
        int res = 0;
        try {
            res = biz.Login(id_accountIn.getText(), id_passwordIn.getText());
            lab_message.setText("登录成功");
            lab_message.setTextFill(Color.BLACK);
        } catch (NoSuchAccountException e) {
            lab_message.setText("账户不存在");
            lab_message.setTextFill(Color.RED);
        } catch (PasswordWrongException e) {
            lab_message.setText("密码错误");
            lab_message.setTextFill(Color.RED);
        } catch (AccountInputEmptyException e) {
            lab_message.setText("请输入账号");
            lab_message.setTextFill(Color.RED);
        } catch (PasswordInputEmptyException e) {
            lab_message.setText("请输入密码");
            lab_message.setTextFill(Color.RED);
        }
        // todo 跳转res
    }
}
