package com.dms.Controller;

import com.dms.DmsUtils.*;
import com.dms.Ex.*;
import com.dms.Po.*;
import com.dms.Service.Implementation.BizImpl;
import com.dms.Service.Interfaces.Biz;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerController {

    private final Biz biz = new BizImpl();

    private Manager manager;
    private Student observedStudent;
    private Dorm observedDorm;
    private List<Log> observedLogs = new ArrayList<>();
    private final ObservableList<BeanDorm> dataInBuilding = FXCollections.observableArrayList();
    private final ObservableList<BeanPerson> dataInDorm = FXCollections.observableArrayList();
    private final ObservableList<BeanLog> dataInLog = FXCollections.observableArrayList();
    private final ObservableList<BeanMoney> dataMoney = FXCollections.observableArrayList();


    // x0 首页信息
    @FXML
    public Label lab_name;
    @FXML
    public Tab tab_welcome;
    @FXML
    public Tab tab_person;
    @FXML
    public Tab tab_student;
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
    @FXML
    public TabPane tabs_father;
    // x1 个人信息
    @FXML
    public TextField txt_managerName;
    @FXML
    public TextField txt_managerId;
    @FXML
    public TextField txt_managerContact;
    @FXML
    public TextField txt_managerBuilding;
    @FXML
    public Label lab_messageInPerson;
    // x2 楼宇信息（查看宿舍）
    @FXML
    public TableView<BeanDorm> table_building;
    @FXML
    public TableColumn<BeanDorm, Integer> col_NOInBuilding;
    @FXML
    public TableColumn<BeanDorm, String> col_dorm_idInBuilding;
    @FXML
    public TableColumn<BeanDorm, String> col_dormNameInBuilding;
    @FXML
    public TableColumn<BeanDorm, String> col_numberInBuilding;
    @FXML
    public TableColumn<BeanDorm, String> col_peopleInBuilding;
    @FXML
    public TableColumn<BeanDorm, String> col_depositInBuilding;
    @FXML
    public Label lab_messageToSelectInBuilding;
    @FXML
    public TextField txt_building_idInBuilding;
    @FXML
    public TextField txt_dorm_id_InBuilding;
    @FXML
    public Label lab_messageInBuilding;
    // x3 宿舍信息
    @FXML
    public TextField txt_dormName;
    @FXML
    public Label lab_messageInDorm;
    @FXML
    public TextField txt_dormMoney;
    @FXML
    public Label lab_messageToSelectInDorm;
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
    // x4 学生信息
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
    @FXML
    public TextField txt_dorm_id;
    @FXML
    public TextField txt_bed_id;
    @FXML
    public Label lab_messageInStudent;
    // x5 签到签退
    @FXML
    public TableView<BeanLog> table_log;
    @FXML
    public TableColumn<BeanLog, Integer> col_sign_NO;
    @FXML
    public TableColumn<BeanLog, String> col_sign_number;
    @FXML
    public TableColumn<BeanLog, String> col_sign_time;
    @FXML
    public TableColumn<BeanLog, String> col_sign_type;
    @FXML
    public DatePicker date_chooseInLog;
    // x6 缴费模块
    @FXML
    public TextField txt_money_dormName;
    @FXML
    public TextField txt_money_deposit;
    @FXML
    public TextField txt_money_toSave;
    @FXML
    public Label lab_money_message;
    @FXML
    public TableView<BeanMoney> table_money;
    @FXML
    public TableColumn<BeanMoney, Integer> col_money_NO;
    @FXML
    public TableColumn<BeanMoney, String> col_money_dormNumber;
    @FXML
    public TableColumn<BeanMoney, String> col_money_account;
    @FXML
    public TableColumn<BeanMoney, String> col_money_person;
    @FXML
    public TableColumn<BeanMoney, String> col_money_personId;
    @FXML
    public TableColumn<BeanMoney, String> col_money_date;
    // x7 reset模块
    @FXML
    public PasswordField txt_passwordBefore;
    @FXML
    public PasswordField txt_passwordNewOne;
    @FXML
    public PasswordField txt_passwordNewTow;
    @FXML
    public Label lab_message_password;


    /**
     * note 初始化
     */
    @FXML
    public void initialize() {
        // note 刷新
        manager = biz.selectManagerById(Session.getNumber());
        refreshAll();
        // note 设置所有tab可关闭（除了welcome）
        tabs_father.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
        tab_welcome.setClosable(false);
        // note 默认以下tab初始不显示
        tabs_father.getTabs().remove(tab_person);
        tabs_father.getTabs().remove(tab_student);
        tabs_father.getTabs().remove(tab_dorm);
        tabs_father.getTabs().remove(tab_building);
        tabs_father.getTabs().remove(tab_log);
        tabs_father.getTabs().remove(tab_money);
        tabs_father.getTabs().remove(tab_resetPassword);
        /* note 设置内部TableView数据源 */
        // x1 楼宇
        table_building.setItems(dataInBuilding);
        col_NOInBuilding.setCellValueFactory(new PropertyValueFactory<BeanDorm, Integer>("NO"));
        col_dorm_idInBuilding.setCellValueFactory(new PropertyValueFactory<BeanDorm, String>("dorm_id"));
        col_dormNameInBuilding.setCellValueFactory(new PropertyValueFactory<BeanDorm, String>("name"));
        col_numberInBuilding.setCellValueFactory(new PropertyValueFactory<BeanDorm, String>("number"));
        col_peopleInBuilding.setCellValueFactory(new PropertyValueFactory<BeanDorm, String>("people"));
        col_depositInBuilding.setCellValueFactory(new PropertyValueFactory<BeanDorm, String>("deposit"));
        // x2 宿舍
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
        // x3 日志
        table_log.setItems(dataInLog);
        col_sign_NO.setCellValueFactory(new PropertyValueFactory<BeanLog, Integer>("NO"));
        col_sign_number.setCellValueFactory(new PropertyValueFactory<BeanLog, String>("number"));
        col_sign_time.setCellValueFactory(new PropertyValueFactory<BeanLog, String>("date"));
        col_sign_type.setCellValueFactory(new PropertyValueFactory<BeanLog, String>("type"));
        // x4 缴费
        table_money.setItems(dataMoney);
        col_money_NO.setCellValueFactory(new PropertyValueFactory<BeanMoney, Integer>("NO"));
        col_money_dormNumber.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("dormNumber"));
        col_money_account.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("account"));
        col_money_person.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("person"));
        col_money_personId.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("personId"));
        col_money_date.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("date"));
    }

    /**
     * note 显示resetPassword tab
     * */
    @FXML
    public void but_resetPassword(ActionEvent actionEvent) {
        try {
            boolean flag = biz.resetPassword(Session.getNumber(), TranMD5.md5(txt_passwordBefore.getText()), TranMD5.md5(txt_passwordNewOne.getText()),TranMD5.md5(txt_passwordNewTow.getText()));
            if(flag) {
                lab_message_password.setText("修改密码成功");
                lab_message_password.setTextFill(Color.rgb(16,185,16));
                txt_passwordBefore.setText("");
                txt_passwordNewOne.setText("");
                txt_passwordNewTow.setText("");
            } else {
                lab_message_password.setText("修改密码失败");
                lab_message_password.setTextFill(Color.RED);
            }
        } catch (PasswordWrongException e) {
            lab_message_password.setText("密码错误");
            lab_message_password.setTextFill(Color.RED);
        } catch (PasswordNotSameException e) {
            lab_message_password.setText("输入两次密码不相同");
            lab_message_password.setTextFill(Color.RED);
        } catch (PasswordSameWithBeforeException e) {
            lab_message_password.setText("与之前设置的密码相同");
            lab_message_password.setTextFill(Color.RED);
        }
    }

    /**
     * note 刷新
     * @param actionEvent
     */
    @FXML
    public void but_refreshAll(ActionEvent actionEvent) {
        refreshAll();
    }

    /**
     * note 刷新所有
     */
    private void refreshAll() {
        // note 重新从数据库获取实体类
        manager = biz.selectManagerById(Session.getNumber());
        // note 设置主页面和分页面的其他信息
        lab_name.setText(manager.getName());
        lab_messageInPerson.setText("");
        lab_messageInDorm.setText("");
        lab_money_message.setText("");
        lab_message_password.setText("");
        lab_messageInStudent.setText("");
        lab_messageInBuilding.setText("");
        lab_messageToSelectInBuilding.setTextFill(Color.BLACK);
        lab_messageToSelectInDorm.setTextFill(Color.BLACK);
        // note 设置管理员个人信息tab
        List<Building> buildingChargeBySession = biz.selectBuildingsByManager_id(manager.getManager_id());
        String buildingNameList = "";
        for(int i = 0 ; i < buildingChargeBySession.size() ; i ++) {
            if(i != 0) {
                buildingNameList += ", ";
            }
            buildingNameList += buildingChargeBySession.get(i).getName();
        }
        txt_managerName.setText(manager.getName());
        txt_managerId.setText(manager.getManager_id());
        txt_managerContact.setText(manager.getContact());
        txt_managerBuilding.setText(buildingNameList);
        // note 设置楼宇tab(查找所有)
        dataInBuilding.clear();
        List<Dorm> allDorm = biz.selectAllDorm();
        int cntAllDorm = 0;
        for(Dorm dorm :allDorm) {
            List<Student> studentList = biz.selectStudentByBuilding_idAndDorm_id(dorm.getBuilding_id(), dorm.getDorm_id());
            String studentNameList = "";
            for(int i = 0 ; i < studentList.size() ; i ++) {
                if(i != 0) {
                    studentNameList += ", ";
                }
                studentNameList += studentList.get(i).getName();
            }
            BeanDorm beanDorm = new BeanDorm(++ cntAllDorm, dorm.getBuilding_id() + "#" + dorm.getDorm_id(), dorm.getName(), studentList.size() + "/" + dorm.getPeople_num(), String.valueOf(studentNameList), dorm.getDeposit());
            dataInBuilding.add(beanDorm);
        }
    }

    /**
     * note 刷新宿舍tab数据
     */
    private void refreshDormInfo() {
        txt_dormName.setText(observedDorm.getName());
        txt_dormMoney.setText(String.valueOf(observedDorm.getDeposit()));
        dataInDorm.clear();
        List<Student> students = biz.selectStudentByBuilding_idAndDorm_id(observedDorm.getBuilding_id(), observedDorm.getDorm_id());
        for(Student student : students) {
            BeanPerson beanPerson = new BeanPerson(student.getBuilding_id() + "#" + student.getDorm_id(), student.getBed_id() + "", student.getName(), student.getStudent_id(), student.getBirthday(), student.getContact(), student.getMajor(), student.getClasses(), (student.getStatus() == 1 ? "已签到" : "已签退"));
            dataInDorm.add(beanPerson);
        }
        txt_money_deposit.setText(String.valueOf(observedDorm.getDeposit()));
        txt_money_dormName.setText(observedDorm.getName());
        dataMoney.clear();
        List<Log> moneyLogList = biz.selectLogByBuilding_idAndDorm_id(observedDorm.getBuilding_id(), observedDorm.getDorm_id());
        int cntMoneyLog = 0;
        for(Log log : moneyLogList) {
            if(log.getType() == 1) {
                String name = "";
                if(biz.selectStudentById(log.getAccount_id()) != null) {
                    name = biz.selectStudentById(log.getAccount_id()).getName();
                } else {
                    name = biz.selectManagerById(log.getAccount_id()).getName();
                }
                BeanMoney beanMoney = new BeanMoney(++cntMoneyLog, log.getBuilding_id() + "#" + log.getDorm_id(), String.valueOf(log.getAccount()), name, log.getAccount_id(), log.getDate());
                dataMoney.add(beanMoney);
            }
        }
    }

    /**
     * note 刷新学生tab数据
     */
    private void refreshStudentInfo() {
        txt_name.setText(observedStudent.getName());
        txt_gender.setText(observedStudent.getGender());
        txt_birthday.setText(observedStudent.getBirthday());
        txt_contact.setText(observedStudent.getContact());
        txt_student_id.setText(observedStudent.getStudent_id());
        txt_college.setText(observedStudent.getCollege());
        txt_major.setText(observedStudent.getMajor());
        txt_class.setText(observedStudent.getClasses());
        txt_dorm_id.setText(observedStudent.getBuilding_id() + "#" + observedStudent.getDorm_id());
        txt_bed_id.setText(observedStudent.getBed_id() + "");
    }

    /**
     * note 刷新日志tab数据
     */
    private void refreshLogInfo() {
        dataInLog.clear();
        int cntSignLog = 0;
        for(Log log : observedLogs) {
            BeanLog beanLog = null;
            if(log.getType() == 2) {
                beanLog = new BeanLog(++cntSignLog, log.getAccount_id(), "签到", log.getDate());
                dataInLog.add(beanLog);
            } else if(log.getType() == 3) {
                beanLog = new BeanLog(++cntSignLog, log.getAccount_id(), "签退", log.getDate());
                dataInLog.add(beanLog);
            }
        }
    }

    /**
     * note 显示个人信息 tab
     * @param actionEvent
     */
    @FXML
    public void but_person(ActionEvent actionEvent) {
        manager = biz.selectManagerById(Session.getNumber());
        // note 如果父tab已经有该子tab，聚焦；否则，添加到父tab（下同）
        if(tabs_father.getTabs().contains(tab_person)) {
            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
            tabs_father.selectionModelProperty().set(selectionModel);
        } else {
            tabs_father.getTabs().add(tab_person);
        }
        tabs_father.getSelectionModel().select(tab_person);
    }

    /**
     *  note 显示楼宇信息 tab
     */
    @FXML
    public void but_building(ActionEvent actionEvent) {
        // note 如果父tab已经有该子tab，聚焦；否则，添加到父tab（下同）
        if(tabs_father.getTabs().contains(tab_building)) {
            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
            tabs_father.selectionModelProperty().set(selectionModel);
        } else {
            tabs_father.getTabs().add(tab_building);
        }
        tabs_father.getSelectionModel().select(tab_building);
    }

    /**
     *  note 退出程序 tab
     */
    @FXML
    public void but_logout(ActionEvent actionEvent) {
        // note 关闭程序前保存信息，清空Session缓存
        biz.updateManagerInfo(Session.getNumber(), manager);
        Session.setNumber("");
        System.exit(0);
    }

    /**
     *  note 编辑个人信息
     */
    @FXML
    public void but_personEdit(ActionEvent actionEvent) {
        txt_managerName.setEditable(true);
        txt_managerContact.setEditable(true);
        lab_messageInPerson.setText("正在编辑");
        lab_messageInPerson.setTextFill(Color.BLUE);
    }

    /**
     *  note 保存个人信息
     */
    @FXML
    public void but_personSave(ActionEvent actionEvent) {
        // note 设置不可编辑
        txt_managerName.setEditable(false);
        txt_managerContact.setEditable(false);
        // note 保存信息到manager
        manager.setName(txt_managerName.getText());
        manager.setContact(txt_managerContact.getText());
        // note 上传数据到数据库，并给予信息提示
        boolean flag = biz.updateManagerInfo(Session.getNumber(), manager);
        refreshAll();
        if(flag) {
            lab_messageInPerson.setText("保存成功！");
            lab_messageInPerson.setTextFill(Color.rgb(16,185,16));
        } else {
            lab_messageInPerson.setText("保存失败！");
            lab_messageInPerson.setTextFill(Color.RED);
        }
    }

    /**
     *  note 在楼宇tab下根据条件查找宿舍
     */
    @FXML
    public void but_searchInBuilding(ActionEvent actionEvent) {
        String building_id = txt_building_idInBuilding.getText();
        String dorm_id = txt_dorm_id_InBuilding.getText();
        dataInBuilding.clear();
        if(building_id.equals("")) {
            if(dorm_id.equals("")) {
                // x1 全空，查找全部宿舍
                List<Dorm> allDorm = biz.selectAllDorm();
                int cntAllDorm = 0;
                for(Dorm dorm :allDorm) {
                    List<Student> studentList = biz.selectStudentByBuilding_idAndDorm_id(dorm.getBuilding_id(), dorm.getDorm_id());
                    String studentNameList = "";
                    for(int i = 0 ; i < studentList.size() ; i ++) {
                        if(i != 0) {
                            studentNameList += ", ";
                        }
                        studentNameList += studentList.get(i).getName();
                    }
                    BeanDorm beanDorm = new BeanDorm(++ cntAllDorm, dorm.getBuilding_id() + "#" + dorm.getDorm_id(), dorm.getName(), studentList.size() + "/" + dorm.getPeople_num(), String.valueOf(studentNameList), dorm.getDeposit());
                    dataInBuilding.add(beanDorm);
                }
                lab_messageInBuilding.setText("查找成功");
                lab_messageInBuilding.setTextFill(Color.rgb(16,185,16));
            } else {
                // x2 只有宿舍，报错输入楼宇号
                lab_messageInBuilding.setText("请先输入楼宇编号");
                lab_messageInBuilding.setTextFill(Color.RED);
            }
        } else {
            if(dorm_id.equals("")) {
                // x3 只有楼宇，根据楼宇查找
                List<Dorm> allDorm = biz.selectDormByBuilding_id(building_id);
                int cntAllDorm = 0;
                for(Dorm dorm :allDorm) {
                    List<Student> studentList = biz.selectStudentByBuilding_idAndDorm_id(dorm.getBuilding_id(), dorm.getDorm_id());
                    String studentNameList = "";
                    for(int i = 0 ; i < studentList.size() ; i ++) {
                        if(i != 0) {
                            studentNameList += ", ";
                        }
                        studentNameList += studentList.get(i).getName();
                    }
                    BeanDorm beanDorm = new BeanDorm(++ cntAllDorm, dorm.getBuilding_id() + "#" + dorm.getDorm_id(), dorm.getName(), studentList.size() + "/" + dorm.getPeople_num(), String.valueOf(studentNameList), dorm.getDeposit());
                    dataInBuilding.add(beanDorm);
                }
                if(cntAllDorm != 0) {
                    lab_messageInBuilding.setText("查找成功");
                    lab_messageInBuilding.setTextFill(Color.rgb(16,185,16));
                } else {
                    lab_messageInBuilding.setText("查找为空");
                    lab_messageInBuilding.setTextFill(Color.RED);
                }
            } else {
                // x4 包含所有信息，精确查找
                try {
                    Dorm dorm = biz.selectDormByBuilding_idAndDorm_id(building_id, dorm_id);
                    List<Student> studentList = biz.selectStudentByBuilding_idAndDorm_id(dorm.getBuilding_id(), dorm.getDorm_id());
                    String studentNameList = "";
                    for(int i = 0 ; i < studentList.size() ; i ++) {
                        if(i != 0) {
                            studentNameList += ", ";
                        }
                        studentNameList += studentList.get(i).getName();
                    }
                    BeanDorm beanDorm = new BeanDorm(1, dorm.getBuilding_id() + "#" + dorm.getDorm_id(), dorm.getName(), studentList.size() + "/" + dorm.getPeople_num(), String.valueOf(studentNameList), dorm.getDeposit());
                    dataInBuilding.add(beanDorm);
                    lab_messageInBuilding.setText("查找成功");
                    lab_messageInBuilding.setTextFill(Color.rgb(16,185,16));
                } catch (NoSuchAccountException e) {
                    lab_messageInBuilding.setText("宿舍不存在");
                    lab_messageInBuilding.setTextFill(Color.RED);
                }
            }
        }
    }

    /**
     * note 编辑宿舍信息
     */
    @FXML
    public void but_dormNameEdit(ActionEvent actionEvent) {
        // note 设置内容可编辑，并给予信息提示
        txt_dormName.setEditable(true);
        lab_messageInDorm.setText("正在修改");
        lab_messageInDorm.setTextFill(Color.BLUE);
    }

    /**
     * note 保存宿舍信息
     */
    @FXML
    public void but_dormNameSave(ActionEvent actionEvent) {
        // note 保存信息到dorm类，访问数据库并更新
        observedDorm.setName(txt_dormName.getText());
        boolean flag = biz.updateDormInfo(observedDorm.getBuilding_id(), observedDorm.getDorm_id(), observedDorm);
        refreshAll();
        if(flag) {
            lab_messageInDorm.setText("保存成功！");
            lab_messageInDorm.setTextFill(Color.rgb(16,185,16));
        } else {
            lab_messageInDorm.setText("保存失败！");
            lab_messageInDorm.setTextFill(Color.RED);
        }
        txt_dormName.setEditable(false);
    }

    /**
     * note 前往缴费
     */
    @FXML
    public void but_saveMoney(ActionEvent actionEvent) {
        if(tabs_father.getTabs().contains(tab_money)) {
            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
            tabs_father.selectionModelProperty().set(selectionModel);
        } else {
            tabs_father.getTabs().add(tab_money);
        }
        tabs_father.getSelectionModel().select(tab_money);
    }

    /**
     * note 执行缴费操作
     */
    @FXML
    public void but_money_toSave(ActionEvent actionEvent) {
        String valueIn = txt_money_toSave.getText();
        try{
            double value = Double.parseDouble(valueIn);
            boolean flag = biz.saveMoney(Session.getNumber(), observedDorm.getBuilding_id(), observedDorm.getDorm_id(), value);
            refreshAll();
            if(flag) {
                lab_money_message.setText("缴费成功！");
                lab_money_message.setTextFill(Color.rgb(16,185,16));
                try {
                    observedDorm = biz.selectDormByBuilding_idAndDorm_id(observedDorm.getBuilding_id(), observedDorm.getDorm_id());
                    refreshDormInfo();
                } catch (NoSuchAccountException e) {
                    lab_messageInDorm.setText("尚未分配宿舍");
                    lab_messageInDorm.setTextFill(Color.RED);
                }
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
        txt_money_deposit.setText(String.valueOf(observedDorm.getDeposit()));
        txt_money_toSave.setText("");
    }

    /**
     * note 转跳到宿舍界面
     * @param actionEvent
     */
    @FXML
    public void but_jumpToDorm(ActionEvent actionEvent) {
        try {
            String DB_id = table_building.getSelectionModel().getSelectedItem().getDorm_id();
            observedDorm = biz.selectDormByBuilding_idAndDorm_id(DB_id.substring(0, DB_id.indexOf("#")), DB_id.substring(DB_id.indexOf("#") + 1));
            refreshDormInfo();
            // note 如果父tab已经有该子tab，聚焦；否则，添加到父tab（下同）
            if(tabs_father.getTabs().contains(tab_dorm)) {
                SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
                tabs_father.selectionModelProperty().set(selectionModel);
            } else {
                tabs_father.getTabs().add(tab_dorm);
            }
            tabs_father.getSelectionModel().select(tab_dorm);
        } catch (NoSuchAccountException e) {
            lab_messageInBuilding.setText("未找到宿舍");
            lab_messageInBuilding.setTextFill(Color.RED);
        } catch (Exception e) {
            lab_messageToSelectInBuilding.setTextFill(Color.RED);
        }
    }

    /**
     * note 转跳到学生信息界面
     * @param actionEvent
     */
    @FXML
    public void but_jumpToStudent(ActionEvent actionEvent) {
        try {
            observedStudent = biz.selectStudentById(table_dorm.getSelectionModel().getSelectedItem().getStudent_id());
            refreshStudentInfo();
            // note 如果父tab已经有该子tab，聚焦；否则，添加到父tab（下同）
            if(tabs_father.getTabs().contains(tab_student)) {
                SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
                tabs_father.selectionModelProperty().set(selectionModel);
            } else {
                tabs_father.getTabs().add(tab_student);
            }
            tabs_father.getSelectionModel().select(tab_student);
        } catch (Exception e) {
            lab_messageToSelectInDorm.setTextFill(Color.RED);
        }
    }

    /**
     * note 修改学生信息
     * @param actionEvent
     */
    @FXML
    public void but_studentEdit(ActionEvent actionEvent) {
        // note 设置内容可编辑，并给予信息提示
        txt_name.setEditable(true);
        txt_birthday.setEditable(true);
        txt_contact.setEditable(true);
        txt_college.setEditable(true);
        txt_major.setEditable(true);
        txt_class.setEditable(true);
        txt_dorm_id.setEditable(true);
        txt_bed_id.setEditable(true);
        lab_messageInStudent.setText("正在编辑");
        lab_messageInStudent.setTextFill(Color.BLUE);
    }

    /**
     * note 保存学生信息
     * @param actionEvent
     */
    @FXML
    public void but_studentSave(ActionEvent actionEvent) {
        // note 设置不可编辑
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
        // note 保存信息到student
        observedStudent.setName(txt_name.getText());
        observedStudent.setBirthday(txt_birthday.getText());
        observedStudent.setContact(txt_contact.getText());
        observedStudent.setCollege(txt_college.getText());
        observedStudent.setMajor(txt_major.getText());
        observedStudent.setClasses(txt_class.getText());
        String[] dormData = txt_dorm_id.getText().split("#");
        observedStudent.setDorm_id(dormData[0]);
        observedStudent.setDorm_id(dormData[1]);
        observedStudent.setBed_id(Integer.parseInt(txt_bed_id.getText()));
        // note 上传数据到数据库，并给予信息提示
        boolean flag = biz.updateStudentInfo(observedStudent.getStudent_id(), observedStudent);
        // note 刷新
        refreshAll();
        if(flag) {
            lab_messageInStudent.setText("保存成功！");
            lab_messageInStudent.setTextFill(Color.rgb(16,185,16));
        } else {
            lab_messageInStudent.setText("保存失败！");
            lab_messageInStudent.setTextFill(Color.RED);
        }
    }

    /**
     * note 清空查找信息
     * @param actionEvent
     */
    @FXML
    public void but_resetSearch(ActionEvent actionEvent) {
        txt_building_idInBuilding.setText("");
        txt_dorm_id_InBuilding.setText("");
        dataInBuilding.clear();
        List<Dorm> allDorm = biz.selectAllDorm();
        int cntAllDorm = 0;
        for(Dorm dorm :allDorm) {
            List<Student> studentList = biz.selectStudentByBuilding_idAndDorm_id(dorm.getBuilding_id(), dorm.getDorm_id());
            String studentNameList = "";
            for(int i = 0 ; i < studentList.size() ; i ++) {
                if(i != 0) {
                    studentNameList += ", ";
                }
                studentNameList += studentList.get(i).getName();
            }
            BeanDorm beanDorm = new BeanDorm(++ cntAllDorm, dorm.getBuilding_id() + "#" + dorm.getDorm_id(), dorm.getName(), studentList.size() + "/" + dorm.getPeople_num(), String.valueOf(studentNameList), dorm.getDeposit());
            dataInBuilding.add(beanDorm);
        }
    }

    /**
     * note 跳转修改密码tab
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
     * note 清空选择日期
     * @param actionEvent
     */
    @FXML
    public void but_resetInLog(ActionEvent actionEvent) {
        observedLogs = biz.selectAllLog();
        refreshLogInfo();
    }

    /**
     * note 根据日期查询当天的日志
     * @param actionEvent
     */
    @FXML
    public void but_searchInLog(ActionEvent actionEvent) {
        if(date_chooseInLog.getValue() == null) {
            observedLogs = biz.selectAllLog();
            refreshLogInfo();
            return;
        }
        observedLogs.clear();
        LocalDate date = date_chooseInLog.getValue();
        List<Log> logList = biz.selectAllLog();
        for(Log log : logList) {
            long logDate = DateUtil.stringToLong(log.getDate());
            long startDate = DateUtil.localDateToLong(date);
            if(logDate >= startDate && logDate <= startDate + 86400000) {
                observedLogs.add(log);
            }
        }
        refreshLogInfo();
    }

    /**
     * note 跳转日志tab
     * @param actionEvent
     */
    @FXML
    public void but_log(ActionEvent actionEvent) {
        // note 如果父tab已经有该子tab，聚焦；否则，添加到父tab（下同）
        if(tabs_father.getTabs().contains(tab_log)) {
            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
            tabs_father.selectionModelProperty().set(selectionModel);
        } else {
            tabs_father.getTabs().add(tab_log);
        }
        tabs_father.getSelectionModel().select(tab_log);
    }
}
