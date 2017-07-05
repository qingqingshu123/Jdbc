package com.chuxiao.action;

import com.chuxiao.dao.GoddessDao;
import com.chuxiao.model.Goddess;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by jixiaoqiang on 2017/7/5.
 */
public class Action {
    public static void main(String[] args) throws SQLException {
        //System.out.println(new Date());
        GoddessDao goddessDao = new GoddessDao();
        List<Goddess> rs = goddessDao.query();
        if(rs != null){
            for(Goddess i: rs)
                System.out.println(i);
        }

        System.out.println("insert");

        Goddess goddess = new Goddess();
        goddess.setUserName("初音");
        goddess.setAge(25);
        goddess.setSex(1);
        goddess.setBirthday(new Date(new java.util.Date().getTime()));
        goddess.setMobile("1557232784");
        goddess.setEmail("54546@QQ.COM");

        goddessDao.addGoddess(goddess);
        rs = goddessDao.query();
        if(rs != null){
            for(Goddess i: rs)
                System.out.println(i);
        }
    }
}
