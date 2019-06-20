package com.nt.service;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.UserBO;
import com.nt.dao.LoginDAO;
import com.nt.dto.UserDTO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO dao;

	

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
