package com.lyl.local.dao.user;

import org.springframework.stereotype.Repository;

import com.lyl.local.entity.user.UserEntity;

@Repository
public interface UserDAO {
	UserEntity getUserById(int id);
}
