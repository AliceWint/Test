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
import org.springframework.web.bind.annotation.RestController;

import sg.nityo.test.testingrestful.domain.Department;
import sg.nityo.test.testingrestful.domain.Employee;
import sg.nityo.test.testingrestful.repo.DepartmentRepository;
import sg.nityo.test.testingrestful.service.DepartmentService;
import sg.nityo.test.testingrestful.service.DepartmentServiceImpl;

@RestController
@RequestMapping("/departmentapi")
public class DepartmentController {
	@Autowired
	protected DepartmentService deptservice;

	@Autowired
	public void setEmployeeService (DepartmentServiceImpl deptserviceim)
	{
		this.deptservice = deptserviceim;
	}
	
	@Autowired
	DepartmentRepository deptrepo;
	
	@GetMapping("/departments")
	public List<Department> getAllDepartments() {
		return deptservice.findAll();
	}
	
	@PostMapping("/departments")
	public void add(@RequestBody Department department) {
	    deptservice.saveDepartment(department);
	}
	
	@PutMapping("/departments/{id}")
	public ResponseEntity<Object> update(@RequestBody Department department, @PathVariable Integer id) {
	    try {
	        deptservice.editDepartment(id, department);
	        return ResponseEntity.noContent().build();
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/departments/{id}")
	public void delete(@PathVariable Integer id) {
	    deptservice.deleteDepartmentById(id);
	}
		
	@GetMapping("/departments/{id}")
	public List<Employee> getEmployees(@PathVariable Integer id) {
		return deptservice.findAllEmployees(id);     
	}
}
