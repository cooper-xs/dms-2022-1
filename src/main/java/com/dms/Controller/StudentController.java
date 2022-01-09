package com.dms.Controller;

import com.dms.Ex.InputValueException;
import com.dms.Ex.NoSuchAccountException;
import com.dms.Po.*;
import com.dms.Service.Implementation.BizImpl;
import com.dms.Service.Interfaces.Biz;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import java.util.List;

public class StudentController {

    public static Biz biz = new BizImpl();

    private Student student;
    private Dorm dorm;
    private Building building;
    private Manager manager;
    private final ObservableList<BeanPerson> dataInDorm = FXCollections.observableArrayList();
    private final ObservableList<BeanLog> dataInLog = FXCollections.observableArrayList();
    private final ObservableList<BeanMoney> dataMoney = FXCollections.observableArrayList();
    // x0 首页信息
    @FXML
    public Label lab_name;
    @FXML
    public Label lab_identity;
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
    // x1 person模块
    @FXML
    public TextField txt_name;
    @FXML
    public TextField txt_gender;
    @FXML
    public TextField txt_birthday;
    @FXML
    public TextField txt_contact;
    @FXML
    public TextField txt_student_id;
    @FXML
    public TextField txt_college;
    @FXML
    public TextField txt_major;
    @FXML
    public TextField txt_class;
    // x2 dorm模块
    @FXML
    public TextField txt_dorm_id;
    @FXML
    public TextField txt_bed_id;
    @FXML
    public TabPane tabs_father;
    @FXML
    public Label lab_messageInPerson;
    @FXML
    public TableView<BeanPerson> table_dorm;
    @FXML
    public TableColumn<BeanPerson, String> col_dorm;
    @FXML
    public TableColumn<BeanPerson, String> col_bed;
    @FXML
    public TableColumn<BeanPerson, String> col_name;
    @FXML
    public TableColumn<BeanPerson, String> col_number;
    @FXML
    public TableColumn<BeanPerson, String> col_birthday;
    @FXML
    public TableColumn<BeanPerson, String> col_contact;
    @FXML
    public TableColumn<BeanPerson, String> col_major;
    @FXML
    public TableColumn<BeanPerson, String> col_class;
    @FXML
    public TableColumn<BeanPerson, String> col_state;
    @FXML
    public TextField txt_dormName;
    @FXML
    public Label lab_messageInDorm;
    @FXML
    public TextField txt_dormMoney;
    // x3 building模块
    @FXML
    public TextField txt_building_dormId;
    @FXML
    public TextField txt_building_location;
    @FXML
    public TextField txt_building_manager;
    @FXML
    public TextField txt_building_contact;
    @FXML
    public TextField txt_building_number;
    // x4 log模块
    @FXML
    public TextField txt_sign_time;
    @FXML
    public Button but_message;
    @FXML
    public TableView<BeanLog> table_log;
    @FXML
    public TableColumn<BeanLog, Integer> col_sign_NO;
    @FXML
    public TableColumn<BeanLog, String> col_sign_time;
    @FXML
    public TableColumn<BeanLog, String> col_sign_type;
    // x5 money模块
    public TextField txt_money_dromName;
    public TextField txt_money_deposit;
    public TextField txt_money_toSave;
    public Label lab_money_message;
    public TableView<BeanMoney> table_money;
    public TableColumn<BeanMoney, Integer> col_money_NO;
    public TableColumn<BeanMoney, String> col_money_dormNumber;
    public TableColumn<BeanMoney, String> col_money_account;
    public TableColumn<BeanMoney, String> col_money_person;
    public TableColumn<BeanMoney, String> col_money_personId;
    public TableColumn<BeanMoney, String> col_money_date;
    /**
     * 初始化
     */
    @FXML
    public void initialize() {
        try {
            // note 学生信息 宿舍信息 楼宇信息
            student = biz.selectStudentById(Session.getNumber());
            dorm = biz.selectDormByBuilding_idAndDorm_id(student.getBuilding_id(), student.getDorm_id());
            building = biz.selectBuildingByBuilding_id(student.getBuilding_id());
            manager = biz.selectManagerById(building.getManager_id());

        } catch (NoSuchAccountException e) {
            lab_messageInDorm.setText("尚未分配宿舍");
            lab_messageInDorm.setTextFill(Color.RED);
        }
        // note 设置tab_dorm中的信息
        List<Student> students = biz.selectStudentByBuilding_idAndDorm_id(student.getBuilding_id(), student.getDorm_id());
        for(Student student : students) {
            BeanPerson beanPerson = new BeanPerson(student.getBuilding_id() + "#" + student.getDorm_id(), student.getBed_id() + "", student.getName(), student.getStudent_id(), student.getBirthday(), student.getContact(), student.getMajor(), student.getClasses(), (student.getStatus() == 1 ? "已签到" : "已签退"));
            dataInDorm.add(beanPerson);
        }
        // note 设置tab_log中的信息
        but_message.setText(student.getStatus() == 1 ? "签退" : "签到");
        updateLogMessage();
        // note 设置tab_money中的信息
        updateMoneyMessage();
        // note 设置主页面信息
        lab_name.setText(student.getName());
        lab_identity.setText("！（学生）");
        // note 设置tab组件
        tabs_father.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
        tab_welcome.setClosable(false);
        tabs_father.getTabs().remove(tab_person);
        tabs_father.getTabs().remove(tab_dorm);
        tabs_father.getTabs().remove(tab_building);
        tabs_father.getTabs().remove(tab_log);
        tabs_father.getTabs().remove(tab_money);
    }

