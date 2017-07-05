package com.chuxiao.action;

import com.chuxiao.dao.GoddessDao;
import com.chuxiao.model.Goddess;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


//Ïàµ±ÓÚservice²ã
public class GoddessAction {

	public void add(Goddess goddess) throws Exception{
		GoddessDao dao=new GoddessDao();
		goddess.setSex(1);
		goddess.setCreateUser("ADMIN");
		goddess.setUpdateUser("ADMIN");
		goddess.setIsdel(0);
		dao.addGoddess(goddess);
	}
	
	public Goddess get(Integer id) throws SQLException{
		GoddessDao dao=new GoddessDao();
		return dao.get(id);
	}
	
	public void edit(Goddess goddess) throws Exception{
		GoddessDao dao=new GoddessDao();
		dao.updateGoddess(goddess);
	}
	public void del(Integer id) throws SQLException{
		GoddessDao dao=new GoddessDao();
		dao.delGoddess(id);
	}
	
	public List<Goddess>  query() throws Exception{
		GoddessDao dao=new GoddessDao();
		return dao.query();
	}
	public List<Goddess> query(List<Map<String, Object>> params) throws Exception{
		GoddessDao dao=new GoddessDao();
		return dao.query(params);
	}
}
