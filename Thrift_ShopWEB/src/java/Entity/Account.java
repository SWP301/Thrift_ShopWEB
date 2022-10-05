/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author htmlo
 */
public class Account {
    private int accountID;
    private String userName; // tên đăng nhập
    private String password; // mật khẩu
    private int status; // tình trạng tài khoản 
    private String phone;// sđt
    private String address;//địa chỉ hoặc địa chỉ giao hàng
    private int roleID;

    public Account() {
        this.accountID = accountID;
        this.userName = "";
        this.password = "";
        this.status = 1;
        this.phone = "";
        this.address = "";
        this.roleID = 2;
    }

    public Account(int accountID, String userName, String password, int status, String phone, String address, int roleID) {
        this.accountID = accountID;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.phone = phone;
        this.address = address;
        this.roleID = roleID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", userName=" + userName + ", password=" + password + ", status=" + status + ", phone=" + phone + ", address=" + address + ", roleID=" + roleID + '}';
    }
    
    
}
