package in.co.rays.roughwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestClass {
public static void main(String[] args) throws Exception {
	//add(12,112,"kk",1,1,1);
	
	//update(12,222,"jj", 11, 1, 10);
	//delete(12);
//read();
	readById(4);
	
	
}
public static void add(int id,int rollNo,String name,int phy,int chem,int maths)throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","root");
	PreparedStatement pstmt=conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
	pstmt.setInt(1,id);
	pstmt.setInt(2,rollNo);
	pstmt.setString(3,name);
	pstmt.setInt(4,phy);
	pstmt.setInt(5,chem);
	pstmt.setInt(6,maths);
	int i=pstmt.executeUpdate();
	System.out.println(i);
}
public static void update (int id,int rollNo,String name,int phy,int chem,int maths)throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","root");
	PreparedStatement pstmt=conn.prepareStatement("update marksheet set roll_no=?,name=?,physics=?,chemistry=?,maths=? where id=?");
	
	pstmt.setInt(1,rollNo);
	pstmt.setString(2,name);
	pstmt.setInt(3,phy);
	pstmt.setInt(4,chem);
	pstmt.setInt(5,maths);
	pstmt.setInt(6,id);
	int i=pstmt.executeUpdate();
	
	System.out.println(i);
}
public static void delete(int id)throws Exception{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","root");
	PreparedStatement pstmt=conn.prepareStatement("delete from marksheet where id=?");
	pstmt.setInt(1,id);
	int i=pstmt.executeUpdate();
	System.out.println(i);
	
}
public static void read()throws Exception{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","root");
	PreparedStatement pstmt=conn.prepareStatement("select * from marksheet");
	ResultSet rs= pstmt.executeQuery();
	while(rs.next()) {
		System.out.println(rs.getInt(1));
		System.out.println(rs.getInt(2));
		System.out.println(rs.getString(3));
		System.out.println(rs.getInt(4));
		System.out.println(rs.getInt(5));
		System.out.println(rs.getInt(6));
	}
}
public static void readById(int id)throws Exception{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","root");
	PreparedStatement pstmt=conn.prepareStatement("select * from marksheet where id=?");
	
	pstmt.setInt(1, id);
	
	ResultSet rs= pstmt.executeQuery();
	
	while(rs.next()) {
		System.out.println(rs.getInt(1));
		System.out.println(rs.getInt(2));
		System.out.println(rs.getString(3));
		System.out.println(rs.getInt(4));
		System.out.println(rs.getInt(5));
		System.out.println(rs.getInt(6));
		
		
	}
}
	
}


