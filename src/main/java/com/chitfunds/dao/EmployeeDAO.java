package com.chitfunds.dao;

import java.util.List;

import com.chitfunds.orm.Employee;
import com.chitfunds.orm.Tags;

/**
 * @author Balram
 * @since 24 May 2018 and 11.00 PM
 *
 */
public interface EmployeeDAO {

	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer employeeId);

	public Employee updateEmployee(Employee employee);

	public Employee getEmployee(int employeeid);
	
	public List<Tags> searchEmployee(String query);
}
