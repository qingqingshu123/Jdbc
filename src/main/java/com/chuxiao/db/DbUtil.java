package com.chuxiao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by jixiaoqiang on 2017/7/5.
 */
public class DbUtil {
    private final static String url = "jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&characterEncoding=utf8";
    private final static String user = "root";
    private final static String pass = "910214";

    public static Connection connection = null;

    static {
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
