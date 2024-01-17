package in.co.rays.callablestmt;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestStoredFunction {

public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","root");
	
	CallableStatement callStmt = conn.prepareCall("{ ? = CALL square(?)}");
	callStmt.setInt(2,3);
	callStmt.registerOutParameter(1, Types.INTEGER);
	callStmt.execute();
	System.out.println("square ="+callStmt.getInt(1));
	
	
	CallableStatement call= conn.prepareCall("{?= CALL yaar(?)}");
	call.setInt(2,3);
	call.registerOutParameter(1, Types.INTEGER);
	call.execute();
	System.out.println("cube ="+ call.getInt(1));
}
}
