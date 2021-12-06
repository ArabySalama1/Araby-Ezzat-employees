package com.sirma.employees.mapper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.sirma.employees.model.Employee;

@Component
public class EmployeeMapper {

	public Employee mapStringToEmployee(String text) {

		String data[] = text.split(",");
		Employee employee = new Employee();
		employee.setEmpId(Long.parseLong(data[0].trim()));
		employee.setProjectId(Long.parseLong(data[1].trim()));
		employee.setDateFrom(LocalDate.parse(data[2].trim()));
		LocalDate dateTo = !data[3].trim().equals("NULL")  ? LocalDate.parse(data[3].trim()) : LocalDate.now();
		employee.setDataTo(dateTo);
		return employee;
	}
}
