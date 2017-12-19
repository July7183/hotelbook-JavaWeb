package com.july.hb.login.controller;


import com.july.hb.common.ExportExcel;
import com.july.hb.login.pojo.Login;
import com.july.hb.login.service.LoginService;
import com.july.hb.login.service.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginExcelServlet" ,value = "/LoginExcelServlet")
public class LoginExcelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {

        LoginService service = new LoginServiceImpl();

        ArrayList<Login> infoArrayList;
        infoArrayList = service.query(1, service.queryLoginNum());

        String[] headers = {"用户ID", "用户登录名", "用户密码", "用户昵称", "用户权限"};
        String fileName = "用户信息";

        ExportExcel<Login> ee = new ExportExcel<>();
        ee.exportExcel(headers, infoArrayList, fileName, response);
    }
}
