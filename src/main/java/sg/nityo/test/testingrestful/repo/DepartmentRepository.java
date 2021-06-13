package sg.nityo.test.testingrestful.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nityo.test.testingrestful.domain.Department;
import sg.nityo.test.testingrestful.domain.Employee;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	//List<Employee> findEmployeesByDepartment_Id(long department_id);
}