    /**
     * note 显示个人信息tab
     * @param actionEvent
     */
    @FXML
    public void but_person(ActionEvent actionEvent) {
        txt_name.setText(student.getName());
        txt_gender.setText(student.getGender());
        txt_birthday.setText(student.getBirthday());
        txt_contact.setText(student.getContact());
        txt_student_id.setText(student.getStudent_id());
        txt_college.setText(student.getCollege());
        txt_major.setText(student.getMajor());
        txt_class.setText(student.getClasses());
        txt_dorm_id.setText(student.getBuilding_id() + "#" + student.getDorm_id());
        txt_bed_id.setText(student.getBed_id() + "");
        lab_messageInPerson.setText("");
        if(tabs_father.getTabs().contains(tab_person)) {
            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
            tabs_father.selectionModelProperty().set(selectionModel);
        } else {
            tabs_father.getTabs().add(tab_person);
        }
        tabs_father.getSelectionModel().select(tab_person);
    }

    /**
     * note 修改个人信息按钮
     * @param actionEvent
     */
    @FXML
    public void but_personEdit(ActionEvent actionEvent) {
        txt_name.setEditable(true);
        txt_birthday.setEditable(true);
        txt_contact.setEditable(true);
        txt_college.setEditable(true);
        txt_major.setEditable(true);
        txt_class.setEditable(true);
        txt_dorm_id.setEditable(true);
        txt_bed_id.setEditable(true);
        lab_messageInPerson.setText("正在编辑");
    }

    /**
     *  note 保存个人信息按钮
     * @param actionEvent
     */
    @FXML
    public void but_personSave(ActionEvent actionEvent) {
        student.setName(txt_name.getText());
        student.setBirthday(txt_birthday.getText());
        student.setContact(txt_contact.getText());
        student.setCollege(txt_college.getText());
        student.setMajor(txt_major.getText());
        student.setClasses(txt_class.getText());
        String[] dormData = txt_dorm_id.getText().split("#");
        student.setDorm_id(dormData[0]);
        student.setDorm_id(dormData[1]);
        student.setBed_id(Integer.parseInt(txt_bed_id.getText()));
        if(biz.updateStudentInfo(student.getStudent_id(), student)) {
            lab_messageInPerson.setText("保存成功！");
            lab_messageInPerson.setTextFill(Color.BLACK);
        } else {
            lab_messageInPerson.setText("保存失败！");
            lab_messageInPerson.setTextFill(Color.RED);
        }
        txt_name.setEditable(false);
        txt_gender.setEditable(false);
        txt_birthday.setEditable(false);
        txt_contact.setEditable(false);
        txt_student_id.setEditable(false);
        txt_college.setEditable(false);
        txt_major.setEditable(false);
        txt_class.setEditable(false);
        txt_dorm_id.setEditable(false);
        txt_bed_id.setEditable(false);
    }

