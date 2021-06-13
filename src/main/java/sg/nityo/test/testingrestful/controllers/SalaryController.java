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

import sg.nityo.test.testingrestful.domain.Salary;
import sg.nityo.test.testingrestful.repo.SalaryRepository;
import sg.nityo.test.testingrestful.service.SalaryService;
import sg.nityo.test.testingrestful.service.SalaryServiceImpl;

@RestController
@RequestMapping("/salaryapi")
public class SalaryController {
	@Autowired
	protected SalaryService salservice;

	@Autowired
	public void setEmployeeService (SalaryServiceImpl salserviceim)
	{
		this.salservice = salserviceim;
	}
	
	@Autowired
	SalaryRepository salrepo;
	
	@GetMapping("/salaries")
	public List<Salary> getAllSalaries() {
		return salservice.findAll();
	}
	
	@GetMapping("/salaries/{id}")
	public ResponseEntity<Salary> get(@PathVariable Integer id) {
	    try {
	        Salary salary = salservice.findSalaryById(id);
	        return new ResponseEntity<Salary>(salary, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Salary>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@PostMapping("/salaries")
	public void add(@RequestBody Salary salary) {
	    salservice.saveSalary(salary);
	}
	
	@PutMapping("/salaries/{id}")
	public ResponseEntity<Object> update(@RequestBody Salary salary, @PathVariable Integer id) {
	    try {
	        salservice.editSalary(id, salary);
	        return ResponseEntity.noContent().build();
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/salaries/{id}")
	public void delete(@PathVariable Integer id) {
	    salservice.deleteSalaryById(id);
	}
}


