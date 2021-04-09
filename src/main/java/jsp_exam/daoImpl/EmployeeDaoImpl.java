package jsp_exam.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jsp_exam.dao.EmployeeDao;
import jsp_exam.dto.Department;
import jsp_exam.dto.Employee;
import jsp_exam.dto.Title;

public class EmployeeDaoImpl implements EmployeeDao {
	private static EmployeeDaoImpl instance = new EmployeeDaoImpl();
	private Connection con;

	public static EmployeeDaoImpl getInstances() {
		if (instance == null) {
			instance = new EmployeeDaoImpl();
		}
		return instance;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	// ---- 셀바올 ---
	@Override
	public List<Employee> selectEmployeeAll() {
		String sql = "select e.empno, e.empname,t.tname, m.empname  as managerName, m.empno as managerNo, e.salary ,d.deptno,d.deptname, e.hiredate \r\n"
				+ "  from employee e join title t on e.title = t.tno \r\n"
				+ "  left join  employee m on e.manager = m.empno \r\n" + "  join department d on e.dept = d.deptno";

		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery();) {
			if (rs.next()) {
				List<Employee> list = new ArrayList<>();

				do {
					list.add(getEmp(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;

	}

	private Employee getEmp(ResultSet rs) throws SQLException {
		int empNo = rs.getInt("e.empno");

		String empName = rs.getString("e.empname");

		Title title = new Title(rs.getString("t.tname"));

		Employee manager = new Employee(rs.getInt("managerNo"));

		manager.setEmpName(rs.getString("managerName"));

		int salary = rs.getInt("e.salary");

		Department dept = new Department(rs.getInt("d.deptno"));

		dept.setDeptName(rs.getString("d.deptname"));

		Date hireDate = rs.getDate("e.hiredate");

		return new Employee(empNo, empName, title, manager, salary, dept, hireDate);
	}

	// ---- 셀바올 ---
	// ---- ByNo ---
	@Override
	public Employee selectEmployeeByNo(Employee emp) {
		String sql = "select empno, empname, title as title_no, manager as manager_no, salary, dept as deptNo, hiredate from employee where empno = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			{
				pstmt.setInt(1, emp.getEmpNo()); // ?꾩뿉 ?덈뒗嫄?荑쇰━臾??명똿(where ??
				System.out.println(pstmt);

				try (ResultSet rs = pstmt.executeQuery()) { // where 議곌굔?????꾪빐??寃곌낵瑜?媛?몄삤??
					if (rs.next()) {
						return getEmployee(rs);
					}

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	private Employee getEmployee(ResultSet rs) throws SQLException {
		int empNo = rs.getInt("empno");

		String empName = rs.getString("empName");
		Title title = new Title(rs.getInt("title_no"));
		Employee manager = new Employee(rs.getInt("manager_no"));
		int salary = rs.getInt("salary");
		Department dept = new Department(rs.getInt("deptNo"));
		Date hireDate = rs.getDate("hiredate");
		try {
			title.settName(rs.getString("title_name"));
		} catch (SQLException e) {
		}
		try {
			manager.setEmpName(rs.getString("manager_name"));
		} catch (SQLException e) {
		}
		try {
			dept.setDeptName(rs.getString("deptName"));
			dept.setFloor(rs.getInt("floor"));
		} catch (SQLException e) {
		}

		return new Employee(empNo, empName, title, manager, salary, dept, hireDate);
	}
	
	//-- ByNo

	@Override
	public int insertEmployee(Employee emp) {
		String sql = "insert into employee values(?, ?, ?, ? , ?, ?,?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setInt(3, emp.getTitle().gettNo());
			pstmt.setInt(4, emp.getManager().getEmpNo());
			pstmt.setInt(5, emp.getSalary());
			pstmt.setInt(6, emp.getDept().getDeptNo());
			pstmt.setTimestamp(7, new Timestamp(emp.getHireDate().getTime()));

			return pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;

	}
	
	@Override
	public int updateEmployee(Employee emp) {
		String sql = "update employee \r\n" + 
				"	set empname = ?, title = ?, manager = ?, salary = ?,dept = ?, hiredate =? \r\n" + 
				"	where empno = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			
			
			pstmt.setString(1, emp.getEmpName());
			pstmt.setInt(2, emp.getTitle().gettNo());
			pstmt.setInt(3, emp.getManager().getEmpNo());
			pstmt.setInt(4, emp.getSalary());
			pstmt.setInt(5, emp.getDept().getDeptNo());
			pstmt.setTimestamp(6, new Timestamp(emp.getHireDate().getTime()));
			pstmt.setInt(7, emp.getEmpNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	@Override
	public int deleteEmployee(Employee emp) {
		String sql = "delete from employee where empno = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			
			pstmt.setInt(1, emp.getEmpNo());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	

}