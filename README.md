# 作业分支简介

本分支从**myHomework**分支开出，对应实验二 - JSP+JavaBean。

其余部分代码已删，**故请勿执行合并操作**。


    项目结构：
    hotelbook - JavaWeb             //项目根目录
    |-- .idea                       //IDE配置文件
    |-- lib                         //第三方jar包
    |-- out                         //项目输出目录
    |-- src                         //代码
         |-- com.ink.hb
              |-- common            //公共类
              |-- login             //登录实体类
         |-- resources              //资源文件
              |--markdown           //md图库
         |-- sql                    //sql
         |-- test                   //测试类
    |-- web
         |-- css
         |-- img
         |-- js
         |-- layui                  //layui框架
         |-- WEB-INF
        
## 关于JavaBean

JavaBean本质是实体类，但是在前端界面可以直接调用，把code写进网页体验太差了。

而且jsb上的代码先是在服务器端运行的，所以需要用到判断类的语言又要单独一个jsp页面，然后它本身又可以去网页上显示。 

除此之外，Dao工厂类也恶心的要死，简直是一件事多过一道程序，用工厂类管理DAO不如每一个分到实体类下的文件。

实验三将从本分支与Development衍生出。