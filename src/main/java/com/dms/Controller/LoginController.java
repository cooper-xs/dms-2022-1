package com.dms.Controller;

import com.dms.DmsUtils.TranMD5;
import com.dms.Po.Session;
import com.dms.Service.Implementation.BizImpl;
import com.dms.Service.Interfaces.Biz;
import com.dms.Ex.AccountInputEmptyException;
import com.dms.Ex.NoSuchAccountException;
import com.dms.Ex.PasswordInputEmptyException;
import com.dms.Ex.PasswordWrongException;
import com.dms.View.MainApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Stage LoginStage;

    public Stage getLoginStage() {
        return LoginStage;
    }

    public void setLoginStage(Stage loginStage) {
        LoginStage = loginStage;
    }

    public static Biz biz = new BizImpl();
    public int res;
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
    protected void on_ok() throws IOException {
        try {
            res = biz.Login(id_accountIn.getText(), TranMD5.md5(id_passwordIn.getText()));
            lab_message.setText("登录成功");
            lab_message.setTextFill(Color.BLACK);
            Session.setNumber(id_accountIn.getText());
            if(res == 1) {
                this.LoginStage.close();
                new MainApplication().initStudentTable();
            } else if(res == 2) {
                new MainApplication().initManageTable();
            } else if(res == 3) {
                new MainApplication().initAdminTable();
            }
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
