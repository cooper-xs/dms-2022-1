### 概述

- `apartment.sql`文件放的是SQL语句，可以放在navicat里面新建查询==直接运行==，完成自动建表和填充任务。

- src/main/java/db.properties`文件放的是数据库连接语句，可根据自己的实际情况==修改连接语句==

- `- src/main/java/module-info.java`是基于`jdk1.8以上`版本特有的配置文件，设置了一些包的依赖和导出

- `src/main/resources`下是`fxml`文件和`img`文件

- `src/main/java/com/dms`下是主要`java`文件，其下面：
  - Controller：fxml的控制类文件
  - Dao：数据访问层
  - DMSUtil：常用函数
  - Ex：自定义异常
  - Po：实体类，与数据库中的表一致
  - Service：持久层
  - View：UI界面，其中==MainApplication是程序入口==



### 出现的问题与解决方案

#### JUnit报错
源于jdk1.8+版本问题，主要是module-info.java文件功能说明

#### 文件引用路径报错
1.java文件中的几种引用方式 2.fxml中引用文件的方式 3.别的注意事项

#### idea中自定义注释
idea中自定义注释，通过正则实现

#### 一个javafx项目的结构，理解运行机制

#### classpath源文件学习

