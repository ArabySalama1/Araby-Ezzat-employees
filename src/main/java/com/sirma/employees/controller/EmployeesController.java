package com.sirma.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sirma.employees.dto.EmployeePair;
import com.sirma.employees.service.EmployeesService;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

	@Autowired
	private EmployeesService employeesService;

	@PostMapping("/findPairs")
	public String findEmployee(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
		// check if file is empty
		if (file.isEmpty()) {
			attributes.addFlashAttribute("message", "Please select a file.");
			return "redirect:/";
		}

		try {
			List<EmployeePair> result = employeesService.findPairEmployee(file.getInputStream());
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString = objectMapper.writeValueAsString(result);
			System.out.println(jsonString);

			attributes.addFlashAttribute("message", "File processed successfully");
			attributes.addFlashAttribute("result", jsonString);
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("message", "Internal server error");
		}
		return "redirect:/";
	}
}
