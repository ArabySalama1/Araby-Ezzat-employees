package com.sirma.employees.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirma.employees.dto.EmployeePair;
import com.sirma.employees.mapper.EmployeeMapper;
import com.sirma.employees.model.Employee;

@Service
public class EmployeesService {

	@Autowired
	private EmployeeMapper employeeMapper;

	// Find pairs employees list
	public List<EmployeePair> findPairEmployee(InputStream inputStream) throws IOException {
		List<EmployeePair> employeePairs = new ArrayList<>();

		// Read employees data from file
		List<Employee> employeeData = readEmployeesData(inputStream);

		// Group employees by project id
		Map<Long, List<Employee>> employeeGroups = employeeData.stream()
				.collect(Collectors.groupingBy(Employee::getProjectId));

		employeeGroups.forEach((k, v) -> {

			// Sort employee group by largest work days and return first two.
			List<Employee> employees = v.stream()
					.sorted(Comparator
							.comparing((Employee e) -> Period.between(e.getDateFrom(), e.getDataTo()).getDays())
							.reversed())
					.limit(2).collect(Collectors.toList());

			EmployeePair employeePair = new EmployeePair();
			employeePair.setFirstEmpId(employees.get(0).getEmpId());
			employeePair.setSecondEmpId(employees.get(1).getEmpId());
			employeePair.setProjectId(k);
			employeePairs.add(employeePair);
		});

		return employeePairs;
	}

	// Read employeeData from file
	private List<Employee> readEmployeesData(InputStream inputStream) throws IOException {
		List<Employee> employeesData = new ArrayList<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		while (reader.ready()) {
			String line = reader.readLine();
			employeesData.add(employeeMapper.mapStringToEmployee(line));
		}

		return employeesData;

	}
}
