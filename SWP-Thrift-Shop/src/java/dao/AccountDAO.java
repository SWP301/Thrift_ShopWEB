/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Account;
import models.Role;

import utils.DBUtil;

/**
 *
 * @author htmlo
 */
public class AccountDAO {
    
    private static final String SEARCH = "SELECT userID, fullName, roleID "
                                            + "FROM tblUsers WHERE fullName like ?";
    private static final String DELETE = "UPDATE Account SET Status=False "
                                            + "WHERE Id=?";
    private static final String UPDATE = "UPDATE Account SET UserName=?,FullName=?,Password=?,Phone=?, Address=? "
            + "                         WHERE Id=?";
    private static final String CHECK_DUPLICATE =  "SELECT UserName, roleID "
                                            + "FROM Account WHERE Id=?";
    private static final String List_ALL_ACCOUNT = "SELECT * \n"
                                     + "FROM Account ORDER BY Account.userName DESC";
    private static final String CHECK_LOGIN = "SELECT Account.Id,UserName, FullName,Password, Status,Phone ,Address, RoleID \n"
                                     + "WHERE UserName=? AND Password=?";
    
    public List<Account> listAll() {
        List<Account> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(List_ALL_ACCOUNT);
            while (rs.next()) {
                int accountId = rs.getInt(1);
                String username = rs.getString(2);
                String fullname = rs.getString(3);
                String pass = rs.getString(4);
                boolean status = rs.getBoolean(5);
                String phone = rs.getString(6);
                String address= rs.getString(7);
                int role = rs.getInt(8);
                Account act = new Account(accountId, username,
                        fullname, pass,status,phone,address,role);
                list.add(act);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean deleteAccount(String userID) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();            
            if(conn!=null){
                ptm=conn.prepareStatement(DELETE);
                ptm.setString(1, userID);
                check = ptm.executeUpdate()>0? true: false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(ptm!=null) ptm.close();
            if(conn !=null) conn.close();
        }        
        return check;
    }
    
    public boolean updateAccount(Account act) throws SQLException{
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(UPDATE);
                ptm.setString(1, act.getUserName());
                ptm.setString(2, act.getFullName());
                ptm.setString(3, act.getPassword());
                ptm.setString(4, act.getPhone());
                ptm.setString(5, act.getAddress());
                
                check = ptm.executeUpdate()>0? true: false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(ptm!=null) ptm.close();
            if(conn !=null) conn.close();
        }
        return check;
    }
    
     public boolean checkDuplicate(String userID) throws SQLException {
        boolean check = false;
        Connection conn =null;
        PreparedStatement ptm=null;
        ResultSet rs=null;
        DBUtil db = new DBUtil();
        try {
            conn= db.getConnection();
            if(conn!=null){
                ptm=conn.prepareCall(CHECK_DUPLICATE);
                ptm.setString(1, userID);
                rs=ptm.executeQuery();
                if(rs.next()){
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return check;
    }
     
     public Account checkLogin(String userName, String password) throws SQLException {
        Account act = null;
        Connection conn =null;
        PreparedStatement ptm=null;
        ResultSet rs=null;
        DBUtil db = new DBUtil();
        try {
            conn= db.getConnection();
            if(conn!=null){
                ptm=conn.prepareCall(CHECK_LOGIN);
                ptm.setString(1, userName);
                ptm.setString(2, password);
                rs=ptm.executeQuery();
                if(rs.next()){
                    int accountId = rs.getInt("Id");
                    String fullName = rs.getString("FullName");
                    boolean status = rs.getBoolean("Status");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    int role = rs.getInt("RoleID");
                    act = new Account(accountId, userName, fullName,password,status,phone,address,role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return act;
    }
}
