package com.dms.View;

import com.dms.Controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
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
        // 1.新建fxmlLoad,设置fxml路径
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Login.fxml"));
        // 2.生成对应的root
        HBox root = fxmlLoader.load();
        // 3.获取Controller用于关闭
        LoginController controller = fxmlLoader.getController();
        controller.setLoginStage(primaryStage);
        // 4.生成对应Scene
        Scene scene = new Scene(root,700,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initStudentTable() throws IOException {
        // 1.新建fxmlLoad,设置fxml路径
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("StudentTable.fxml"));
        // 2.生成对应的root
        Parent root = fxmlLoader.load();
        // 3.生成对应Scene
        Scene scene = new Scene(root,1200,800);
        // 4.设置相关内容...
        Stage stage = new Stage();
        stage.setTitle("学生界面");
        stage.setResizable(false); // 不可调整大小
        stage.initModality(Modality.APPLICATION_MODAL); // 设置窗口模态
        stage.initOwner(primaryStage); // stage 的拥有者是 primaryStage
        stage.setScene(scene);
        // 5.显示
        stage.showAndWait();
    }

    // todo
    public void initManageTable() throws IOException {
        // 1.新建fxmlLoad,设置fxml路径
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ManageTable.fxml"));
        // 2.生成对应的root
        Parent root = fxmlLoader.load();
        // 3.生成对应Scene
        Scene scene = new Scene(root,1200,800);
        // 4.设置相关内容...
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("宿管界面");
        // 5.显示
        stage.show();
    }

    // todo
    public void initAdminTable() throws IOException {
        // 1.新建fxmlLoad,设置fxml路径
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("AdminTable.fxml"));
        // 2.生成对应的root
        Parent root = fxmlLoader.load();
        // 3.生成对应Scene
        Scene scene = new Scene(root,1200,800);
        // 4.设置相关内容...
        this.primaryStage.hide();
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("超级管理员界面");
        // 5.显示
        stage.show();
    }
}