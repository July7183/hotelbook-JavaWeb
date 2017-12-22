package com.july.hb.login.controller;

import com.google.gson.Gson;
import com.july.hb.common.MD5;
import com.july.hb.login.pojo.Login;
import com.july.hb.login.service.LoginService;
import com.july.hb.login.service.LoginServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * 此servlet是登录界面使用的，根据用户登录名和用户密码进行登录判断。
 * 如果登录结果判断成功就在session中写入当前的登录名值
 * 通过ajax返回给判断的结果。
 */
@WebServlet(value = "/QueryLoginNameServlet", name = "QueryLoginNameServlet")
public class QueryLoginNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 调用service
        LoginService service = new LoginServiceImpl();



        // 对于此功能，就直接从session中取值
        HttpSession session = request.getSession();
        String loginName = (String) session.getAttribute("LoginName");

        try {
            Login login = service.queryLogin(loginName);
            Gson gson = new Gson();
            out.print(gson.toJson(login));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
