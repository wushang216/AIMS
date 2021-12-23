package com.chang.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
    private static Connection  connection;
    private static Statement statement;
    public JDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动加载失败");
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/articlemanager?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String user = "root";
        String password = "123456789";
        try {
            connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("账户或密码错误");
            e.printStackTrace();
        }
    }
    protected Statement getStatement(){
        return statement;
    }
    public static void close(){
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("接口关闭失败");
            e.printStackTrace();
        }
    }
}
