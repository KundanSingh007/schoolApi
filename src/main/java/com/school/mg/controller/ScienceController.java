package com.school.mg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.mg.bean.ScienceBean;
import com.school.mg.service.ScienceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class ScienceController {
	
	@Autowired
	private ScienceService scienceService;
	
	@Operation(summary = "This is to fetch the details of Science Student")
	@ApiResponses(value = {
	@ApiResponse(responseCode = "200", description = "Details of All the Science Student", content = {
	@Content(mediaType = "application/json") }) })
	@GetMapping("/science-student")
	List<ScienceBean> fetchAllAgentLoc() {

		return scienceService.getAllScience();
	}

	
	@Operation(summary ="This is to fetch the details of a Science Student on the basis of ID")			 
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Found the Single Science Student",content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ScienceBean.class)) }),
	@ApiResponse(responseCode = "400", description = "Invalid Id supplied.", content = @Content), 
	@ApiResponse(responseCode = "404", description = "Science Student Not Found.", content = @Content) })
	@GetMapping("/science-student/{Id}")
	public ResponseEntity<ScienceBean> fetchUserById(@PathVariable String Id) throws Exception {
		System.err.println("You search with Student with Id--->" + Id);
		return ResponseEntity.ok(scienceService.findById(Id));
	}
	
	@Operation(summary = "This is to Create new cience Student on the basis of ID")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Create Science Student on the Basis of Id associated with School", content = {@Content(mediaType = "application/json") }) })
	@PostMapping("/science-student/create")
	public ScienceBean addVisaServiceMaster(@Valid @RequestBody ScienceBean scienceBean) {
		System.out.println("You ar adding:" + scienceBean);
		//System.out.println("getRemoteHost--Ip:" + request.getRemoteHost());
		//System.out.println("getRemoteAddr--Ip:" + request.getRemoteAddr());
		return scienceService.addScienceStudent(scienceBean);
	}

	@Operation(summary = "This is to Update the a details of Service associated with CONSPROM on the basis of ID")
	@ApiResponses(value = {
	@ApiResponse(responseCode = "200", description = "Update the Details of the Single Service on the Basis of Id associated with CONSPROM", content = {
	@Content(mediaType = "application/json") }) })
	@PutMapping("/science-student/update/{id}")
	public ResponseEntity<ScienceBean> update(@Valid @PathVariable String Id,@RequestBody ScienceBean scienceBean) {
		System.out.println("Updating data for Id:" + Id);
		//System.out.println("getting data:" + visaServiceMasterBean);
		//System.out.println("Ip:" + request.getRemoteHost());
		return new ResponseEntity<ScienceBean>(scienceService.updateScienceStudent(scienceBean, Id),HttpStatus.OK);
	}

	
}
