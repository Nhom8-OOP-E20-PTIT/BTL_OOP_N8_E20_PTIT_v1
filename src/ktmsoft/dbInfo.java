/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ktmsoft;

/**
 *
 * @author nguye
 */
import java.io.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbInfo {
    public static String USERNAME = "";
    public static String USER_PASSWORD = "";
//    private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=SinhVien;" + "integratedSecurity=false;" + "encrypt=true;" + "trustServerCertificate=true";
//    private static String USER_NAME = "sa";
//    private static String PASSWORD = "123";
    private static String DB_NAME = "";
    private static String DB_URL = "";
    private static String USER_NAME = "ktm";
    private static String PASSWORD = "123456@abc";
    public static void dbexec(String cmd){
        try{
            Connection ketnoi = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = ketnoi.createStatement();
            stmt.execute(cmd);
            ketnoi.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static String getDbname(){
        return DB_NAME;
    }
    public static void setDbname(String dbname){
        DB_NAME = dbname;
    }
    public static void setDburl(String dbname){
        DB_URL = "jdbc:mysql://192.168.220.40:3306/" + dbname;
    }
    public static String getPassword(){
        return USER_PASSWORD;
    }
    public static void setPassword(String password){
        USER_PASSWORD = password;
    }
    public static String getUsername(){
        return USERNAME;
    }
    public static void setUsername(String userName){
        USERNAME = userName;
    }
    public static ResultSet dbquery(String cmd){
        ResultSet out;
        try{
            Connection ketnoi = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = ketnoi.createStatement();
            out = stmt.executeQuery(cmd);
            // ketnoi.close();
            return out;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return out;
    }
//    public static void main(String[] args) throws SQLException {
//        setDbname("user");
//        setDburl();
//        System.out.println(DB_URL);
//        String cmd = "SELECT * FROM userinfo";
//        ResultSet rs = dbquery(cmd);
//        while(rs.next()){
//            System.out.println(rs.getString("id"));
//        }
//    }
}
