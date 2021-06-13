package sg.nityo.test.testingrestful.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nityo.test.testingrestful.domain.Salary;
import sg.nityo.test.testingrestful.repo.SalaryRepository;

@Service
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	SalaryRepository srepo;
	
	@Override
	public ArrayList<Salary> findAll() {
		return (ArrayList<Salary>)srepo.findAll();
	}

	@Override
	public Salary findSalaryById(long employee_id) {
		return srepo.findById(employee_id).get();
	}

	@Override
	public boolean saveSalary(Salary salary) {
		if (srepo.save(salary)!=null) return true; else return false;
	}

	@Override
	public void deleteSalaryById(long employee_id) {
		srepo.deleteById(employee_id);
	}

	@Override
	public void editSalary(long employee_id, Salary salary) {
		Salary newsalary = srepo.findById(employee_id).get();
		newsalary.setBasic_salary(salary.getBasic_salary());
		newsalary.setAllowance(salary.getAllowance());
		srepo.save(newsalary);
	}
	
	public double maxTax(long empid) {
		Salary salary=findSalaryById(empid);
		double maxtax=0;
		double monthlySalary=salary.getAllowance()+salary.getBasic_salary();
		double annualSalary=monthlySalary*12;
		double s1=15000;
		double s2=30000;
		double s3=45000;
		double s4=75000;
		double rate1=0;
		double rate2=200;
		double rate3=0.0475;
		double rate4=0.07;
		
		if (annualSalary <= s1) {
	        maxtax = rate1 * annualSalary;
		}else if (annualSalary <= s2) {
			maxtax = rate1 * s1 + rate2 * (annualSalary - s1);  
		}else if (annualSalary <= s3) {
			maxtax = rate1 * s1 + rate2 * (s2 - s1) + rate3 * (annualSalary - s2);
		}else if (annualSalary >= s4){
			maxtax = rate1 * s1 + rate2 * (s2 - s1) + rate3 * (s3-s2) + rate4 * (annualSalary - s4);
		}
		return maxtax;
	}

}
