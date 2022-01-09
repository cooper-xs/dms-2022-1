package com.dms.View;

import com.dms.Service.Implementation.BizImpl;
import com.dms.Service.Interfaces.Biz;
import com.dms.Dao.Implementation.RegisterDaoImpl;
import com.dms.Dao.Interfaces.RegisterDao;
import com.dms.Ex.*;
import com.dms.Po.Building;
import com.dms.Po.Dorm;
import com.dms.Po.Manager;
import com.dms.Po.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Biz biz = new BizImpl();
    public static RegisterDao registerDao = new RegisterDaoImpl();
    public static Scanner re = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner rea = new Scanner(System.in);

        while (true) {
            if(!mainTable()) break;
        }
        System.out.println("goodbye!");
        rea.close();
    }
    // x1 主界面
    public static boolean mainTable() {
        System.out.println("-- Welcome --");
        System.out.print("\n请输入账号(输入0退出)：");
        String account = re.next();
        if(account.equals("0")) return false;
        System.out.print("请输入密码：");
        String password = re.next();
        int res = 0;
        try {
            res = biz.Login(account, password);
        } catch (NoSuchAccountException e) {
            System.out.println("用户" + account + "不存在");
        } catch (PasswordWrongException e) {
            System.out.println("密码错误");
        } catch (PasswordInputEmptyException e) {
            System.out.println("请输入密码");
        } catch (AccountInputEmptyException e) {
            System.out.println("请输入账号");
        }
        if(res == 0) {
            System.out.println("登录失败");
        } else if(res == 1) {
            System.out.println("登录为：学生");
            studentTable(account);
        } else if(res == 2) {
            System.out.println("登录为：宿舍管理员");
            managerTable(account);
        } else if(res == 3) {
            System.out.println("登录为：超级管理员");
            System.out.println("暂未开放...");
        }
        return true;
    }

    // x2 学生界面
    public static void studentTable(String student_id) {
        while (true) {
            Student student = biz.selectStudentById(student_id);
            System.out.println("\n欢迎同学：" + student.getName());
            int status = student.getStatus();
            System.out.println("\n1 - 查看\\修改个人信息\n2 - 查看\\修改所在宿舍信息\n3 - 查看所在楼宇信息\n4 - " + (status == 0 ? "签到" : "签退") + "\n5 - 宿舍缴费\n6 - 注销账户");
            System.out.print("请选择：");
            int op = re.nextInt();
            if(op == 1) {
                try {
                    biz.studentShowOnAll(student);
                } catch (NoSuchAccountException e) {
                    System.out.println("账户不存在");
                }
                System.out.println("\n1 - 修改信息\n2 - 返回学生界面");
                System.out.print("请选择：");
                int op1 = re.nextInt();
                if(op1 == 1) {
                    System.out.println("功能暂未开放");
                    System.out.println("（在多条文本框中展示全部信息，修改保存即可更新信息）");
                } else if(op1 == 2) {
                    System.out.println("返回上一界面");
                } else {
                    System.out.print("输入错误, 即将返回学生界面");
                }
            } else if(op == 2) {
                try {
                    biz.selectDormByBuilding_idAndDorm_id(student.getBuilding_id(), student.getDorm_id());
                } catch (NoSuchAccountException e) {
                    System.out.println("账户不存在");
                }
                System.out.println("\n1 - 修改信息\n2 - 返回学生界面");
                System.out.print("请选择：");
                int op1 = re.nextInt();
                if(op1 == 1) {
                    System.out.println("功能暂未开放");
                    System.out.println("（在多条文本框中展示全部信息，修改保存即可更新信息）");
                } else if(op1 == 2) {
                    System.out.println("返回上一界面");
                } else {
                    System.out.print("输入错误, 即将返回学生界面");
                }
            } else if(op == 3) {
                try {
                    Building building = biz.selectBuildingByBuilding_id(student.getBuilding_id());
                    System.out.println(building);
                    Enter();
                } catch (NoSuchAccountException e) {
                    System.out.println("楼宇不存在");
                } catch (IOException e) {
                    System.out.println("输入异常");
                }
            } else if(op == 4) {
                if(status == 0) {
                    System.out.println(biz.signIn(student.getStudent_id()) ?"签到成功！" : "签到失败！");
                } else {
                    System.out.println(biz.signOut(student.getStudent_id()) ?"签退成功！" : "签退失败！");
                }
            } else if(op == 5) {
                boolean result = false;
                System.out.println("请输入缴费金额");
                double value = re.nextDouble();
                try {
                    result = biz.saveMoney(student.getStudent_id(), student.getBuilding_id(), student.getDorm_id(), value);
                } catch (InputValueException e) {
                    System.out.println("缴费金额异常");
                }
                System.out.println(result ? "缴费成功" : "缴费失败");
            } else if(op == 6) {
                break;
            } else {
                System.out.print("输入错误, 即将返回学生界面");
            }
        }
    }

    // x3 管理员界面
    public static void managerTable(String manager_id) {
        while (true) {
//            Student student = biz.selectById(student_id);
            Manager manager = biz.selectManagerById(manager_id);
            System.out.println("\n欢迎宿管：" + manager.getName());
            System.out.println("\n1 - 查看\\修改个人信息\n2 - 查看\\修改所管理宿舍信息\n3 - 查看所管理楼宇信息\n4 - 宿舍缴费\n5 - 查看日志\n6 - 注销账户");
            System.out.print("请选择：");
            int op = re.nextInt();
            if(op == 1) {
                biz.managerShowOnAll(manager);
                System.out.println("\n1 - 修改信息\n2 - 返回宿管界面");
                System.out.print("请选择：");
                int op1 = re.nextInt();
                if(op1 == 1) {
                    System.out.println("功能暂未开放");
                    System.out.println("（在多条文本框中展示全部信息，修改保存即可更新信息）");
                } else if(op1 == 2) {
                    System.out.println("返回上一界面");
                } else {
                    System.out.print("输入错误, 即将返回学生界面");
                }
            } else if(op == 2) {
                List<Building> buildingList = biz.selectBuildingsByManager_id(manager_id);
                System.out.println(buildingList);
                System.out.println("\n1 - 修改信息\n2 - 返回宿管界面");
                System.out.print("请选择：");
                int op1 = re.nextInt();
                if(op1 == 1) {
                    System.out.println("功能暂未开放");
                    System.out.println("（在多条文本框中展示全部信息，修改保存即可更新信息）");
                } else if(op1 == 2) {
                    System.out.println("返回上一界面");
                } else {
                    System.out.print("输入错误, 即将返回学生界面");
                }
            } else if(op == 3) {
                List<Building> buildingList = biz.selectBuildingsByManager_id(manager_id);
                List<Dorm> dormList = biz.selectDormsByBuilding_id(buildingList);
                System.out.println(dormList);
                System.out.println("\n1 - 修改信息\n2 - 返回宿管界面");
                System.out.print("请选择：");
                int op1 = re.nextInt();
                if(op1 == 1) {
                    System.out.println("功能暂未开放");
                    System.out.println("（在多条文本框中展示全部信息，修改保存即可更新信息）");
                } else if(op1 == 2) {
                    System.out.println("返回上一界面");
                } else {
                    System.out.print("输入错误, 即将返回学生界面");
                }
            } else if(op == 4) {
                System.out.print("请输入缴费完整宿舍号（如11#518）：");
                String buildingAndDorm_id = re.next();
                int idx = buildingAndDorm_id.indexOf('#');
                String building_id = buildingAndDorm_id.substring(0, idx);
                String dorm_id = buildingAndDorm_id.substring(idx + 1);
                System.out.println("请确认：" + building_id + "#" + dorm_id);
                boolean result = false;
                System.out.println("请输入缴费金额");
                double value = re.nextDouble();
                try {
                    result = biz.saveMoney(manager_id, building_id, dorm_id, value);
                } catch (InputValueException e) {
                    System.out.println("缴费金额异常");
                }
                System.out.println(result ? "缴费成功" : "缴费失败");
            } else if(op == 5) {
                System.out.println(biz.selectAllLog());
                try {
                    Enter();
                } catch (IOException e) {
                    System.out.println("输入异常");
                }
            } else if(op == 6) {
                break;
            } else {
                System.out.print("输入错误, 即将返回宿管界面");
            }
        }
    }

    public static void Enter() throws IOException {
        System.out.println("回车以继续");
        new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
}
