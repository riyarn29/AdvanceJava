package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestPSTMTRead {
public static void main(String[] args) throws Exception{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","root");
	PreparedStatement pstmt=conn.prepareStatement("select * from marksheet where id=1");
	ResultSet rs=pstmt.executeQuery();
	while(rs.next()) {
		System.out.print(rs.getInt(1));
		System.out.print("\t"+rs.getInt(2));
		System.out.print("\t"+rs.getString(3));
		System.out.print("\t"+rs.getInt(4));
		System.out.print("\t"+rs.getInt(5));
		System.out.println("\t"+rs.getInt(6));

		
		
		
	}
	
}
}
