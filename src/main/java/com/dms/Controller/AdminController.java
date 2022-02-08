package com.dms.Controller;

import com.dms.DmsUtils.TranMD5;
import com.dms.Po.*;
import com.dms.Service.Implementation.BizImpl;
import com.dms.Service.Interfaces.Biz;
import com.dms.View.MainApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    private Stage AdminStage;

    public Stage getAdminStage() {
        return AdminStage;
    }

    public void setAdminStage(Stage adminStage) {
        AdminStage = adminStage;
    }

    private String buildingBefore;
    private Building observedBuilding;
    private final Biz biz = new BizImpl();
    private final ObservableList<BeanManager> dataManager = FXCollections.observableArrayList();
    private final ObservableList<BeanBuilding> dataBuilding = FXCollections.observableArrayList();
    // x1 主界面
    @FXML
    public TabPane tabs_father;
    @FXML
    public Tab tab_welcome;
    @FXML
    public Tab tab_managerMessage;
    @FXML
    public Tab tab_buildingManager;
    @FXML
    public Tab tab_buildingMessage;
    @FXML
    public Tab tab_resetPassword;
    // x2 宿管管理
    @FXML
    public TableView<BeanManager> table_manager;
    @FXML
    public TableColumn<BeanManager, Integer> col_NOInManager;
    @FXML
    public TableColumn<BeanManager, String> col_nameInManager;
    @FXML
    public TableColumn<BeanManager, String> col_idInManager;
    @FXML
    public TableColumn<BeanManager, String> col_connectInManager;
    @FXML
    public TableColumn<BeanManager, String> col_buildingInManager;
    @FXML
    public Label lab_messageInManager;
    // x3 楼宇管理
    @FXML
    public TableView<BeanBuilding> table_building;
    @FXML
    public TableColumn<BeanBuilding, Integer> col_NOInBuilding;
    @FXML
    public TableColumn<BeanBuilding, Integer> col_numberInBuilding;
    @FXML
    public TableColumn<BeanBuilding, String> col_nameInBuilding;
    @FXML
    public TableColumn<BeanBuilding, String> col_addressInBuilding;
    @FXML
    public TableColumn<BeanBuilding, String> col_managerInBuilding;
    @FXML
    public Label lab_messageInBuildingManager;
    // x4 楼宇信息
    @FXML
    public TextField txt_id_inBuilding;
    @FXML
    public TextField txt_nameInBuilding;
    @FXML
    public TextField txt_addressInBuilding;
    @FXML
    public TextField txt_managerInBuilding;
    @FXML
    public Label lab_messageInBuilding;
    @FXML
    public TextField txt_accountInPassWord;
    @FXML
    public TextField txt_passwordInPassword;
    @FXML
    public Label lab_messageInPassword;

    /**
     * note 初始化
     */
    @FXML
    public void initialize() {
        refreshAll();
        // note 设置所有tab可关闭（除了welcome）
        tabs_father.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
        tab_welcome.setClosable(false);
        // note 默认以下tab初始不显示
        tabs_father.getTabs().remove(tab_managerMessage);
        tabs_father.getTabs().remove(tab_buildingManager);
        tabs_father.getTabs().remove(tab_buildingMessage);
        tabs_father.getTabs().remove(tab_resetPassword);
        /* note 设置内部TableView数据源 */
        // x1 管理员table
        table_manager.setItems(dataManager);
        col_NOInManager.setCellValueFactory(new PropertyValueFactory<>("NO"));
        col_nameInManager.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_idInManager.setCellValueFactory(new PropertyValueFactory<>("manager_id"));
        col_connectInManager.setCellValueFactory(new PropertyValueFactory<>("connect"));
        col_buildingInManager.setCellValueFactory(new PropertyValueFactory<>("managerBuilding"));
        // x2 楼宇table
        table_building.setItems(dataBuilding);
        col_NOInBuilding.setCellValueFactory(new PropertyValueFactory<>("NO"));
        col_numberInBuilding.setCellValueFactory(new PropertyValueFactory<>("building_id"));
        col_nameInBuilding.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_addressInBuilding.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_managerInBuilding.setCellValueFactory(new PropertyValueFactory<>("manager_id"));
    }

    /**
     * note 转跳修改密码tab
     * @param actionEvent
     */
    @FXML
    public void but_reset(ActionEvent actionEvent) {
        // note 如果父tab已经有该子tab，聚焦；否则，添加到父tab（下同）
        if(tabs_father.getTabs().contains(tab_resetPassword)) {
            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
            tabs_father.selectionModelProperty().set(selectionModel);
        } else {
            tabs_father.getTabs().add(tab_resetPassword);
        }
        tabs_father.getSelectionModel().select(tab_resetPassword);
    }

    /**
     * note 刷新宿舍楼信息
     */
    private  void updateBuilding() {
        txt_id_inBuilding.setText(observedBuilding.getBuilding_id());
        txt_nameInBuilding.setText(observedBuilding.getName());
        txt_addressInBuilding.setText(observedBuilding.getAddress());
        txt_managerInBuilding.setText(observedBuilding.getManager_id());
        lab_messageInBuilding.setText("");
    }

    /**
     * note 刷新所有表格
     */
    private void refreshAll() {
        // note 设置主页面和分页面的其他信息
//        lab_messageInManager.setText("");
//        lab_messageInBuildingManager.setText("");
        lab_messageInBuilding.setText("");
        lab_messageInPassword.setText("");
        // note 设置管理员管理tab
        dataManager.clear();
        int cntManager = 0;
        for(Manager manager : biz.selectAllManager()) {
            String buildingOfManager = "";
            int flag = 0;
            for(Building building : biz.selectBuildingsByManager_id(manager.getManager_id())) {
                if(flag != 0) {
                    buildingOfManager += ", ";
                } else {
                    flag = 1;
                }
                buildingOfManager += building.getName();
            }
            BeanManager beanManager = new BeanManager(++cntManager, manager.getName(), manager.getManager_id(), manager.getContact(), buildingOfManager);
            dataManager.add(beanManager);
        }
        // note 设置楼宇管理tab
        dataBuilding.clear();
        int cntBuilding = 0;
        for(Building building : biz.selectAllBuilding()) {
            BeanBuilding beanBuilding = new BeanBuilding(++cntBuilding, building.getBuilding_id(), building.getName(), building.getAddress(), building.getManager_id());
            dataBuilding.add(beanBuilding);
        }
    }

    /**
     * note 刷新所有
     * @param actionEvent
     */
    @FXML
    public void but_refreshAll(ActionEvent actionEvent) {
        refreshAll();
    }

    /**
     * note 转跳管理员信息tab
     * @param actionEvent
     */
    @FXML
    public void but_manager(ActionEvent actionEvent) {
        // note 如果父tab已经有该子tab，聚焦；否则，添加到父tab（下同）
        if(tabs_father.getTabs().contains(tab_managerMessage)) {
            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
            tabs_father.selectionModelProperty().set(selectionModel);
        } else {
            tabs_father.getTabs().add(tab_managerMessage);
        }
        tabs_father.getSelectionModel().select(tab_managerMessage);
    }

    /**
     * note 转跳楼宇管理tab
     * @param actionEvent
     */
    @FXML
    public void but_building(ActionEvent actionEvent) {
        // note 如果父tab已经有该子tab，聚焦；否则，添加到父tab（下同）
        if(tabs_father.getTabs().contains(tab_buildingManager)) {
            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
            tabs_father.selectionModelProperty().set(selectionModel);
        } else {
            tabs_father.getTabs().add(tab_buildingManager);
        }
        tabs_father.getSelectionModel().select(tab_buildingManager);
    }

    /**
     * note 注销系统
     * @param actionEvent
     */
    @FXML
    public void but_logout(ActionEvent actionEvent) {
        System.exit(0);
    }

    /**
     * note 转跳管理员界面stage
     * @param actionEvent
     */
    @FXML
    public void but_jumpToManager(ActionEvent actionEvent) {
        Session.setNumber(table_manager.getSelectionModel().getSelectedItem().getManager_id());
        try {
            System.out.println(this.AdminStage);
            new MainApplication().initManageTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * note 转跳楼宇信息tab
     * @param actionEvent
     */
    @FXML
    public void but_jumpToBuilding(ActionEvent actionEvent) {
        try {
            observedBuilding = biz.selectBuildingByBuilding_id(table_building.getSelectionModel().getSelectedItem().getBuilding_id());
            buildingBefore = observedBuilding.getBuilding_id();
            updateBuilding();
            // note 如果父tab已经有该子tab，聚焦；否则，添加到父tab（下同）
            if(tabs_father.getTabs().contains(tab_buildingMessage)) {
                SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
                tabs_father.selectionModelProperty().set(selectionModel);
            } else {
                tabs_father.getTabs().add(tab_buildingMessage);
            }
            tabs_father.getSelectionModel().select(tab_buildingMessage);
        } catch (Exception e) {
            lab_messageInBuildingManager.setTextFill(Color.RED);
        }
    }

    /**
     * note 修改楼宇信息
     * @param actionEvent
     */
    @FXML
    public void but_editInBuilding(ActionEvent actionEvent) {
        // note 设置可编辑并给予提示信息
        txt_id_inBuilding.setEditable(true);
        txt_nameInBuilding.setEditable(true);
        txt_addressInBuilding.setEditable(true);
        txt_managerInBuilding.setEditable(true);
        lab_messageInBuilding.setText("正在编辑");
        lab_messageInBuilding.setTextFill(Color.BLUE);
    }

    /**
     * note 保存楼宇信息
     * @param actionEvent
     */
    @FXML
    public void but_toSaveInBuilding(ActionEvent actionEvent) {
        // note 设置不可编辑
        txt_id_inBuilding.setEditable(false);
        txt_nameInBuilding.setEditable(false);
        txt_addressInBuilding.setEditable(false);
        txt_managerInBuilding.setEditable(false);
        observedBuilding.setBuilding_id(txt_id_inBuilding.getText());
        observedBuilding.setName(txt_nameInBuilding.getText());
        observedBuilding.setAddress(txt_addressInBuilding.getText());
        observedBuilding.setManager_id(txt_managerInBuilding.getText());
        boolean flag = biz.updateBuildingInfo(buildingBefore, observedBuilding);
        updateBuilding();
        if(flag) {
            lab_messageInBuilding.setText("保存成功");
            lab_messageInBuilding.setTextFill(Color.rgb(16,185,16));
        } else {
            lab_messageInBuilding.setText("保存失败");
            lab_messageInBuilding.setTextFill(Color.RED);
        }

        buildingBefore = observedBuilding.getBuilding_id();

    }

    /**
     * note 重设密码
     * @param actionEvent
     */
    @FXML
    public void but_resetPassword(ActionEvent actionEvent) {
        boolean flag = biz.resetPasswordAdmin(txt_accountInPassWord.getText(), TranMD5.md5(txt_passwordInPassword.getText()));
        if(flag) {
            lab_messageInPassword.setText("修改成功");
            lab_messageInPassword.setTextFill(Color.rgb(16,185,16));
        } else {
            lab_messageInPassword.setText("修改失败");
            lab_messageInPassword.setTextFill(Color.RED);
        }
    }
}
