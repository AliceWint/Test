package sg.nityo.test.testingrestful.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.nityo.test.testingrestful.domain.Department;
import sg.nityo.test.testingrestful.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	//List<Employee> findByDepartment(Department department);
	//List<Employee> findByDepartmentEmployees(long department_id);
	
	//@Query("SELECT e FROM Employee where e.department_id=:id")
	//ArrayList<Employee> findEmployeesByDepartment_id(@Param("id")long id);
	
	//ArrayList<Employee> findByGenderLike(String likePattern);
	ArrayList<Employee> findByGender(String gender);
}
