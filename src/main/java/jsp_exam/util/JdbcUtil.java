package jsp_exam.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	private static DataSource ds;
	
	private JdbcUtil() {}
	
	static {
		 try{
		      InitialContext init = new InitialContext(); // 1. JNDI 서버 객체 생성.
		      ds = (DataSource)init.lookup("java:comp/env/jdbc/erp_jsp_exam"); // 가상 디렉토리 예기하는것
		      System.out.println("ds : " + ds);
		   }catch(Exception e){
		      e.printStackTrace();
		   }	
	}
	
	 public static Connection getConnection(){
		 try {
			 return ds.getConnection();
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }catch (Exception e) {
			 e.printStackTrace();
		}
		return null;
		 	
	 }
}
