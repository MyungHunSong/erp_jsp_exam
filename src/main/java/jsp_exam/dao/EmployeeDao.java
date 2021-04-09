package jsp_exam.dao;

import java.util.List;

import jsp_exam.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectEmployeeAll();
	Employee selectEmployeeByNo(Employee emp);
	
	int insertEmployee(Employee emp);
	int	deleteEmployee(Employee emp);
	int	updateEmployee(Employee emp);
}
