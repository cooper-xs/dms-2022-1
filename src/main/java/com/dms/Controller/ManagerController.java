package com.dms.Controller;

import com.dms.Ex.InputValueException;
import com.dms.Ex.NoSuchAccountException;
import com.dms.Po.*;
import com.dms.Service.Implementation.BizImpl;
import com.dms.Service.Interfaces.Biz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import java.util.List;

public class ManagerController {


    public TabPane tabs_father;
    private Biz biz = new BizImpl();

    private Manager manager;
    private Building building;

    // x0 首页信息
    @FXML
    public Label lab_name;
    @FXML
    public Tab tab_welcome;
    @FXML
    public Tab tab_person;
    @FXML
    public Tab tab_dorm;
    @FXML
    public Tab tab_building;
    @FXML
    public Tab tab_log;
    @FXML
    public Tab tab_money;
    @FXML
    public Tab tab_resetPassword;
    // x1 个人信息
    @FXML
    public TextField txt_managerName;
    @FXML
    public TextField txt_managerId;
    @FXML
    public TextField txt_managerContact;
    @FXML
    public Label lab_messageInPerson;
    // x2 宿舍信息
    // x3 楼宇信息
    // x4 签到信息
    // x5 缴费信息

    /**
     * 初始化
     */
    @FXML
    public void initialize() {
        manager = biz.selectManagerById(Session.getNumber());

//        try {
//            // note 学生信息 宿舍信息 楼宇信息
//            student = biz.selectStudentById(Session.getNumber());
//            dorm = biz.selectDormByBuilding_idAndDorm_id(student.getBuilding_id(), student.getDorm_id());
//            building = biz.selectBuildingByBuilding_id(student.getBuilding_id());
//            manager = biz.selectManagerById(building.getManager_id());
//        } catch (NoSuchAccountException e) {
//            lab_messageInDorm.setText("尚未分配宿舍");
//            lab_messageInDorm.setTextFill(Color.RED);
//        }
//        // note 设置tab_dorm中的信息
//        updateDormMessage();
//        // note 设置tab_log中的信息
//        but_message.setText(student.getStatus() == 1 ? "签退" : "签到");
//        updateLogMessage();
//        // note 设置tab_money中的信息
//        updateMoneyMessage();
//        // note 设置主页面信息
//        lab_name.setText(student.getName());
//        // note 设置tab组件
//        tabs_father.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
//        tab_welcome.setClosable(false);
//        tabs_father.getTabs().remove(tab_person);
//        tabs_father.getTabs().remove(tab_dorm);
//        tabs_father.getTabs().remove(tab_building);
//        tabs_father.getTabs().remove(tab_log);
//        tabs_father.getTabs().remove(tab_money);
    }


    // note 个人信息
    /**
     * note 显示个人信息tab
     * @param actionEvent
     */
    @FXML
    public void but_person(ActionEvent actionEvent) {
//        updateManagerMessage();
//        lab_messageInPerson.setText("");
//        if(tabs_father.getTabs().contains(tab_person)) {
//            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
//            tabs_father.selectionModelProperty().set(selectionModel);
//        } else {
//            tabs_father.getTabs().add(tab_person);
//        }
//        tabs_father.getSelectionModel().select(tab_person);
    }

    /**
     * note 修改个人信息按钮
     * @param actionEvent
     */
    @FXML
    public void but_personEdit(ActionEvent actionEvent) {
//        txt_name.setEditable(true);
//        txt_birthday.setEditable(true);
//        txt_contact.setEditable(true);
//        txt_college.setEditable(true);
//        txt_major.setEditable(true);
//        txt_class.setEditable(true);
//        txt_dorm_id.setEditable(true);
//        txt_bed_id.setEditable(true);
//        lab_messageInPerson.setText("正在编辑");
    }

