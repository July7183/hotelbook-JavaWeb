package com.july.hb.checkin.control;

import com.google.gson.Gson;
import com.july.hb.checkin.pojo.CheckinInfo;
import com.july.hb.checkin.service.CheckinService;
import com.july.hb.checkin.service.CheckinServiceImpl;
import com.july.hb.common.PojotoGson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CheckinServlet",value = "/CheckinServlet")
public class CheckinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Gson gson = new Gson();
        out.print(gson.toJson(doMyServlet(request)));
    }

    private PojotoGson doMyServlet(HttpServletRequest request) {

        int page = Integer.parseInt(request.getParameter("page")); //当前页码
        int limit = Integer.parseInt(request.getParameter("limit")); //每页的数据量
        int make = Integer.parseInt(request.getParameter("make")); //状态标志

        // 调用service
        CheckinService service = new CheckinServiceImpl();

        // 默认输出信息
        String code = "0"; //状态码
        String msg = "数据查询正常"; //状态信息
        String count = ""; //数据总数
        ArrayList list = new ArrayList<>(); //数据内容
        ArrayList<CheckinInfo> searchList = new ArrayList<>(); //数据内容

        //单个全局属性
          String checkId = ""; //入住单号
          String checkName=""; //入住人
          String checkPhone; //入住人电话
          String checkIDcard; //身份证
          String arriveTime; //抵店时间
          String leaveTime; //离店时间
          int checkNum; //入住人数
          String floorId; //楼层类型
          String typeId; //房间类型
          String roomId; //房号
          String price; //客房价格
          String checkPrice; //入住价格
          int discount; //折扣
          String orderMoney; //预收款
          String money; //应收款
          String checkState; //单据状态
          String isCheck; //是否结账
          String checkMoney; //结张金额
          String checkoutDate; //结账日期
          String remark; //备注
         CheckinInfo checkinInfo = null;

        //获取对应状态属性
        if (make == 1 || make == 2) { //1和2这部分完全是相同的

              checkId = request.getParameter("checkId");  //1
              checkName = request.getParameter("checkName");  //2
              checkPhone = request.getParameter("checkPhone"); //3
              checkIDcard = request.getParameter("checkIDcard");  //4
              arriveTime = request.getParameter("arriveTime"); //5
              leaveTime = request.getParameter("leaveTime"); //6
              checkNum=Integer.valueOf("checkNum");
              typeId = request.getParameter("typeId"); //8
              floorId = request.getParameter("floorId"); //7
              roomId = request.getParameter("roomId"); //9
              price = request.getParameter("price"); //10
              checkPrice = request.getParameter("checkPrice"); //11
              discount=Integer.valueOf("discount");
              orderMoney = request.getParameter("orderMoney"); //12
              money = request.getParameter("money"); //13
              checkState = request.getParameter("checkState"); //14
              isCheck = request.getParameter("isCheck"); //15
              checkMoney = request.getParameter("checkMoney"); //16
              checkoutDate = request.getParameter("checkoutDate"); //17
              remark = request.getParameter("remark"); //18
            checkinInfo = new CheckinInfo(checkId, checkName, checkPhone, checkIDcard, arriveTime, leaveTime,checkNum,typeId,floorId,roomId, price,checkPrice,discount, orderMoney,money, checkState, isCheck, checkMoney, checkoutDate, remark);

        } else if (make == 4) {
             checkId = request.getParameter("checkId");
        } else if (make == 3) {
             checkName = request.getParameter("checkName");
        }

        // 状态标志 make 0重载 1新增 2修改 3搜索 4删除
        switch (make) {
            case 1:
                if (service.insertCheckinInfo(checkinInfo) == -1) {
                    msg = "插入异常";
                    code = "-1";
                }
                break;
            case 2:
                if (service.updateCheckinInfo(checkinInfo) == -1) {
                    msg = "修改异常";
                    code = "-1";
                }
                break;
            case 3:
                list = service.query(1, service.queryCheckinNum());
                searchList.clear();
                for (Object temp : list) {
                    checkinInfo = (CheckinInfo) temp;
                    if (checkinInfo.getCheckName().contains(checkName)) {
                        searchList.add(checkinInfo);
                    }
                }
                break;
            case 4:
                if (service.deleteCheckinInfo(checkId) == -1) {
                    msg = "删除失败";
                    code = "-1";
                }
                break;
        }

        if (make != 3) {
            list = service.query(page, limit);
            count = String.valueOf(service.queryCheckinNum());
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
