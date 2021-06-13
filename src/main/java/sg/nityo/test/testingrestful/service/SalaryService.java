package sg.nityo.test.testingrestful.service;

import java.util.ArrayList;

import sg.nityo.test.testingrestful.domain.Salary;

public interface SalaryService {
	public ArrayList<Salary> findAll();	
	public Salary findSalaryById(long employee_id);
	public boolean saveSalary(Salary salary);
	public void deleteSalaryById(long employee_id); 
	public void editSalary(long employee_id,Salary salary); 
}
