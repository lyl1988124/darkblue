package com.lyl.local.service.school;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyl.local.dao.school.SchoolDao;
import com.lyl.local.entity.school.SchoolEntity;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Service
public class SchoolService {
	
	@Autowired
	SchoolDao schoolDao;
	
	@Autowired
	public ShardedJedisPool shardedJedisPool;
	
	public List<SchoolEntity> getSchools(){
		ShardedJedis shardedJedis = shardedJedisPool.getResource();
		List<SchoolEntity> scoolList=null;
		/*		if(!redisBase.KEYS.exists("schools")){
			byte[] value = redisBase.LISTS.lpop("schools".getBytes());
            if(value!= null){
            	Object object = SerializeUtil.unserialize(value);
            	scoolList=(List<SchoolEntity>) object;
            }
		}else{
			scoolList=schoolDao.getSchools();
			redisBase.LISTS.lpush("school".getBytes(), SerializeUtil.serialize(scoolList));
		}*/
		shardedJedis.lpush("redistest", "leehon");
		scoolList=schoolDao.getSchools();
		
		return scoolList;
	}
}

