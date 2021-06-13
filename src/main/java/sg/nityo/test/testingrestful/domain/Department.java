package sg.nityo.test.testingrestful.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long department_id;
	private String name;
	@OneToMany
	private List<Employee> employees;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(long department_id, String name, List<Employee> employees) {
		super();
		this.department_id = department_id;
		this.name = name;
		this.employees = employees;
	}

	public Department(String name, List<Employee> employees) {
		super();
		this.name = name;
		this.employees = employees;
	}

	public Department(String name) {
		super();
		this.name = name;
	}

	public long getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(long department_id) {
		this.department_id = department_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
}
