package com.lyl.local.entity.school;

import java.io.Serializable;

public class SchoolEntity implements Serializable{

	/**
	  * @Fields serialVersionUID : TODO（用一句话描述这个变量表示什么）
	  */
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String schoolName;
	private int teachers;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public int getTeachers() {
		return teachers;
	}
	public void setTeachers(int teachers) {
		this.teachers = teachers;
	}
}

