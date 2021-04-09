package jsp_exam.dao;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jsp_exam.daoImpl.EmployeeDaoImpl;
import jsp_exam.dto.Department;
import jsp_exam.dto.Employee;
import jsp_exam.dto.Title;
import jsp_exam.util.test.JdbcUtilTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {
	private static Connection con;
	private EmployeeDaoImpl dao;


	@BeforeClass
	public static void setCon(){
		con = JdbcUtilTest.getConnection();
	}

	@Before
	public void setUp() throws Exception {
		dao = EmployeeDaoImpl.getInstances();
		dao.setCon(con);
	}



	
	@Test
	public void test02SelectEmployeeAll() {
		System.out.printf("%s()%n", "testSelectEmployeeByAll()");
		
		List<Employee> employeeList = dao.selectEmployeeAll();
		Assert.assertNotNull(employeeList);
		
		for(Employee e : employeeList) {	
			System.out.println(e);
		}

	}

	@Test
	public void test04SelectEmployeeByNo() {
		System.out.printf("%s()%n", "testSelectEmployeeByNo()");
		
		Employee selEmp = new Employee(1004);
		Employee searchEmployee = dao.selectEmployeeByNo(selEmp);
		
		Assert.assertNotNull(searchEmployee);
		System.out.println(searchEmployee);

	}

	@Test
	public void test01InsertEmployee() {
		System.out.printf("%s()%n","testInsertEmployee()");
		
		
		Employee addEmp = new Employee(1004, "개호구", new Title(3), new Employee(4377), 6000000, new Department(2), new Date());
		int res = dao.insertEmployee(addEmp);
		
		Assert.assertEquals(1,res);
		
		System.out.println(res);
	}
	
	@Test
	public void test03UpdateEmployee() {
		System.out.printf("%s()%n","testUpdateEmployee()");
		
		Employee modifyEmp = new Employee(1004, "개아지", new Title(2), new Employee(1003), 5500000, new Department(3), new Date());
		int res = dao.updateEmployee(modifyEmp);
		
		Assert.assertEquals(1, res);
		
		System.out.println(res);
	}

	@Test
	public void test05DeleteEmployee() {
		System.out.printf("%s()%n","test05DeleteEmployee()");
		
		Employee deleteEmp = new Employee(1004);
		int res = dao.deleteEmployee(deleteEmp);
		
		Assert.assertEquals(1, res);
		System.out.println(res);
	}



}
