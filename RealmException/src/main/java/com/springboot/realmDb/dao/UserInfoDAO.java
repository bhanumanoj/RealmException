package com.springboot.realmDb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.realmDb.model.UserInfo;

@Repository
public interface UserInfoDAO extends JpaRepository<UserInfo, String>{
	
	@Query(value="SELECT u FROM UserInfo u where username=?1")
	public UserInfo getActiveUserInfo(String userName);
}
