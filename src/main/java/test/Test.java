package test;


import java.sql.*;

/**
 * Created by jixiaoqiang on 2017/7/5.
 */
public class Test {
    private final static String url ="jdbc:mysql://127.0.0.1:3306/imooc";
    private final static String user = "root";
    private final static String pass ="910214";

    public static void main(String[] args)  {
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            Connection connection= DriverManager.getConnection(url, user, pass);
            //创建Statement对象
            Statement statement = connection.createStatement();
            //执行语句得到结果
            String sql = "SELECT * FROM imooc_goddess";
            ResultSet rs = statement.executeQuery(sql);
            //处理结果
            while(rs.next()){
                System.out.println(rs.getString("user_name"));//操作的是查询结果中的列名 别名  用了别名原有的就不能用了
               // System.out.println(rs.getString("cust_id"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
