package com.july.hb.billInfo.control;

import com.google.gson.Gson;
import com.july.hb.billInfo.pojo.BillInfo;
import com.july.hb.billInfo.service.BillService;
import com.july.hb.billInfo.service.BillServiceImpl;
import com.july.hb.common.PojotoGson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "BillInfoServlet",value = "/BillInfoServlet")
public class BillInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(doMyServlet(request)));
    }

    private PojotoGson doMyServlet(HttpServletRequest request) {

        int page = Integer.parseInt(request.getParameter("page")); //当前页码
        int limit = Integer.parseInt(request.getParameter("limit")); //每页的数据量
        int make = Integer.parseInt(request.getParameter("make")); //状态标志

        // 调用service
        BillService service = new BillServiceImpl();

        // 默认输出信息
        String code = "0"; //状态码
        String msg = "数据查询正常"; //状态信息
        String count = ""; //数据总数
        ArrayList list = new ArrayList<>(); //数据内容
        ArrayList<BillInfo> searchList = new ArrayList<>(); //数据内容

        //单个全局属性
        String billId ="";
        String checkId = "";
        String costMoney;
        String costDate;
        String remark; //备注
        BillInfo billInfo = null;

        //获取对应状态属性
        if (make == 1 || make == 2) { //1和2这部分完全是相同的

            billId=request.getParameter("billId");
            checkId = request.getParameter("checkId");  //2
            costMoney = request.getParameter("costMoney"); //3
            costDate = request.getParameter("costDate");  //4
            remark = request.getParameter("remark"); //18
            billInfo = new BillInfo(billId,checkId, costMoney, costDate, remark);

        } else if (make == 4) {
            checkId = request.getParameter("checkId");
        } else if (make == 3) {
            billId=request.getParameter("billId");
        }

        // 状态标志 make 0重载 1新增 2修改 3搜索 4删除
        switch (make) {
            case 1:
                if (service.insertBillInfo(billInfo) == -1) {
                    msg = "插入异常";
                    code = "-1";
                }
                break;
            case 2:
                if (service.updateBillInfo(billInfo) == -1) {
                    msg = "修改异常";
                    code = "-1";
                }
                break;
            case 3:
                list = service.query(1, service.queryBillNum());
                searchList.clear();
                for (Object temp : list) {
                    billInfo = (BillInfo) temp;
                    if (billInfo.getBillId().contains(billId)) {
                        searchList.add(billInfo);
                    }
                }
                break;
            case 4:
                if (service.deleteBillInfo(billId) == -1) {
                    msg = "删除失败";
                    code = "-1";
                }
                break;
        }

        if (make != 3) {
            list = service.query(page, limit);
            count = String.valueOf(service.queryBillNum());
        } else { //这部分算是对3搜索的特殊处理，放这儿和放case里一样的。
            int size = searchList.size();
            if (size == 0) {
                msg = "查无此项";
                code = "-1";
            } else {
                list = searchList;
                count = Integer.toString(size);
            }
        }

        return new PojotoGson(code, msg, count, list);
    }
}