    /**
     *  note 保存个人信息按钮
     * @param actionEvent
     */
    @FXML
    public void but_personSave(ActionEvent actionEvent) {
//        student.setName(txt_name.getText());
//        student.setBirthday(txt_birthday.getText());
//        student.setContact(txt_contact.getText());
//        student.setCollege(txt_college.getText());
//        student.setMajor(txt_major.getText());
//        student.setClasses(txt_class.getText());
//        String[] dormData = txt_dorm_id.getText().split("#");
//        student.setDorm_id(dormData[0]);
//        student.setDorm_id(dormData[1]);
//        student.setBed_id(Integer.parseInt(txt_bed_id.getText()));
//        if(biz.updateStudentInfo(student.getStudent_id(), student)) {
//            lab_messageInPerson.setText("保存成功！");
//            lab_messageInPerson.setTextFill(Color.GREEN);
//        } else {
//            lab_messageInPerson.setText("保存失败！");
//            lab_messageInPerson.setTextFill(Color.RED);
//        }
//        txt_name.setEditable(false);
//        txt_gender.setEditable(false);
//        txt_birthday.setEditable(false);
//        txt_contact.setEditable(false);
//        txt_student_id.setEditable(false);
//        txt_college.setEditable(false);
//        txt_major.setEditable(false);
//        txt_class.setEditable(false);
//        txt_dorm_id.setEditable(false);
//        txt_bed_id.setEditable(false);
    }

    // note 宿舍信息
    /**
     * note 显示宿舍信息tab
     * @param actionEvent
     */
    @FXML
    public void but_dorm(ActionEvent actionEvent) {
//        txt_dormName.setText(dorm.getName());
//        txt_dormMoney.setText(String.valueOf(dorm.getDeposit()));
//        table_dorm.setItems(dataInDorm);
//        col_dorm.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("dorm_id"));
//        col_bed.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("bed_id"));
//        col_name.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("name"));
//        col_number.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("student_id"));
//        col_birthday.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("birthday"));
//        col_contact.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("contact"));
//        col_major.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("major"));
//        col_class.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("classes"));
//        col_state.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("state"));
//        if(tabs_father.getTabs().contains(tab_dorm)) {
//            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
//            tabs_father.selectionModelProperty().set(selectionModel);
//        } else {
//            tabs_father.getTabs().add(tab_dorm);
//        }
//        tabs_father.getSelectionModel().select(tab_dorm);
    }

    /**
     * note 修改宿舍信息按钮
     * @param actionEvent
     */
    @FXML
    public void but_dormNameEdit(ActionEvent actionEvent) {
//        txt_dormName.setEditable(true);
//        lab_messageInDorm.setText("正在修改");
//        lab_messageInDorm.setTextFill(Color.BLACK);
    }

    /**
     * note 保存宿舍信息按钮
     * @param actionEvent
     */
    @FXML
    public void but_dormNameSave(ActionEvent actionEvent) {
//        dorm.setName(txt_dormName.getText());
//        if(biz.updateDormInfo(student.getBuilding_id(), student.getDorm_id(), dorm)) {
//            updateDormMessage();
//            lab_messageInDorm.setText("保存成功！");
//            lab_messageInDorm.setTextFill(Color.GREEN);
//        } else {
//            lab_messageInDorm.setText("保存失败！");
//            lab_messageInDorm.setTextFill(Color.RED);
//        }
//        txt_dormName.setEditable(false);

    }

    // note 楼宇信息
    /**
     * note 显示楼宇信息tab
     * @param actionEvent
     */
    @FXML
    public void but_building(ActionEvent actionEvent) {
//        txt_building_dormId.setText(building.getName());
//        txt_building_location.setText(building.getAddress());
//        txt_building_manager.setText(manager.getName());
//        txt_building_contact.setText(manager.getContact());
//        txt_building_number.setText(String.valueOf(biz.selectStudentByBuilding_id(student.getBuilding_id()).size()));
//        if(tabs_father.getTabs().contains(tab_building)) {
//            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
//            tabs_father.selectionModelProperty().set(selectionModel);
//        } else {
//            tabs_father.getTabs().add(tab_building);
//        }
//        tabs_father.getSelectionModel().select(tab_building);
    }

