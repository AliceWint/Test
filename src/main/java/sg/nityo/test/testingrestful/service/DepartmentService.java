package sg.nityo.test.testingrestful.service;

import java.util.ArrayList;
import java.util.List;

import sg.nityo.test.testingrestful.domain.Department;
import sg.nityo.test.testingrestful.domain.Employee;

public interface DepartmentService {
	public ArrayList<Department> findAll();	
	public boolean saveDepartment(Department dept);
	public void editDepartment(long department_id,Department dept);
	public void deleteDepartmentById(long department_id); 	
	public List<Employee> findAllEmployees(long department_id);
}
