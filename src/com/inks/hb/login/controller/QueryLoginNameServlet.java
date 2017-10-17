package inks.hb.login.controller;

import com.google.gson.Gson;
import inks.hb.login.pojo.Login;
import inks.hb.login.service.LoginService;
import inks.hb.login.service.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(value = "/QueryLoginNameServlet", name = "/QueryLoginNameServlet")
public class QueryLoginNameServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 响应输出流
        PrintWriter out = response.getWriter();

        // 调用service
        LoginService service = new LoginServiceImpl();

        // 获得姓名
        String loginName = request.getParameter("loginName");
        String loginPwd = request.getParameter("loginPwd");

        //System.out.printf("\nServlet得到的loginName值为：" + loginName);

        try {

            Login login = service.queryByName(loginName);
            System.out.println(login.toString());

            int check = 0;

            if (login.getLoginAdmin() == -1)
                check = -1;
            else if (login.getLoginPwd().equals(loginPwd))
                check = 1;

            //转换为json字符串格式
            Gson gson = new Gson();

            out.print(gson.toJson(check));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