    // note 签到信息
    /**
     * note 显示签到签退tab
     * @param actionEvent
     */
    @FXML
    public void but_signAndOut(ActionEvent actionEvent) {
//        table_log.setItems(dataInLog);
//        col_sign_NO.setCellValueFactory(new PropertyValueFactory<BeanLog, Integer>("NO"));
//        col_sign_time.setCellValueFactory(new PropertyValueFactory<BeanLog, String>("date"));
//        col_sign_type.setCellValueFactory(new PropertyValueFactory<BeanLog, String>("type"));
//        if(tabs_father.getTabs().contains(tab_log)) {
//            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
//            tabs_father.selectionModelProperty().set(selectionModel);
//        } else {
//            tabs_father.getTabs().add(tab_log);
//        }
//        tabs_father.getSelectionModel().select(tab_log);
    }

    /**
     * note 签到，签退操作
     * @param actionEvent
     */
    @FXML
    public void but_sign_operation(ActionEvent actionEvent) {
//        if(student.getStatus() == 1) { // 进行签退
//            if(biz.signOut(student.getStudent_id())) {
//                student.setStatus(0);
//                but_message.setText("签到");
//                lab_messageInLog.setText("已签退");
//                lab_messageInLog.setTextFill(Color.GREEN);
//            } else {
//                lab_messageInLog.setText("签退失败");
//                lab_messageInLog.setTextFill(Color.RED);
//            }
//        } else if(student.getStatus() == 0){ // 进行签到
//            if(biz.signIn(student.getStudent_id())) {
//                student.setStatus(1);
//                but_message.setText("签退");
//                lab_messageInLog.setText("已签到");
//                lab_messageInLog.setTextFill(Color.GREEN);
//            } else {
//                lab_messageInLog.setText("签到失败");
//                lab_messageInLog.setTextFill(Color.RED);
//            }
//        }
//        updateLogMessage();
    }

    // note 缴费信息
    /**
     * note 显示缴费tab
     * @param actionEvent
     */
    @FXML
    public void but_saveMoney(ActionEvent actionEvent) {
//        txt_money_deposit.setText(String.valueOf(dorm.getDeposit()));
//        txt_money_dormName.setText(dorm.getName());
//        table_money.setItems(dataMoney);
//        col_money_NO.setCellValueFactory(new PropertyValueFactory<BeanMoney, Integer>("NO"));
//        col_money_dormNumber.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("dormNumber"));
//        col_money_account.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("account"));
//        col_money_person.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("person"));
//        col_money_personId.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("personId"));
//        col_money_date.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("date"));
//        if(tabs_father.getTabs().contains(tab_money)) {
//            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
//            tabs_father.selectionModelProperty().set(selectionModel);
//        } else {
//            tabs_father.getTabs().add(tab_money);
//        }
//        tabs_father.getSelectionModel().select(tab_money);
    }

    /**
     * note 宿舍缴费按钮
     * @param actionEvent
     */
    @FXML
    public void but_money_toSave(ActionEvent actionEvent) {
//        String valueIn = txt_money_toSave.getText();
//        try{
//            double value = Double.parseDouble(valueIn);
//            if(biz.saveMoney(student.getStudent_id(), dorm.getBuilding_id(), dorm.getDorm_id(), value)) {
//                lab_money_message.setText("缴费成功！");
//                lab_money_message.setTextFill(Color.GREEN);
//                try {
//                    dorm = biz.selectDormByBuilding_idAndDorm_id(dorm.getBuilding_id(), dorm.getDorm_id());
//                } catch (NoSuchAccountException e) {
//                    lab_messageInDorm.setText("尚未分配宿舍");
//                    lab_messageInDorm.setTextFill(Color.RED);
//                }
//                updateMoneyMessage();
//            } else if(value == 0) {
//                lab_money_message.setText("缴费金额无效！");
//                lab_money_message.setTextFill(Color.RED);
//            } else {
//                lab_money_message.setText("缴费失败！");
//                lab_money_message.setTextFill(Color.RED);
//            }
//        } catch (NumberFormatException e) {
//            lab_money_message.setText("您输入的不是数字！");
//            lab_money_message.setTextFill(Color.RED);
//        } catch (InputValueException e) {
//            lab_money_message.setText("您输入了一个负数！");
//            lab_money_message.setTextFill(Color.RED);
//        }
//        txt_money_deposit.setText(String.valueOf(dorm.getDeposit()));
//        txt_money_toSave.setText("");
    }

