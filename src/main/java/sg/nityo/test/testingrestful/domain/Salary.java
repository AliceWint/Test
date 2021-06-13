package sg.nityo.test.testingrestful.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Salary {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long employee_id;
	private double basic_salary;
	private double allowance;
	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Salary(long employee_id, double basic_salary, double allowance) {
		super();
		this.employee_id = employee_id;
		this.basic_salary = basic_salary;
		this.allowance = allowance;
	}

	public Salary(double basic_salary, double allowance) {
		super();
		this.basic_salary = basic_salary;
		this.allowance = allowance;
	}

	public long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}

	public double getBasic_salary() {
		return basic_salary;
	}

	public void setBasic_salary(double basic_salary) {
		this.basic_salary = basic_salary;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}
	
}
