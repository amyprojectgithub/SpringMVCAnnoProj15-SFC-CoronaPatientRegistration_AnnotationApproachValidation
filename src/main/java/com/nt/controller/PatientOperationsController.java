package com.nt.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.command.PatientCommand;
import com.nt.dto.PatientDTO;
import com.nt.service.PatientMgmtService;


@Controller
//@SessionAttributes("patCmd")
public class PatientOperationsController {
	@Autowired
	private PatientMgmtService service;


	@ModelAttribute("patCmd")
	public PatientCommand getPatientCommand() {
		System.out.println(" Inside PatientOperationsController.getPatientCommand()");
		return new PatientCommand();
	}

	@GetMapping("corona.htm")
	public String showForm(@ModelAttribute("patCmd")PatientCommand cmd) {
		System.out.println("Inside PatientOperationsController.showForm()");

		//setting default values to Command class
		cmd.setAge(null);
		cmd.setPatName(null);
		cmd.setHospital("Gandhi Hospital");
		cmd.setLocation("Hyderabad");
		return "patient_register";		
	}
	@PostMapping("corona.htm")
	public String processForm(Map<String, Object> map,
			@Valid @ModelAttribute("patCmd")PatientCommand cmd,BindingResult br) {

		System.out.println("Inside PatientOperationsController.processForm()");
		PatientDTO dto=null;
		String result=null;
		if(br.hasErrors()) {
			return "patient_register";
		}
		//Patient belongs to Hyderabad is not allowed to register(Application Logic error)
		if(cmd.getLocation().equalsIgnoreCase("Hyderabad")) {
			br.rejectValue("location", "patient.hyd.block");
			return "patient_register";
		}
	

		//convert cmd to dto
		dto=new PatientDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		result=service.register(dto);
		//make result as model attribute
		map.put("result", result);
		//return lvn		
		return "show_result";
	}


}
