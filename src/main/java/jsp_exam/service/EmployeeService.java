package jsp_exam.service;

import java.util.List;

import jsp_exam.daoImpl.EmployeeDaoImpl;
import jsp_exam.dto.Employee;
import jsp_exam.util.JdbcUtil;

public class EmployeeService {
	private EmployeeDaoImpl dao;
	
	public EmployeeService() {
		dao = EmployeeDaoImpl.getInstances();
		dao.setCon(JdbcUtil.getConnection());
	}
	
	public List<Employee> showEmployee(){
		return dao.selectEmployeeAll();
	}
}
