package com.lyl.local.service.user;

import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyl.local.dao.user.UserDAO;
import com.lyl.local.entity.user.UserEntity;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDao;
	
	public UserEntity getUserById(int id){
/*		try {
		if(memcachedClient.get("userId")!=null){
				System.out.println("memcahed"+memcachedClient.get("userId").toString());
			}
		} catch (TimeoutException | InterruptedException | MemcachedException e1) {
			e1.printStackTrace();
		}*/
		UserEntity user = userDao.getUserById(1);
		
/*		try {
			memcachedClient.set("userId",1000,user.getUserName());
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			e.printStackTrace();
		}*/

		return user;
	}
}

