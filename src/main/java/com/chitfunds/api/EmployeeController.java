package com.chitfunds.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chitfunds.orm.Employee;
import com.chitfunds.orm.Tags;
import com.chitfunds.service.EmployeeService;

@Controller
public class EmployeeController {

	List<Tags> data = new ArrayList<Tags>();

	@Autowired
	private EmployeeService employeeService;

	List<Employee> emp;

	/**
	 * EmployeeController
	 */
	public EmployeeController() {
		System.out.println("Hi ");
	}

	/**
	 * @param tagName
	 * @return
	 */
	@RequestMapping(value = "/getTags", method = RequestMethod.GET)
	public @ResponseBody List<Tags> getTags(@RequestParam String tagName) {

		return simulateSearchResult(tagName);

	}

	/**
	 * @param tagName
	 * @return
	 */
	private List<Tags> simulateSearchResult(String tagName) {
		emp = employeeService.getAllEmployees();
		List<Tags> result = new ArrayList<Tags>();
		// iterate a list and filter by tagName
		for (Employee employee : emp) {
			if (employee.getSearchKeys().contains(tagName)) {
				result.add(new Tags(employee.getSearchKeys()));
			}
		}

		return result;
	}

	/**
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/")
	public ModelAndView listEmployee(ModelAndView model) throws IOException {
		List<Employee> listEmployee = employeeService.getAllEmployees();
		model.addObject("listEmployee", listEmployee);
		model.setViewName("home");
		return model;

	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Employee employee = new Employee();
		model.addObject("employee", employee);
		model.setViewName("EmployeeForm");
		return model;
	}

	/**
	 * @param employee
	 * @return
	 */
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		if (employee.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			employee.setSearchKeys(employee.getName() + "," + employee.getEmail() + "," + employee.getTelephone());
			employeeService.addEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}
		return new ModelAndView("redirect:/");
	}

	/**
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteEmployee(employeeId);
		return new ModelAndView("redirect:/");
	}

	/**
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeService.getEmployee(employeeId);
		ModelAndView model = new ModelAndView("EmployeeForm");
		model.addObject("employee", employee);

		return model;
	}

}
