package com.school.mg.service;

import java.util.List;

import com.school.mg.bean.ScienceBean;

public interface ScienceService {

	public List<ScienceBean> getAllScience();

	public ScienceBean findById(String Id) throws Exception;
	
	public ScienceBean addScienceStudent(ScienceBean scienceBean);
	
	public ScienceBean updateScienceStudent(ScienceBean scienceBean,String Id);
	
}
