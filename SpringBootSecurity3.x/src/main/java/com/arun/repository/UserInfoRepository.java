package com.arun.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arun.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{

	public Optional<UserInfo> findByUserName(String userName);
}
