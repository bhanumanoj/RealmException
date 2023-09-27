package com.springboot.realmDb.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.realmDb.dao.UserInfoDAO;
import com.springboot.realmDb.model.UserInfo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	

	@Autowired
	private UserInfoDAO userInfoDAO;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserInfo userInfo = userInfoDAO.getActiveUserInfo(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
		
		User user = new User(userInfo.getUserName(),
				userInfo.getPassword(),Arrays.asList(authority));
		
		UserDetails userDetails = (UserDetails)user; 
		return userDetails;
	}
	}


