package com.dms.Controller;

import com.dms.Ex.NoSuchAccountException;
import com.dms.Po.BeanPerson;
import com.dms.Po.Dorm;
import com.dms.Po.Session;
import com.dms.Po.Student;
import com.dms.Service.Implementation.BizImpl;
import com.dms.Service.Interfaces.Biz;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import java.util.List;

public class StudentController {
    private Student student;
    private Dorm dorm;
    public static Biz biz = new BizImpl();
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
    public Button but_dormNameEdit;
    @FXML
    public Button but_dormNameSave;
    @FXML
    public Label lab_messageInDorm;
    @FXML
    public TextField txt_dormMoney;

    /**
     * 初始化
     */
    @FXML
    public void initialize() {
        // 初始化一些东西
        student = biz.selectStudentById(Session.getNumber());
        try {
            dorm = biz.selectDormByBD(student.getBuilding_id(), student.getDorm_id());
        } catch (NoSuchAccountException e) {
            e.printStackTrace();
        }
        lab_name.setText(student.getName());
        lab_identity.setText("！（学生）");
        tabs_father.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
        tab_welcome.setClosable(false);
        tabs_father.getTabs().remove(tab_person);
        tabs_father.getTabs().remove(tab_dorm);
        tabs_father.getTabs().remove(tab_building);
        tabs_father.getTabs().remove(tab_log);
    }

    private final ObservableList<BeanPerson> dataInDorm = FXCollections.observableArrayList();

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
        table_dorm.setItems(dataInDorm);
        List<Student> students = biz.selectStudentByDorm(student.getBuilding_id(), student.getDorm_id());
        for(Student student : students) {
            BeanPerson beanPerson = new BeanPerson(student.getBuilding_id() + "#" + student.getDorm_id(), student.getBed_id() + "", student.getName(), student.getStudent_id(), student.getBirthday(), student.getContact(), student.getMajor(), student.getClasses(), (student.getStatus() == 1 ? "已签到" : "已签退"));
            dataInDorm.add(beanPerson);
        }
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
    }

    /**
     * note 保存宿舍信息按钮
     * @param actionEvent
     */
    @FXML
    public void but_dormNameSave(ActionEvent actionEvent) {
    }

    /**
     * note 显示楼宇信息tab
     * @param actionEvent
     */
    @FXML
    public void but_building(ActionEvent actionEvent) {
    }

    /**
     * note 显示签到签退tab
     * @param actionEvent
     */
    @FXML
    public void but_signAndOut(ActionEvent actionEvent) {
    }

    /**
     * note 显示缴费tab
     * @param actionEvent
     */
    @FXML
    public void but_saveMoney(ActionEvent actionEvent) {
    }

    /**
     * note 注销账号，返回登录界面
     * @param actionEvent
     */
    @FXML
    public void but_logout(ActionEvent actionEvent) {
    }
}
