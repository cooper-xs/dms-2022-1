package com.dms.Controller;

import com.dms.DmsUtils.TranMD5;
import com.dms.Ex.*;
import com.dms.Po.*;
import com.dms.Service.Implementation.BizImpl;
import com.dms.Service.Interfaces.Biz;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.util.List;

public class StudentController {

    public static Biz biz = new BizImpl();
    private Student student;
    private Student observed;
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
    public TableColumn<BeanPerson, Boolean> col_operate;
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
    public Label lab_messageInLog;
    @FXML
    public TableView<BeanLog> table_log;
    @FXML
    public TableColumn<BeanLog, Integer> col_sign_NO;
    @FXML
    public TableColumn<BeanLog, String> col_sign_time;
    @FXML
    public TableColumn<BeanLog, String> col_sign_type;
    // x5 money模块
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
    // x6 reset模块
    @FXML
    public PasswordField txt_passwordBefore;
    @FXML
    public PasswordField txt_passwordNewOne;
    @FXML
    public PasswordField txt_passwordNewTow;
    @FXML
    public Label lab_message_password;
    private class findPerson extends TableCell<BeanPerson, Boolean> {
        // note 添加按钮
        final Button but_viewObserved = new Button("查看");
        // note 在单元格中填充并居中添加按钮。
        final StackPane paddedButton = new StackPane();

