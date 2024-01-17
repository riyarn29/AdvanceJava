package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicTestPSTMTUpdate {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root", "root");
		PreparedStatement pstmt=conn.prepareStatement("update marksheet set roll_no=?,name=?,physics=?,chemistry=?,maths=? where id=?");
		pstmt.setInt(1, 99);
		pstmt.setString(2, "yy");
		pstmt.setInt(3, 33);
		pstmt.setInt(4, 33);
		pstmt.setInt(5, 33);
		pstmt.setInt(6,8);
		int i=pstmt.executeUpdate();
		System.out.println("data updated="+i);
	}

}
