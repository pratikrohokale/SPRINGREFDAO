package com.nt.service;

import java.util.Map;

import org.springframework.beans.BeanUtils;

import com.nt.bo.UserBO;
import com.nt.dao.LoginDAO;
import com.nt.dto.UserDTO;

public class LoginServiceImpl implements LoginService {
	private LoginDAO dao;

	public void setDao(LoginDAO dao) {
		this.dao = dao;
	}

	@Override
	public String validate(UserDTO dto) {
		UserBO bo=null;
		Map<String,Object> map=null;
		String result=null;
		//Convert DTO to BO
		bo=new UserBO();
		BeanUtils.copyProperties(dto, bo);
		//use dAO
		map=dao.authenicate(bo);
		result=(String)map.get("RESULT");
		return result;
	}

}