        findPerson(final TableView<BeanPerson> table) {
            paddedButton.setPadding(new Insets(3));
            paddedButton.getChildren().add(but_viewObserved);
            but_viewObserved.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent actionEvent) {
                    observed = biz.selectStudentById(table.getSelectionModel().getSelectedItem().getStudent_id());
                    refreshAll();
                    // note 如果父tab已经有该子tab，聚焦；否则，添加到父tab（下同）
                    if(tabs_father.getTabs().contains(tab_person)) {
                        SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
                        tabs_father.selectionModelProperty().set(selectionModel);
                    } else {
                        tabs_father.getTabs().add(tab_person);
                    }
                    tabs_father.getSelectionModel().select(tab_person);
                }
            });
        }
        // note 仅当该行不为空时，才会在该行中放置一个添加按钮。
        @Override protected void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);
            if (!empty) {
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setGraphic(paddedButton);
            } else {
                setGraphic(null);
            }
        }
    }
    /**
     * 初始化
     */
    @FXML
    public void initialize() {
        // note 为操作列定义一个简单的布尔单元格值，以便该列仅显示为非空行。
        col_operate.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<BeanPerson, Boolean>, ObservableValue<Boolean>>() {
            @Override public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<BeanPerson, Boolean> features) {
                return new SimpleBooleanProperty(features.getValue() != null);
            }
        });
        // note 为表格中的每一行创建一个带有添加按钮的单元格值工厂。
        col_operate.setCellFactory(new Callback<TableColumn<BeanPerson, Boolean>, TableCell<BeanPerson, Boolean>>() {
            @Override public TableCell<BeanPerson, Boolean> call(TableColumn<BeanPerson, Boolean> personBooleanTableColumn) {
                return new findPerson(table_dorm);
            }
        });

        // note 初始化被观察者是自己
        observed = biz.selectStudentById(Session.getNumber());
        // note 刷新
        refreshAll();
        // note 设置所有tab可关闭（除了welcome）
        tabs_father.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
        tab_welcome.setClosable(false);
        // note 默认以下tab初始不显示
        tabs_father.getTabs().remove(tab_person);
        tabs_father.getTabs().remove(tab_dorm);
        tabs_father.getTabs().remove(tab_building);
        tabs_father.getTabs().remove(tab_log);
        tabs_father.getTabs().remove(tab_money);
        tabs_father.getTabs().remove(tab_resetPassword);
        /* note 设置内部TableView数据源 */
        // x1 宿舍
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
        // x2 日志
        table_log.setItems(dataInLog);
        col_sign_NO.setCellValueFactory(new PropertyValueFactory<BeanLog, Integer>("NO"));
        col_sign_time.setCellValueFactory(new PropertyValueFactory<BeanLog, String>("date"));
        col_sign_type.setCellValueFactory(new PropertyValueFactory<BeanLog, String>("type"));
        // x3 缴费
        table_money.setItems(dataMoney);
        col_money_NO.setCellValueFactory(new PropertyValueFactory<BeanMoney, Integer>("NO"));
        col_money_dormNumber.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("dormNumber"));
        col_money_account.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("account"));
        col_money_person.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("person"));
        col_money_personId.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("personId"));
        col_money_date.setCellValueFactory(new PropertyValueFactory<BeanMoney, String>("date"));
    }

    // note 个人信息
    /**
     * note 显示个人信息tab
     * @param actionEvent
     */
    @FXML
    public void but_person(ActionEvent actionEvent) {
        observed = biz.selectStudentById(Session.getNumber());
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
     * note 修改个人信息按钮
     * @param actionEvent
     */
    @FXML
    public void but_personEdit(ActionEvent actionEvent) {
        // note 设置内容可编辑，并给予信息提示
        txt_name.setEditable(true);
        txt_birthday.setEditable(true);
        txt_contact.setEditable(true);
        txt_college.setEditable(true);
        txt_major.setEditable(true);
        txt_class.setEditable(true);
        txt_dorm_id.setEditable(true);
        txt_bed_id.setEditable(true);
        lab_messageInPerson.setText("正在编辑");
        lab_messageInPerson.setTextFill(Color.BLUE);
    }

    /**
     *  note 保存个人信息按钮
     * @param actionEvent
     */
    @FXML
    public void but_personSave(ActionEvent actionEvent) {
        // note 保存信息到student
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
        // note 上传数据到数据库，并给予信息提示
        boolean flag = biz.updateStudentInfo(Session.getNumber(), student);
        // note 刷新
        refreshAll();
        if(flag) {
            lab_messageInPerson.setText("保存成功！");
            lab_messageInPerson.setTextFill(Color.GREEN);
        } else {
            lab_messageInPerson.setText("保存失败！");
            lab_messageInPerson.setTextFill(Color.RED);
        }
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
    }

    // note 宿舍信息
    /**
     * note 显示宿舍信息tab
     * @param actionEvent
     */
    @FXML
    public void but_dorm(ActionEvent actionEvent) {
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
        // note 设置内容可编辑，并给予信息提示
        txt_dormName.setEditable(true);
        lab_messageInDorm.setText("正在修改");
        lab_messageInDorm.setTextFill(Color.BLUE);
    }

    /**
     * note 保存宿舍信息按钮
     * @param actionEvent
     */
    @FXML
    public void but_dormNameSave(ActionEvent actionEvent) {
        // note 保存信息到dorm类，访问数据库并更新
        dorm.setName(txt_dormName.getText());
        boolean flag = biz.updateDormInfo(student.getBuilding_id(), student.getDorm_id(), dorm);
        refreshAll();
        if(flag) {
            lab_messageInDorm.setText("保存成功！");
            lab_messageInDorm.setTextFill(Color.GREEN);
        } else {
            lab_messageInDorm.setText("保存失败！");
            lab_messageInDorm.setTextFill(Color.RED);
        }
        txt_dormName.setEditable(false);
    }

    // note 楼宇信息
    /**
     * note 显示楼宇信息tab
     * @param actionEvent
     */
    @FXML
    public void but_building(ActionEvent actionEvent) {
        if(tabs_father.getTabs().contains(tab_building)) {
            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
            tabs_father.selectionModelProperty().set(selectionModel);
        } else {
            tabs_father.getTabs().add(tab_building);
        }
        tabs_father.getSelectionModel().select(tab_building);
    }

    // note 签到信息
    /**
     * note 显示签到签退tab
     * @param actionEvent
     */
    @FXML
    public void but_signInAndOut(ActionEvent actionEvent) {
        if(tabs_father.getTabs().contains(tab_log)) {
            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
            tabs_father.selectionModelProperty().set(selectionModel);
        } else {
            tabs_father.getTabs().add(tab_log);
        }
        tabs_father.getSelectionModel().select(tab_log);
    }

    /**
     * note 签到，签退操作
     * @param actionEvent
     */
    @FXML
    public void but_sign_operation(ActionEvent actionEvent) {
        if(student.getStatus() == 1) { // note 进行签退
            boolean flag = biz.signOut(Session.getNumber());
            refreshAll();
            if(flag) {
                lab_messageInLog.setText("已签退");
                lab_messageInLog.setTextFill(Color.GREEN);
            } else {
                lab_messageInLog.setText("签退失败");
                lab_messageInLog.setTextFill(Color.RED);
            }
        } else if(student.getStatus() == 0){ // note 进行签到
            boolean flag = biz.signIn(Session.getNumber());
            refreshAll();
            if(flag) {
                lab_messageInLog.setText("已签到");
                lab_messageInLog.setTextFill(Color.GREEN);
            } else {
                lab_messageInLog.setText("签到失败");
                lab_messageInLog.setTextFill(Color.RED);
            }
        }
    }

    // note 缴费信息
    /**
     * note 显示缴费tab
     * @param actionEvent
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
     * note 宿舍缴费按钮
     * @param actionEvent
     */
    @FXML
    public void but_money_toSave(ActionEvent actionEvent) {
        String valueIn = txt_money_toSave.getText();
        try{
            double value = Double.parseDouble(valueIn);
            boolean flag = biz.saveMoney(Session.getNumber(), dorm.getBuilding_id(), dorm.getDorm_id(), value);
            refreshAll();
            if(flag) {
                lab_money_message.setText("缴费成功！");
                lab_money_message.setTextFill(Color.GREEN);
                try {
                    dorm = biz.selectDormByBuilding_idAndDorm_id(dorm.getBuilding_id(), dorm.getDorm_id());
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
        txt_money_deposit.setText(String.valueOf(dorm.getDeposit()));
        txt_money_toSave.setText("");
    }

    // note 退出
    /**
     * note 保存所有信息，注销账号，关闭程序
     * @param actionEvent
     */
    @FXML
    public void but_logout(ActionEvent actionEvent) {
        biz.updateStudentInfo(Session.getNumber(), student);
        biz.updateDormInfo(student.getBuilding_id(), student.getDorm_id(), dorm);
        Session.setNumber("");
        System.exit(0);
    }

    // note 其他封装函数

    /**
     * 刷新按钮
     * @param actionEvent
     */
    public void but_refreshAll(ActionEvent actionEvent) {
        refreshAll();
    }

    /**
     * 刷新所有用户信息和表格
     */
    private void refreshAll() {
        try {
            // note 重新从数据库获取实体类
            student = biz.selectStudentById(Session.getNumber());
            dorm = biz.selectDormByBuilding_idAndDorm_id(student.getBuilding_id(), student.getDorm_id());
            building = biz.selectBuildingByBuilding_id(student.getBuilding_id());
            manager = biz.selectManagerById(building.getManager_id());
            // note 设置主页面和分页面的其他信息
            lab_name.setText(student.getName());
            but_message.setText(student.getStatus() == 1 ? "签退" : "签到");
            lab_messageInPerson.setText("");
            lab_messageInDorm.setText("");
            lab_messageInLog.setText("");
            lab_money_message.setText("");
            // note 设置学生tab
            txt_name.setText(observed.getName());
            txt_gender.setText(observed.getGender());
            txt_birthday.setText(observed.getBirthday());
            txt_contact.setText(observed.getContact());
            txt_student_id.setText(observed.getStudent_id());
            txt_college.setText(observed.getCollege());
            txt_major.setText(observed.getMajor());
            txt_class.setText(observed.getClasses());
            txt_dorm_id.setText(observed.getBuilding_id() + "#" + observed.getDorm_id());
            txt_bed_id.setText(observed.getBed_id() + "");
            // note 设置宿舍tab
            txt_dormName.setText(dorm.getName());
            txt_dormMoney.setText(String.valueOf(dorm.getDeposit()));
            dataInDorm.clear();
            List<Student> students = biz.selectStudentByBuilding_idAndDorm_id(student.getBuilding_id(), student.getDorm_id());
            for(Student student : students) {
                BeanPerson beanPerson = new BeanPerson(student.getBuilding_id() + "#" + student.getDorm_id(), student.getBed_id() + "", student.getName(), student.getStudent_id(), student.getBirthday(), student.getContact(), student.getMajor(), student.getClasses(), (student.getStatus() == 1 ? "已签到" : "已签退"));
                dataInDorm.add(beanPerson);
            }
            // note 设置楼宇tab
            txt_building_dormId.setText(building.getName());
            txt_building_location.setText(building.getAddress());
            txt_building_manager.setText(manager.getName());
            txt_building_contact.setText(manager.getContact());
            txt_building_number.setText(String.valueOf(biz.selectStudentByBuilding_id(student.getBuilding_id()).size()));
            // note 设置日志tab
            dataInLog.clear();
            List<Log> signLogList = biz.selectLogByStudent_id(Session.getNumber());
            int cntSignLog = 0;
            Log logLast = null;
            for(Log log : signLogList) {
                BeanLog beanLog = null;
                if(log.getType() == 2) {
                    beanLog = new BeanLog(++cntSignLog, "签到", log.getDate());
                    logLast = log;
                    dataInLog.add(beanLog);
                } else if(log.getType() == 3) {
                    beanLog = new BeanLog(++cntSignLog, "签退", log.getDate());
                    logLast = log;
                    dataInLog.add(beanLog);
                }
            }
            if(logLast != null) {
                txt_sign_time.setText(logLast.getDate());
            } else {
                txt_sign_time.setText("暂无记录");
            }
            // note 设置缴费tab
            txt_money_deposit.setText(String.valueOf(dorm.getDeposit()));
            txt_money_dormName.setText(dorm.getName());
            dataMoney.clear();
            List<Log> moneyLogList = biz.selectLogByBuilding_idAndDorm_id(dorm.getBuilding_id(), dorm.getDorm_id());
            int cntMoneyLog = 0;
            for(Log log : moneyLogList) {
                BeanMoney beanMoney = new BeanMoney(++cntMoneyLog, log.getBuilding_id() + "#" + log.getDorm_id(), String.valueOf(log.getAccount()), biz.selectStudentById(log.getAccount_id()).getName(), log.getAccount_id(), log.getDate());
                dataMoney.add(beanMoney);
            }
        } catch (NoSuchAccountException e) {
            lab_messageInDorm.setText("尚未分配宿舍");
            lab_messageInDorm.setTextFill(Color.RED);
        }
    }

    /**
     * note 显示修改密码tab
     * @param actionEvent
     */
    @FXML
    public void but_reset(ActionEvent actionEvent) {
        if(tabs_father.getTabs().contains(tab_resetPassword)) {
            SingleSelectionModel<Tab> selectionModel = tabs_father.getSelectionModel();
            tabs_father.selectionModelProperty().set(selectionModel);
        } else {
            tabs_father.getTabs().add(tab_resetPassword);
        }
        tabs_father.getSelectionModel().select(tab_resetPassword);
    }

    /**
     * 修改密码按钮
     * @param actionEvent
     */
    @FXML
    public void but_resetPassword(ActionEvent actionEvent) {
        try {
            boolean flag = biz.resetPassword(Session.getNumber(), TranMD5.md5(txt_passwordBefore.getText()), TranMD5.md5(txt_passwordNewOne.getText()),TranMD5.md5(txt_passwordNewTow.getText()));
            if(flag) {
                lab_message_password.setText("修改密码成功");
                lab_message_password.setTextFill(Color.GREEN);
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
}
