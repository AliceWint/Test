package sg.nityo.test.testingrestful.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nityo.test.testingrestful.domain.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Long> {

}
