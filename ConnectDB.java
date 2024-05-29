/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Duong Duy
 */
public class ConnectDB {

    static Connection con;

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        ConnectDB.con = con;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        Class.forName(driver);
        String databaseName = "QUAN_LY_QUAN_CAFE";
        String url = "jdbc:sqlserver://THANH-NGUYEN221\\SQLEXPRESS:1433;databaseName=" + databaseName;
        con = DriverManager.getConnection(url, "sa", "123");
        return con;
    }

   

    public static void close() {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi nè", "Thông báo", 2);

        }
        return rs;
    }

    public static int executeUpdate(String sql) {
        int i = -1;
        try {

            Statement stm = con.createStatement();
            i = stm.executeUpdate(sql);
        } catch (Exception e) {
        }
        return i;
    }
}
