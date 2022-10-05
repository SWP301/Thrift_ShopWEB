/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DBUtil {
        private String DATABASENAME = "SWPShop";
        private String USER = "sa";
        private String PASSWORD ="123456";
        
    public Connection getConnection() throws Exception{
        
        String url = "jdbc:sqlserver://localhost;databaseName="+DATABASENAME+";user="+USER+";password="+PASSWORD;
        Connection con = null;
        //Loading a driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //Creating a connection
        con = DriverManager.getConnection(url);
        return con;
    }
}
