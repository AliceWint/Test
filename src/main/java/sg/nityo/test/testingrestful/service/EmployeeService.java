package sg.nityo.test.testingrestful.service;

import java.util.ArrayList;
import java.util.List;

import sg.nityo.test.testingrestful.domain.Employee;

public interface EmployeeService {
	public ArrayList<Employee> findAll();
	public Employee findEmployeeById(long employee_id);
	
	public boolean saveEmployee(Employee emp);
	public void deleteEmployeeById(long employee_id); 
	public void editEmployee(long employee_id,Employee emp); 
	//public List<Employee> findAllEmployeesByDept_id(long department_id);
	public ArrayList<Employee> getEmployeeByGender(String gender);
}
