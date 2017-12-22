package com.july.hb.checkin.dao;

import com.july.hb.checkin.pojo.CheckinInfo;
import com.july.hb.common.CommonDao;
import com.july.hb.common.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckinDao implements CommonDao {

    @Override
    public void insertData(Object o) throws SQLException {
        CheckinInfo checkinInfo = (CheckinInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "INSERT INTO checkininfo () VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, checkinInfo.getCheckId());
        pstmt.setString(2, ""); //在不改变数据库结构的情况下直接赋空值，以下同理
        pstmt.setString(3, checkinInfo.getCheckName());
        pstmt.setString(4, checkinInfo.getCheckPhone());
        pstmt.setString(5, checkinInfo.getCheckIDcard());
        pstmt.setString(6, checkinInfo.getTypeId());
        pstmt.setString(7, checkinInfo.getArriveTime());
        pstmt.setString(8, checkinInfo.getLeaveTime());
        pstmt.setString(9, checkinInfo.getCheckState());
        pstmt.setInt(10, Integer.parseInt(checkinInfo.getCheckNum()));
        pstmt.setString(11, checkinInfo.getRoomId());
        pstmt.setString(12, checkinInfo.getPrice());
        pstmt.setString(13, checkinInfo.getCheckPrice());
        pstmt.setInt(14, Integer.parseInt(checkinInfo.getDiscount()));
        pstmt.setString(15, "");
        pstmt.setString(16, "");
        pstmt.setString(17, "");
        pstmt.setString(18, checkinInfo.getOrderMoney());
        pstmt.setString(19, checkinInfo.getMoney());
        pstmt.setString(20, "");
        pstmt.setString(21, checkinInfo.getCheckMoney());
        pstmt.setString(22, checkinInfo.getCheckoutDate());
        pstmt.setString(23, checkinInfo.getRemark());
        pstmt.setString(24, "");

        pstmt.executeUpdate();

        pstmt.close();
    }

    @Override
    public void deleteData(Object o) throws SQLException {
        CheckinInfo checkinInfo = (CheckinInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "DELETE FROM checkininfo WHERE checkId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, checkinInfo.getCheckId());

        pstmt.executeUpdate();

        pstmt.close();
    }

    @Override
    public void updateData(Object o) throws SQLException {
        CheckinInfo checkinInfo = (CheckinInfo) o;
        Connection conn = DBUtil.getConnection();

        String sql = "UPDATE checkininfo SET orderId = ? ,checkName = ? ,checkPhone = ? ,checkIDcard = ?," +
                "typeId = ?,arrireTime = ?,leaveTime = ? ,checkState = ? ,checkNum = ? , roomId = ?,price = ? ," +
                "checkPrice = ?,discount = ? ,discountReason = ?,addBed = ? ,addBedPrice = ?,orderMoney = ? ," +
                "money = ?,isCheck = ?,checkMoney = ? ,checkDate = ? ,remark = ?,operatorId = ? " +
                " WHERE checkId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, "");
        pstmt.setString(2, checkinInfo.getCheckName());
        pstmt.setString(3, checkinInfo.getCheckPhone());
        pstmt.setString(4, checkinInfo.getCheckIDcard());
        pstmt.setString(5, checkinInfo.getTypeId());
        pstmt.setString(6, checkinInfo.getArriveTime());
        pstmt.setString(7, checkinInfo.getLeaveTime());
        pstmt.setString(8, checkinInfo.getCheckState());
        pstmt.setInt(9, Integer.parseInt(checkinInfo.getCheckNum()));
        pstmt.setString(10, checkinInfo.getRoomId());
        pstmt.setString(11, checkinInfo.getPrice());
        pstmt.setString(12, checkinInfo.getCheckPrice());
        pstmt.setInt(13, Integer.parseInt(checkinInfo.getDiscount()));
        pstmt.setString(14, "");
        pstmt.setString(15, "");
        pstmt.setString(16, "");
        pstmt.setString(17, checkinInfo.getOrderMoney());
        pstmt.setString(18, checkinInfo.getMoney());
        pstmt.setString(19, checkinInfo.getIsCheck());
        pstmt.setString(20, checkinInfo.getCheckMoney());
        pstmt.setString(21, checkinInfo.getCheckoutDate());
        pstmt.setString(22, checkinInfo.getRemark());
        pstmt.setString(23, "");
        pstmt.setString(24, checkinInfo.getCheckId());

        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public int queryDataNum() throws SQLException {
        Connection conn = DBUtil.getConnection();

        String sql = "select count(*) from checkininfo;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        int num;
        if (rs.next()) num = rs.getInt("count(*)");
        else num = 0;

        rs.close();
        pstmt.close();

        return num;
    }

    @Override
    public ArrayList query(int start, int length) throws SQLException {
        Connection conn = DBUtil.getConnection();

        String sql = "select * from checkininfo limit ?, ?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, start - 1);
        pstmt.setInt(2, length);
        ResultSet rs = pstmt.executeQuery();

        ArrayList<CheckinInfo> list = new ArrayList<>();
        CheckinInfo checkinInfo;

        while (rs.next()) {
            checkinInfo = new CheckinInfo(rs.getString(1), rs.getString(3), rs.getString(4)
                    , rs.getString(5), rs.getString(7), rs.getString(8)
                    , Integer.toString(rs.getInt(10)), "", rs.getString(6), rs.getString(11)
                    , rs.getString(12), rs.getString(13), Integer.toString(rs.getInt(14))
                    , rs.getString(18), rs.getString(19), rs.getString(9), rs.getString(20)
                    , rs.getString(21), rs.getString(22), rs.getString(23));
            if (checkinInfo.getDiscount().equals("0"))
                checkinInfo.setDiscount("10");
            list.add(checkinInfo);
        }

        rs.close();
        pstmt.close();

        return list;
    }

    @Override
    public Object query(Object o) throws SQLException {
        CheckinInfo checkinInfoQuery = (CheckinInfo) o;

        Connection conn = DBUtil.getConnection();

        String sql = "SELECT * FROM checkininfo WHERE checkId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, checkinInfoQuery.getCheckId());
        ResultSet rs = pstmt.executeQuery();

        CheckinInfo checkinInfo = null;
        while (rs.next()) {
            checkinInfo = new CheckinInfo(rs.getString(1), rs.getString(3), rs.getString(4)
                    , rs.getString(5), rs.getString(7), rs.getString(8)
                    , Integer.toString(rs.getInt(10)), "", rs.getString(6), rs.getString(11)
                    , rs.getString(12), rs.getString(13), Integer.toString(rs.getInt(14))
                    , rs.getString(18), rs.getString(19), rs.getString(9), rs.getString(20)
                    , rs.getString(21), rs.getString(22), rs.getString(23));
        }
        if (checkinInfo == null) {
            checkinInfo = new CheckinInfo();
            checkinInfo.setNull(true);
        } else if (checkinInfo != null){
            if (checkinInfo.getDiscount().equals("0"))
                checkinInfoQuery.setDiscount("10");
        }
        rs.close();
        pstmt.close();

        return checkinInfo;
    }

    public CheckinInfo queryName(String checkName) throws SQLException {

        Connection conn = DBUtil.getConnection();

        String sql = "SELECT * FROM checkininfo WHERE checkId = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, checkName);
        ResultSet rs = pstmt.executeQuery();

        CheckinInfo checkinInfoQuery = null;
        while (rs.next()) {
            checkinInfoQuery = new CheckinInfo(rs.getString(1), rs.getString(3), rs.getString(4)
                    , rs.getString(5), rs.getString(7), rs.getString(8)
                    , Integer.toString(rs.getInt(10)), "", rs.getString(6), rs.getString(11)
                    , rs.getString(12), rs.getString(13), Integer.toString(rs.getInt(14))
                    , rs.getString(18), rs.getString(19), rs.getString(9), rs.getString(20)
                    , rs.getString(21), rs.getString(22), rs.getString(23));
        }

        if (checkinInfoQuery == null) {
            checkinInfoQuery = new CheckinInfo();
            checkinInfoQuery.setNull(true);
        } else {
            if (checkinInfoQuery.getDiscount().equals("0"))
                checkinInfoQuery.setDiscount("10");
        }

        rs.close();
        pstmt.close();

        return checkinInfoQuery;

    }
}
