package sg.nityo.test.testingrestful.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nityo.test.testingrestful.domain.Employee;
import sg.nityo.test.testingrestful.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository erepo;
	
	@Override
	public ArrayList<Employee> findAll() {
		return (ArrayList<Employee>)erepo.findAll();
	}

	@Override
	public Employee findEmployeeById(long employee_id) {
		return erepo.findById(employee_id).get();
	}

	@Override
	public boolean saveEmployee(Employee emp) {
		if (erepo.save(emp)!=null) return true; else return false;
	}

	@Override
	public void deleteEmployeeById(long employee_id) {
		erepo.deleteById(employee_id);
	}

	@Override
	public void editEmployee(long employee_id,Employee emp) {
		Employee newemp = erepo.findById(employee_id).get();
		newemp.setFirst_name(emp.getFirst_name());
		newemp.setLast_name(emp.getLast_name());
		newemp.setEmail(emp.getEmail());
		newemp.setGender(emp.getGender());
		erepo.save(newemp);
	}

	@Override
	public ArrayList<Employee> getEmployeeByGender(String gender) {
		ArrayList<Employee> empList=new ArrayList<Employee>();
		if(gender.equals("male")) {
			empList=erepo.findByGender("male");
		}else {
			empList=erepo.findByGender("female");
		}
		return empList;
	}
	
	
	/*
	 * @Override public List<Employee> findByDepartment_id(long department_id){
	 * return erepo.findByDepartment(department.) }
	 */
	 
}
