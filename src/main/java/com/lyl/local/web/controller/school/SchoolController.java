package com.lyl.local.web.controller.school;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyl.local.entity.school.SchoolEntity;
import com.lyl.local.service.school.SchoolService;

@RequestMapping("school")
@Controller
public class SchoolController {
	@Autowired
	SchoolService schoolService;
	
	@RequestMapping("getSchool")
	@ResponseBody
	public String getSchools(HttpServletRequest request){
		List<SchoolEntity> schoolList=schoolService.getSchools();
		StringBuilder sb = new StringBuilder();
		for(SchoolEntity schoolEntity:schoolList){
			sb.append("\t"+schoolEntity.getId());
			sb.append("\t"+schoolEntity.getTeachers());
			sb.append("\t"+schoolEntity.getSchoolName()+"\n");
		}
		return sb.toString();
	}
}

