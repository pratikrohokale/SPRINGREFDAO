package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.nt.bo.UserBO;

public class LoginDAOImpl implements LoginDAO {
	private SimpleJdbcCall sjc;
	
	  public void setSjc(SimpleJdbcCall sjc) {
			this.sjc = sjc;
		}

    
	@Override
	public Map<String, Object> authenicate(UserBO bo) {
		Map<String,Object> inParams=null;
		Map<String,Object> outParams=null;
		//set PRocedure name
		sjc.setProcedureName("P_AUTHENTICATION");
		//prepare IN PARAM NAMES AND VALUES
		inParams=new HashMap();
		inParams.put("U_NAME", bo.getUname());
		inParams.put("PASS",bo.getPwd());
		//execute PL/SQL Procedure
		outParams=sjc.execute(inParams);
		return outParams;
	}

}
