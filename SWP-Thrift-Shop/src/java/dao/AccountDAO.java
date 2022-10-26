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
import models.UserDTO;
import models.Wallet;

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
    private static final String List_ALL_ACCOUNT = "SELECT * "
            + "FROM Account join Role on [Account].RoleID = [Role].ID ORDER BY Account.userName DESC";
    private static final String CHECK_LOGIN = "SELECT Account.Id,UserName, FullName,Password, Status,Phone ,Address, RoleID \n"
                                     + "WHERE UserName=? AND Password=?";

    private static final String LOGIN = "SELECT Account.Id, FullName, Email,Phone, Address, RoleName "
            + "FROM Account join Role on [Account].RoleID = [Role].ID WHERE UserName = ? AND Password = ? AND Status= 1";
    private static final String CHECK_USERNAME = "SELECT UserName "
            + "FROM Account WHERE UserName = ?";  
    private static final String INSERT = "INSERT INTO Account(UserName, FullName, Email,Password, Status, Phone, Address, RoleID) \n" +
                                        "VALUES(?,?,?,?,?,?,?,?)";
    private static final String CHANGE_PASSWORD = "UPDATE Account "
            + "SET password=? WHERE userName=?";
    private static final String UPDATE_ACCOUNT = "UPDATE Account "
            + "SET fullName=?,email=?, phone=?,address=? WHERE userName=?";
    private static final String CHECK_PASSWORD = "SELECT Password "
            + "FROM Account WHERE UserName = ? AND Password = ?";
    private static final String CHECK_EMAIL = " Account.Id, UserName,FullName, Email, Password, Phone, Address, RoleName\n" +
                                            "FROM Account join Role on [Account].RoleID = [Role].ID WHERE Email = ?";
    private static final String CHECK_WALLET  = "SELECT UserID FROM Wallet Where UserID = ?";
    private static final String CREATE_WALLET  = "INSERT INTO  Wallet(Amount, UserID) VALUES (0,?)";
    private static final String ADD_MONEY = "UPDATE Wallet SET Amount = Amount + ? WHERE UserID = ?";
    private static final String TAKE_AMOUNT = "SELECT ID, Amount FROM Wallet WHERE UserID = ?";
    
    public List<UserDTO> listAll() {
        List<UserDTO> list = null;
        DBUtil db = new DBUtil();
        try {
            list = new ArrayList<>();
            Connection con = db.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(List_ALL_ACCOUNT);
            while (rs.next()) {
                String accountId = rs.getString(1);
                String username = rs.getString(2);
                String fullname = rs.getString(3);
                String email = rs.getString(4);
                String pass = rs.getString(5);
                boolean status = rs.getBoolean(6);
                String phone = rs.getString(7);
                String address= rs.getString(8);
                String role = rs.getString("RoleName");
                UserDTO act = new UserDTO(accountId, username,
                        fullname,email, pass,status,phone ,address ,role);
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
     
    public UserDTO checkLoginV2 (String username, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if(conn != null) {
                pst = conn.prepareStatement(LOGIN);
                pst.setString(1, username);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if(rs.next()) {
                   String id = rs.getString("Id");
                   String fullName = rs.getString("FullName");
                   String email = rs.getString("Email");
                   String phone = rs.getString("Phone");
                   String address = rs.getString("Address");
                   String roleName = rs.getString("RoleName");
                   user = new UserDTO(id, username, fullName, email,password, true, phone, address, roleName);
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if(conn != null) {
                conn.close();
            }
        }
        return user;
    }
    
    public boolean insert (UserDTO user) throws ClassNotFoundException, SQLException, Exception {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(INSERT);
                psm.setString(1, user.getUserName());
                psm.setString(2, user.getFullName());
                psm.setString(3, user.getEmail());
                psm.setString(4, user.getPassword());
                psm.setBoolean(5, true);
                psm.setString(6, user.getPhone());
                psm.setString(7, user.getAddress());
                psm.setInt(8, 2);
                check = psm.executeUpdate() > 0 ? true : false;
            }
        } finally {
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean checkUserName(String userName) throws SQLException {
//        UserDTO user = null;
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(CHECK_USERNAME);
                pst.setString(1, userName);
                rs = pst.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return check;
    }
    
    public boolean update(UserDTO user) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(UPDATE_ACCOUNT);
                psm.setString(1, user.getFullName());
                psm.setString(2, user.getEmail());
                psm.setString(3, user.getPhone());
                psm.setString(4, user.getAddress());
                psm.setString(5, user.getUserName());
                check = psm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean changePassword(String password, String userName) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(CHANGE_PASSWORD);
                psm.setString(1, password);
                psm.setString(2, userName);
                check = psm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean checkPassword(String userName, String password) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(CHECK_PASSWORD);
                pst.setString(1, userName);
                pst.setString(2, password);
                rs = pst.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return check;
    }
    
    public UserDTO checkEmail (String email) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if(conn != null) {
                pst = conn.prepareStatement(CHECK_EMAIL);
                pst.setString(1, email);
                rs = pst.executeQuery();
                if(rs.next()) {
                   String id = rs.getString("Id");
                   String username = rs.getString("UserName");
                   String fullName = rs.getString("FullName");
                   String password = rs.getString("Password");
                   String phone = rs.getString("Phone");
                   String address = rs.getString("Address");
                   String roleName = rs.getString("RoleName");
                   user = new UserDTO(id, username, fullName, email, password, true, phone, address, roleName);
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if(conn != null) {
                conn.close();
            }
        }
        return user;
    }
    
    public boolean CheckWallet(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                pst = conn.prepareStatement(CHECK_WALLET);
                pst.setString(1, userID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return check;
    }
    
    public boolean CreateWallet(String UserID) throws Exception {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(CREATE_WALLET);
                psm.setString(1, UserID);
                check = psm.executeUpdate() > 0 ? true : false;
            }
        } finally {
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean AddMoney (String amount, String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(ADD_MONEY);
                psm.setString(1, amount);
                psm.setString(2, userID);
                check = psm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
        
    }
    
    public Wallet TakeAmount (String userID) throws SQLException {
        Wallet wallet = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();
        try {
            conn = db.getConnection();
            if(conn != null) {
                pst = conn.prepareStatement(TAKE_AMOUNT);
                pst.setString(1, userID);
                rs = pst.executeQuery();
                if(rs.next()) {
                    int ID = rs.getInt("ID");
                    float amount = rs.getFloat("Amount");
                    wallet = new Wallet(ID, amount, userID);    
                }
           }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if(conn != null) {
                conn.close();
            }
        }
        
        return wallet;
    }
    
}
