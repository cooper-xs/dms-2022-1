package View;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView extends Application {
    @FXML
    private Stage stage;//窗口对象

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.stage.setTitle("宿舍管理系统");
        Scene loginScene = initLogin();
    }

    public Scene initLogin() throws IOException {
        // 1.新建fxmlLoad,设置fxml路径
        FXMLLoader fxmlLoader = new FXMLLoader(LoginView.class.getResource("Login.fxml"));
        // 获取Controller用于关闭
//        LoginController controller = fxmlLoader.getController();
        // 2.生成对应的root
        HBox root = fxmlLoader.load();
        // 3.生成对应Scene
        Scene scene = new Scene(root,700,500);
        stage.setScene(scene);
        stage.show();
        return scene;
    }

    public Scene initStudentTable() throws IOException {
        // 1.新建fxmlLoad,设置fxml路径
        FXMLLoader fxmlLoader = new FXMLLoader(LoginView.class.getResource("StudentTable.fxml"));
        // 2.生成对应的root
        Parent root = fxmlLoader.load();
        // 3.生成对应Scene
        Scene scene = new Scene(root,1200,800);
        // 4.设置相关内容...
        stage.setScene(scene);
        stage.setTitle("学生界面");
        // 5.显示
        stage.show();
        return scene;
    }
}