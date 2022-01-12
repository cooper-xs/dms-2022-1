package com.dms.View;

import com.dms.Controller.AdminController;
import com.dms.Controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @FXML
    private Stage primaryStage; //窗口对象

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.primaryStage.setTitle("宿舍管理系统");
        initLogin(); // 打开窗口
    }

    public void initLogin() throws IOException {
        // x1.新建fxmlLoad,设置fxml路径
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Login.fxml"));
        // x2.生成对应的root
        HBox root = fxmlLoader.load();
        // x3.获取Controller用于关闭
        LoginController controller = fxmlLoader.getController();
        controller.setLoginStage(primaryStage);
        // x4.生成对应Scene
        Scene scene = new Scene(root,700,500);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void initStudentTable() throws IOException {
        // x1.新建fxmlLoad,设置fxml路径
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("StudentTable.fxml"));
        // x2.生成对应的root
        Parent root = fxmlLoader.load();
        // x3.生成对应Scene
        Scene scene = new Scene(root,1200,800);
        // x4.设置相关内容...
        Stage stage = new Stage();
        stage.setTitle("学生界面");
        stage.setResizable(false); // 不可调整大小
        stage.initOwner(primaryStage); // stage 的拥有者是 primaryStage
        stage.setScene(scene);
        // x5.显示
        stage.showAndWait();
    }

    // todo
    public void initManageTable() throws IOException {
        // x1.新建fxmlLoad,设置fxml路径
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ManagerTable.fxml"));
        // x2.生成对应的root
        Parent root = fxmlLoader.load();
        // x3.生成对应Scene
        Scene scene = new Scene(root,1200,800);
        // x4.设置相关内容...
        Stage stage = new Stage();
        stage.setTitle("宿舍管理员界面");
        stage.setResizable(false); // 不可调整大小
        stage.initOwner(primaryStage); // stage 的拥有者是 primaryStage
        stage.setScene(scene);
        // x5.显示
        stage.showAndWait();
    }

    // todo
    public void initAdminTable() throws IOException {
        // x1.新建fxmlLoad,设置fxml路径
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("AdminTable.fxml"));
        // x2.生成对应的root
        Parent root = fxmlLoader.load();
        // note
        AdminController controller = fxmlLoader.getController();
        controller.setAdminStage(primaryStage);
        // x3.生成对应Scene
        Scene scene = new Scene(root,1200,800);
        // x4.设置相关内容...
        Stage stage = new Stage();
        stage.setTitle("admin界面");
        stage.setResizable(false); // 不可调整大小
        stage.initOwner(primaryStage); // stage 的拥有者是 primaryStage
        stage.setScene(scene);
        // x5.显示
        stage.show();
    }
}