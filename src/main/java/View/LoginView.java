package View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginView extends Application {
    final Label message = new Label("");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 430, 350);
        stage.setScene(scene);

        // note 布局
        HBox hBoxAccount = new HBox();
        hBoxAccount.setAlignment(Pos.CENTER);
        hBoxAccount.setSpacing(10); // 内边距（各个组件之间的边距）

        HBox hBoxPassword = new HBox();
        hBoxPassword.setAlignment(Pos.CENTER);
        hBoxPassword.setSpacing(10);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        // note 账户密码
        Label labelAccount = new Label("账户：");
        final TextField accountField = new TextField();

        Label labelPassword = new Label("密码：");
        final PasswordField passwordField = new PasswordField();

        passwordField.setOnAction(actionEvent -> {
            if(accountField.getText().equals("1") && passwordField.getText().equals("1")) {
                message.setText("密码正确");
                message.setTextFill(Color.BLACK);
            } else if(!accountField.getText().equals("1")) {
                message.setText("账号不存在");
                message.setTextFill(Color.RED);
            } else {
                message.setText("密码错误");
                message.setTextFill(Color.RED);
            }
        });


        // note 按钮
        Button buttonOk = new Button("登录");
        buttonOk.setOnAction(passwordField.getOnAction());

        hBoxAccount.getChildren().addAll(labelAccount, accountField);
        hBoxPassword.getChildren().addAll(labelPassword, passwordField);
        vBox.getChildren().addAll(hBoxAccount, hBoxPassword, message, buttonOk);

        scene.setRoot(vBox);
        stage.show();
    }


}