    // note 退出
    /**
     * note 保存所有信息，注销账号，关闭程序
     * @param actionEvent
     */
    @FXML
    public void but_logout(ActionEvent actionEvent) {
//        biz.updateStudentInfo(student.getStudent_id(), student);
//        biz.updateDormInfo(student.getBuilding_id(), student.getDorm_id(), dorm);
//        Session.setNumber("");
        System.exit(0);
    }

    // note 其他封装函数
    /**
     * 更新个人信息
     */
    private void updateManagerMessage() {
        txt_managerName.setText(manager.getName());
        txt_managerId.setText(manager.getManager_id());
        txt_managerContact.setText(manager.getContact());
        lab_messageInPerson.setText("");
    }

    /**
     * 更新宿舍表格
     */
    private void updateDormMessage() {
//        txt_dormMoney.setText(String.valueOf(dorm.getDeposit()));
//        dataInDorm.clear();
//        List<Student> students = biz.selectStudentByBuilding_idAndDorm_id(student.getBuilding_id(), student.getDorm_id());
//        for(Student student : students) {
//            BeanPerson beanPerson = new BeanPerson(student.getBuilding_id() + "#" + student.getDorm_id(), student.getBed_id() + "", student.getName(), student.getStudent_id(), student.getBirthday(), student.getContact(), student.getMajor(), student.getClasses(), (student.getStatus() == 1 ? "已签到" : "已签退"));
//            dataInDorm.add(beanPerson);
//        }
    }

    /**
     * 更新签到表格
     */
    private void updateLogMessage() {
//        dataInLog.clear();
//        List<Log> logList = biz.selectLogByStudent_id(student.getStudent_id());
//        int cnt_Log = 0;
//        Log logLast = null;
//        for(Log log : logList) {
//            BeanLog beanLog = null;
//            if(log.getType() == 2) {
//                beanLog = new BeanLog(++ cnt_Log, "签到", log.getDate());
//                logLast = log;
//                dataInLog.add(beanLog);
//            } else if(log.getType() == 3) {
//                beanLog = new BeanLog(++ cnt_Log, "签退", log.getDate());
//                logLast = log;
//                dataInLog.add(beanLog);
//            }
//        }
//        if(logLast != null) {
//            txt_sign_time.setText(logLast.getDate());
//        } else {
//            txt_sign_time.setText("暂无记录");
//        }
    }

    /**
     * 更新缴费表格
     */
    private void updateMoneyMessage() {
//        txt_money_deposit.setText(String.valueOf(dorm.getDeposit()));
//        txt_money_dormName.setText(dorm.getName());
//        dataMoney.clear();
//        List<Log> logList = biz.selectLogByBuilding_idAndDorm_id(dorm.getBuilding_id(), dorm.getDorm_id());
//        int cnt_Log = 0;
//        for(Log log : logList) {
//            BeanMoney beanMoney = new BeanMoney(++ cnt_Log, log.getBuilding_id() + "#" + log.getDorm_id(), String.valueOf(log.getAccount()), biz.selectStudentById(log.getAccount_id()).getName(), log.getAccount_id(), log.getDate());
//            dataMoney.add(beanMoney);
//        }
    }

    /**
     * 刷新所有
     * @param actionEvent
     */
    public void but_refreshAll(ActionEvent actionEvent) {
//        try {
//            student = biz.selectStudentById(Session.getNumber());
//            dorm = biz.selectDormByBuilding_idAndDorm_id(student.getBuilding_id(), student.getDorm_id());
//            building = biz.selectBuildingByBuilding_id(student.getBuilding_id());
//            manager = biz.selectManagerById(building.getManager_id());
//        } catch (NoSuchAccountException e) {
//            lab_messageInDorm.setText("尚未分配宿舍");
//            lab_messageInDorm.setTextFill(Color.RED);
//        }
//        updateStudentMessage();
//        updateDormMessage();
//        updateLogMessage();
//        updateMoneyMessage();
//        lab_messageInPerson.setText("");
//        lab_messageInDorm.setText("");
//        lab_messageInLog.setText("");
//        lab_money_message.setText("");
    }

    // todo
    @FXML
    public void but_resetPassword(ActionEvent actionEvent) {

    }
}