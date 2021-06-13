package sg.nityo.test.testingrestful.controllers;

import java.util.List;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sg.nityo.test.testingrestful.domain.Employee;
import sg.nityo.test.testingrestful.repo.EmployeeRepository;
import sg.nityo.test.testingrestful.service.EmployeeService;
import sg.nityo.test.testingrestful.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employeeapi")
public class EmployeeController {
	@Autowired
	protected EmployeeService empservice;

	@Autowired
	public void setEmployeeService (EmployeeServiceImpl empserviceim)
	{
		this.empservice = empserviceim;
	}
	
	@Autowired
	EmployeeRepository emprepo;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return empservice.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> get(@PathVariable Integer id) {
	    try {
	        Employee emp = empservice.findEmployeeById(id);
	        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/employees")
	public void add(@RequestBody Employee employee) {
	    empservice.saveEmployee(employee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Object> update(@RequestBody Employee employee, @PathVariable Integer id) {
	    try {
	        empservice.editEmployee(id, employee);
	        return ResponseEntity.noContent().build();
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/employees/{id}")
	public void delete(@PathVariable Integer id) {
	    empservice.deleteEmployeeById(id);
	}
	
	/*
	 * @RequestMapping(method = RequestMethod.GET) public List<Employee>
	 * getEmployees(@RequestParam(value="gender") String gender) {
	 * System.out.println("Gender"+gender); return
	 * empservice.getEmployeeByGender(gender); }
	 */
	
	@GetMapping("/employee")
	@ResponseBody
	public List<Employee> getEmployeesByGender(@RequestParam String gender) {
		System.out.println("Gender"+gender);
		return empservice.getEmployeeByGender(gender);
	}
	
	/*
	@GetMapping("/employees/{gender}")
	public List<Employee> getEmployees(@PathVariable String gender) {
		return empservice.findByGender(gender); 
	}
	*/
	/*
	 * @GetMapping("/employees/{dept_id}") public List<Employee>
	 * getEmployees(@PathVariable Integer dept_id) { return
	 * empservice.findByDepartment_id(dept_id); }
	 */
}
