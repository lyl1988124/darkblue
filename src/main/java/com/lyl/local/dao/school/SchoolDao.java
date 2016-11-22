package com.lyl.local.dao.school;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyl.local.entity.school.SchoolEntity;

@Repository
public interface SchoolDao {
	List<SchoolEntity> getSchools();
}

