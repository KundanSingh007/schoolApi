package com.school.mg.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.mg.bean.ScienceBean;
import com.school.mg.exception.ResourceNotFoundException;
import com.school.mg.repository.ScienceRepository;
import com.school.mg.service.ScienceService;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ScienceServiceImpl implements ScienceService {

	@Autowired
	private HttpServletRequest request;
	
	
	
	@Autowired
	private ScienceRepository scienceRepository;

	@Override
	public List<ScienceBean> getAllScience() {

		return (List<ScienceBean>) scienceRepository.findAll();
	}

	@Override
	public ScienceBean findById(String Id) throws ResourceNotFoundException {
		return scienceRepository.findById(Id).orElseThrow(
				() -> new ResourceNotFoundException("No Data Found With Id--:" + Id + ",Please Check the (Id)!"));
	}

	@Override
	public ScienceBean addScienceStudent(ScienceBean scienceBean) {
		scienceRepository.save(scienceBean);
		return scienceBean;
	}

	@Override
	public ScienceBean updateScienceStudent(ScienceBean scienceBean, String Id) {
		ScienceBean exisScienceBean = scienceRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("No data is found with: " + Id + ""));

		exisScienceBean.setClsTeacher(exisScienceBean.getClsTeacher().toUpperCase());
		exisScienceBean.setCreatdBy(exisScienceBean.getCreatdBy().toUpperCase());
		exisScienceBean.setCreatedDate(exisScienceBean.getCreatedDate());
		exisScienceBean.setCreatedOn(exisScienceBean.getCreatedOn()+ request.getRemoteAddr());
		exisScienceBean.setDuster(exisScienceBean.getDuster());
		exisScienceBean.setPen(exisScienceBean.getPen());
		exisScienceBean.setPencil(exisScienceBean.getPencil());
		exisScienceBean.setRecordStatus(0);
		exisScienceBean.setRollNo(exisScienceBean.getRollNo());
		exisScienceBean.setRoom(exisScienceBean.getRoom());
		exisScienceBean.setStudentsName(exisScienceBean.getStudentsName().toUpperCase());
		scienceRepository.save(exisScienceBean);
		return exisScienceBean;

	}

}
