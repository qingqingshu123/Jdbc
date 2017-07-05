package com.chuxiao.dao;

import com.chuxiao.db.DbUtil;
import com.chuxiao.model.Goddess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jixiaoqiang on 2017/7/5.
 */
public class GoddessDao {

    public void addGoddess(Goddess goddess) throws SQLException {
        Connection conn = DbUtil.getConnection();
        //sql语句不要加分号
        String sql = "insert into imooc_goddess "
                     +"(user_name,sex,age,birthday,email,mobile,create_user,create_date,update_user,update_date,isdel) "
                     +" values(?,?,?,?,?,?,?,CURRENT_TIMESTAMP,?,CURRENT_TIMESTAMP,?)";
        //conn.prepareStatement(sql)加载sql语句但并不执行
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,goddess.getUserName());//替代第一个问号
        preparedStatement.setInt(2, goddess.getSex());//替代第一个问号
        preparedStatement.setInt(3, goddess.getAge());//替代第一个问号
        preparedStatement.setDate(4, goddess.getBirthday());//替代第一个问号
        preparedStatement.setString(5,goddess.getEmail());//替代第一个问号
        preparedStatement.setString(6,goddess.getMobile());//替代第一个问号
        preparedStatement.setString(7,goddess.getCreateUser());//替代第一个问号
        preparedStatement.setString(8,goddess.getUpdateUser());//替代第一个问号
        preparedStatement.setInt(9, goddess.getIsdel());//替代第一个问号
        //执行sql语句
        preparedStatement.execute();
    }

    public void delGoddess(Integer id) throws SQLException{
        Connection conn=DbUtil.getConnection();
        String sql="" +
                " delete from imooc_goddess " +
                " where id=? ";
        PreparedStatement ptmt=conn.prepareStatement(sql);
        ptmt.setInt(1, id);
        ptmt.execute();
    }

    public void updateGoddess(Goddess g) throws SQLException{
        Connection conn=DbUtil.getConnection();
        String sql="" +
                " update imooc_goddess " +
                " set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, " +
                " update_user=?,update_date=current_date(),isdel=? " +
                " where id=? ";
        PreparedStatement ptmt=conn.prepareStatement(sql);

        ptmt.setString(1, g.getUserName());
        ptmt.setInt(2, g.getSex());
        ptmt.setInt(3, g.getAge());
        ptmt.setDate(4, new Date(g.getBirthday().getTime()));
        ptmt.setString(5, g.getEmail());
        ptmt.setString(6, g.getMobile());
        ptmt.setString(7, g.getUpdateUser());
        ptmt.setInt(8, g.getIsdel());
        ptmt.setInt(9, g.getId());
        ptmt.execute();
    }

    public List<Goddess> query(){
        Connection conn = DbUtil.getConnection();

        Statement statement = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM imooc_goddess";
        List<Goddess> list = new ArrayList<Goddess>();
        try {
            //创建Statement对象
            statement = conn.createStatement();
            //执行语句得到结果
            rs = statement.executeQuery(sql);
            //处理结果
            while(rs.next()){
                Goddess goddess = new Goddess();
                list.add(goddess);

                goddess.setId(rs.getInt("id"));
                goddess.setUserName(rs.getString("user_name"));
                goddess.setAge(rs.getInt("age"));
                goddess.setSex(rs.getInt("sex"));
                goddess.setBirthday(rs.getDate("birthday"));
                goddess.setEmail(rs.getString("email"));
                goddess.setMobile(rs.getString("mobile"));
                goddess.setCreateUser(rs.getString("create_user"));
                goddess.setUpdateUser(rs.getString("update_user"));
                goddess.setCreateDate(rs.getTimestamp("create_date"));
                goddess.setUpdateDate(rs.getTimestamp("update_date"));
                goddess.setIsdel(rs.getInt("isdel"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Goddess> query(String name,String mobile,String email) throws Exception{
        List<Goddess> result=new ArrayList<Goddess>();

        Connection conn=DbUtil.getConnection();
        StringBuilder sb=new StringBuilder();
        sb.append("select * from imooc_goddess  ");

        sb.append(" where user_name like ? and mobile like ? and email like ?");

        PreparedStatement ptmt=conn.prepareStatement(sb.toString());
        ptmt.setString(1, "%"+name+"%"); //另一种模糊搜索的方式
        ptmt.setString(2, "%"+mobile+"%");
        ptmt.setString(3, "%"+email+"%");
        System.out.println(sb.toString());
        ResultSet rs=ptmt.executeQuery();

        Goddess g=null;
        while(rs.next()){
            g=new Goddess();
            g.setId(rs.getInt("id"));
            g.setUserName(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreateDate(rs.getTimestamp("create_date"));
            g.setCreateUser(rs.getString("create_user"));
            g.setUpdateDate(rs.getTimestamp("update_date"));
            g.setUpdateUser(rs.getString("update_user"));
            g.setIsdel(rs.getInt("isdel"));
            result.add(g);
        }
        return result;
    }


    public List<Goddess> query(List<Map<String, Object>> params) throws Exception{
        List<Goddess> result=new ArrayList<Goddess>();

        Connection conn=DbUtil.getConnection();
        StringBuilder sb=new StringBuilder();
        sb.append("select * from imooc_goddess where 1=1 ");

        if(params!=null&&params.size()>0){
            for (int i = 0; i < params.size(); i++) {
                Map<String, Object> map=params.get(i);
                //把查询条件整体放入map  name = value 三者都放入map
                sb.append(" and  "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
            }
        }

        PreparedStatement ptmt=conn.prepareStatement(sb.toString());

        System.out.println(sb.toString());
        ResultSet rs=ptmt.executeQuery();

        Goddess g=null;
        while(rs.next()){
            g=new Goddess();
            g.setId(rs.getInt("id"));
            g.setUserName(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreateDate(rs.getTimestamp("create_date"));
            g.setCreateUser(rs.getString("create_user"));
            g.setUpdateDate(rs.getTimestamp("update_date"));
            g.setUpdateUser(rs.getString("update_user"));
            g.setIsdel(rs.getInt("isdel"));

            result.add(g);
        }
        return result;
    }

    public Goddess get(Integer id) throws SQLException{
        Goddess g=null;
        Connection conn=DbUtil.getConnection();
        String sql="" +
                " select * from imooc_goddess " +
                " where id=? ";
        PreparedStatement ptmt=conn.prepareStatement(sql);

        ptmt.setInt(1, id);
        ResultSet rs=ptmt.executeQuery();
        while(rs.next()){
            g=new Goddess();
            g.setId(rs.getInt("id"));
            g.setUserName(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setSex(rs.getInt("sex"));
            g.setBirthday(rs.getDate("birthday"));
            g.setEmail(rs.getString("email"));
            g.setMobile(rs.getString("mobile"));
            g.setCreateDate(rs.getTimestamp("create_date"));
            g.setCreateUser(rs.getString("create_user"));
            g.setUpdateDate(rs.getTimestamp("update_date"));
            g.setUpdateUser(rs.getString("update_user"));
            g.setIsdel(rs.getInt("isdel"));
        }
        return g;
    }
}
