package sg.nityo.test.testingrestful.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nityo.test.testingrestful.domain.Department;
import sg.nityo.test.testingrestful.domain.Employee;
import sg.nityo.test.testingrestful.repo.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository drepo;
	
	@Override
	public ArrayList<Department> findAll() {
		return (ArrayList<Department>)drepo.findAll();
	}

	@Override
	public boolean saveDepartment(Department dept) {
		if (drepo.save(dept)!=null) return true; else return false;
	}

	@Override
	public void editDepartment(long department_id, Department dept) {
		Department newdept = drepo.findById(department_id).get();
		newdept.setName(dept.getName());
		drepo.save(newdept);
	}

	@Override
	public void deleteDepartmentById(long department_id) {
		drepo.deleteById(department_id);
	}

	/*
	@Override
	public List<Employee> findAllEmployees(long department_id) {
		return (ArrayList<Employee>)drepo.findEmployeesByDepartment_Id(department_id);
	}
*/
	
	@Override
	public List<Employee> findAllEmployees(long department_id) {
		Optional<Department> dept=drepo.findById(department_id);
		return dept.get().getEmployees();
	}
}