    /**
     * note 显示宿舍信息tab
     * @param actionEvent
     */
    @FXML
    public void but_dorm(ActionEvent actionEvent) {
        txt_dormName.setText(dorm.getName());
        txt_dormMoney.setText(String.valueOf(dorm.getDeposit()));
        table_dorm.setItems(dataInDorm);
        col_dorm.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("dorm_id"));
        col_bed.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("bed_id"));
        col_name.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("name"));
        col_number.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("student_id"));
        col_birthday.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("birthday"));
        col_contact.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("contact"));
        col_major.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("major"));
        col_class.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("classes"));
        col_state.setCellValueFactory(new PropertyValueFactory<BeanPerson, String>("state"));
        if(tabs_father.getTabs().contains(tab_dorm)) {
            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
            tabs_father.selectionModelProperty().set(selectionModel);
        } else {
            tabs_father.getTabs().add(tab_dorm);
        }
        tabs_father.getSelectionModel().select(tab_dorm);
    }

    /**
     * note 修改宿舍信息按钮
     * @param actionEvent
     */
    @FXML
    public void but_dormNameEdit(ActionEvent actionEvent) {
        txt_dormName.setEditable(true);
        lab_messageInDorm.setText("正在修改");
        lab_messageInDorm.setTextFill(Color.BLACK);
    }

    /**
     * note 保存宿舍信息按钮
     * @param actionEvent
     */
    @FXML
    public void but_dormNameSave(ActionEvent actionEvent) {
        dorm.setName(txt_dormName.getText());
        if(biz.updateDormInfo(student.getBuilding_id(), student.getDorm_id(), dorm)) {
            lab_messageInDorm.setText("保存成功！");
            lab_messageInDorm.setTextFill(Color.BLACK);
        } else {
            lab_messageInDorm.setText("保存失败！");
            lab_messageInDorm.setTextFill(Color.RED);
        }
        txt_dormName.setEditable(false);

    }

    /**
     * note 显示楼宇信息tab
     * @param actionEvent
     */
    @FXML
    public void but_building(ActionEvent actionEvent) {
        txt_building_dormId.setText(building.getName());
        txt_building_location.setText(building.getAddress());
        txt_building_manager.setText(manager.getName());
        txt_building_contact.setText(manager.getContact());
        txt_building_number.setText(String.valueOf(biz.selectStudentByBuilding_id(student.getBuilding_id()).size()));
        if(tabs_father.getTabs().contains(tab_building)) {
            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
            tabs_father.selectionModelProperty().set(selectionModel);
        } else {
            tabs_father.getTabs().add(tab_building);
        }
        tabs_father.getSelectionModel().select(tab_building);
    }

    /**
     * note 显示签到签退tab
     * @param actionEvent
     */
    @FXML
    public void but_signAndOut(ActionEvent actionEvent) {
        table_log.setItems(dataInLog);
        col_sign_NO.setCellValueFactory(new PropertyValueFactory<BeanLog, Integer>("NO"));
        col_sign_time.setCellValueFactory(new PropertyValueFactory<BeanLog, String>("date"));
        col_sign_type.setCellValueFactory(new PropertyValueFactory<BeanLog, String>("type"));
        if(tabs_father.getTabs().contains(tab_log)) {
            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
            tabs_father.selectionModelProperty().set(selectionModel);
        } else {
            tabs_father.getTabs().add(tab_log);
        }
        tabs_father.getSelectionModel().select(tab_log);
    }

    /**
     * 签到，签退操作
     * @param actionEvent
     */
    @FXML
    public void but_sign_operation(ActionEvent actionEvent) {
        if(student.getStatus() == 1) { // 进行签退
            biz.signOut(student.getStudent_id());
            student.setStatus(0);
            but_message.setText("签到");
        } else if(student.getStatus() == 0){ // 进行签到
            biz.signIn(student.getStudent_id());
            student.setStatus(1);
            but_message.setText("签退");
        }
        dataInLog.clear();
        updateLogMessage();

    }

    /**
     * 更新签到表格
     */
    private void updateLogMessage() {
        List<Log> logList = biz.selectLogByStudent_id(student.getStudent_id());
        int cnt_Log = 0;
        Log logLast = null;
        for(Log log : logList) {
            BeanLog beanLog = null;
            if(log.getType() == 2) {
                beanLog = new BeanLog(++ cnt_Log, "签到", log.getDate());
                logLast = log;
            } else if(log.getType() == 3) {
                beanLog = new BeanLog(++ cnt_Log, "签退", log.getDate());
                logLast = log;
            }
            dataInLog.add(beanLog);
        }
        if(logLast != null) {
            txt_sign_time.setText(logLast.getDate());
        } else {
            txt_sign_time.setText("暂无记录");
        }
    }

    /**
     * note 显示缴费tab
     * @param actionEvent
     */
    @FXML
    public void but_saveMoney(ActionEvent actionEvent) {
        txt_money_deposit.setText(String.valueOf(dorm.getDeposit()));
        txt_money_dromName.setText(dorm.getName());
        table_money.setItems(dataMoney);
        col_money_NO.setCellValueFactory(new PropertyValueFactory<BeanMoney, Integer>("NO"));
        col_money_dormNumber.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("dormNumber"));
        col_money_account.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("account"));
        col_money_person.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("person"));
        col_money_personId.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("personId"));
        col_money_date.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("date"));
        if(tabs_father.getTabs().contains(tab_money)) {
            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
            tabs_father.selectionModelProperty().set(selectionModel);
        } else {
            tabs_father.getTabs().add(tab_money);
        }
        tabs_father.getSelectionModel().select(tab_money);
    }

    /**
     * note 宿舍缴费按钮
     * @param actionEvent
     */
    public void but_money_toSave(ActionEvent actionEvent) {
        String valueIn = txt_money_toSave.getText();
        try{
            double value = Double.parseDouble(valueIn);
            if(biz.saveMoney(student.getStudent_id(), dorm.getBuilding_id(), dorm.getDorm_id(), value)) {
                lab_money_message.setText("缴费成功！");
                lab_money_message.setTextFill(Color.GREEN);
                dataMoney.clear();
                updateMoneyMessage();
            } else if(value == 0) {
                lab_money_message.setText("缴费金额无效！");
                lab_money_message.setTextFill(Color.RED);
            } else {
                lab_money_message.setText("缴费失败！");
                lab_money_message.setTextFill(Color.RED);
            }
        } catch (NumberFormatException e) {
            lab_money_message.setText("您输入的不是数字！");
            lab_money_message.setTextFill(Color.RED);
        } catch (InputValueException e) {
            lab_money_message.setText("您输入了一个负数！");
            lab_money_message.setTextFill(Color.RED);
        }
    }

    /**
     * 更新缴费表格
     */
    private void updateMoneyMessage() {
        List<Log> logList = biz.selectLogByBuilding_idAndDorm_id(dorm.getBuilding_id(), dorm.getDorm_id());
        int cnt_Log = 0;
        for(Log log : logList) {
            BeanMoney beanMoney = new BeanMoney(++ cnt_Log, log.getBuilding_id() + "#" + log.getDorm_id(), String.valueOf(log.getAccount()), biz.selectStudentById(log.getAccount_id()).getName(), log.getAccount_id(), log.getDate());
            dataMoney.add(beanMoney);
        }
    }

    /**
     * note 保存所有信息，注销账号，关闭程序
     * @param actionEvent
     */
    @FXML
    public void but_logout(ActionEvent actionEvent) {
        biz.updateStudentInfo(student.getStudent_id(), student);
        biz.updateDormInfo(student.getBuilding_id(), student.getDorm_id(), dorm);
        Session.setNumber("");
        Platform.exit();
    }
}
