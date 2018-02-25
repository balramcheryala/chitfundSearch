package com.chitfunds.service;

import java.util.List;

import com.chitfunds.orm.Employee;

/**
 * @author Balram
 * @since 24 May 2018 and 11.00 PM
 *
 */

public interface EmployeeService {

	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer employeeId);

	public Employee getEmployee(int employeeid);

	public Employee updateEmployee(Employee employee);
}
