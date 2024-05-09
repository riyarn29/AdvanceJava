package in.co.rays.callablestmt;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestProcedureOut {
public static void main(String[] args) throws Exception {
	
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","root");
		CallableStatement callStmt=conn.prepareCall("{CALL empOut(?)}");
		
		callStmt.registerOutParameter(1, Types.INTEGER);

		callStmt.execute();
		
	int	resultvalue = callStmt.getInt(1);
	
		System.out.println("value after empout stored procedure = "+resultvalue);
		
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
}
}
