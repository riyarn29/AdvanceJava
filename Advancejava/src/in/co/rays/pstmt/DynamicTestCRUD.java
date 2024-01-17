package in.co.rays.pstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DynamicTestCRUD {
public static void main(String[] args) throws Exception{
	//testAdd(8,108,"ff",10,12,14);
	//testUpdate(5, 105,"hh",33,1,1);
//	testDelete(9);
	//testRead();
	testFindById(4);
	
	
}
public static void testAdd(int id,int rollNo,String name,int physics,int chemistry,int maths) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","root");
PreparedStatement pstmt=	conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
pstmt.setInt(1,id);
pstmt.setInt(2,rollNo);
pstmt.setString(3,name);
pstmt.setInt(4,physics);
pstmt.setInt(5,chemistry);
pstmt.setInt(6,maths);
int i=pstmt.executeUpdate();
System.out.println("data inserted="+i);		
}
public static void testUpdate(int id,int rollNo,String name,int phy,int chem,int maths)throws Exception{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","root");
	PreparedStatement pstmt =conn.prepareStatement("update marksheet set roll_no=?,name=?,physics=?,chemistry=?,maths=? where id=?");
	pstmt.setInt(1,rollNo);
	pstmt.setString(2, name);
	pstmt.setInt(3,phy);
	pstmt.setInt(4,chem);
	pstmt.setInt(5,maths);
	pstmt.setInt(6,id);
	
	int i=pstmt.executeUpdate();
System.out.println("data updated="+i);

}
public static void testDelete(int id)throws Exception{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","root");
	PreparedStatement pstmt=conn.prepareStatement("delete from marksheet where id=?");
	pstmt.setInt(1,id);
	int i=pstmt.executeUpdate();
	System.out.println("data deleted="+i);
}
public static void testRead() throws Exception{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","root");
	PreparedStatement pstmt=conn.prepareStatement("select * from marksheet");
	ResultSet rs=pstmt.executeQuery();
	while(rs.next()) {
		System.out.print("\t"+rs.getInt(1));
		System.out.print("\t"+rs.getInt(2));
		System.out.print("\t"+rs.getString(3));
		System.out.print("\t"+rs.getInt(4));
		System.out.print("\t"+rs.getInt(5));
		System.out.println("\t"+rs.getInt(6));
	}	
	}
public static void testFindById(int id)throws Exception{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","root");
	
	PreparedStatement pstmt=conn.prepareStatement("select * from marksheet where id=?");
	
	pstmt.setInt(1,id);
	
	ResultSet rs=pstmt.executeQuery();
	
	while(rs.next()) {
		System.out.print(
				rs.getInt(1));
		System.out.print("\t"+rs.getInt(2));
		System.out.print("\t"+rs.getString(3));
		System.out.print("\t"+rs.getInt(4));
		System.out.print("\t"+rs.getInt(5));
		System.out.println("\t"+rs.getInt(6));
	}	
	
	}
	
}
	


