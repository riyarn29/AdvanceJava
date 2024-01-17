package in.co.rays.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;



public class Metadata {
	public static void main(String[] args) throws Exception{
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1","root","root");
		 Statement stmt=conn.createStatement();
		
		ResultSet rs= stmt.executeQuery("select * from marksheet");
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		System.out.println("Catalogue name = "+rsmd.getCatalogName(1));
		
		System.out.println("Table name = "+rsmd.getTableName(1));
		
		int columnCount = rsmd.getColumnCount();
		
		System.out.println("Total column = "+columnCount);
		
		for(int i=1;i<=columnCount; i++) {
			
			System.out.println("Column = " +i);
			System.out.println("Label = "+rsmd.getColumnLabel(i));
			System.out.println("Name = "+rsmd.getColumnName(i));
			System.out.println("Type = "+rsmd.getColumnTypeName(i));
			System.out.println("Size = "+rsmd.getColumnDisplaySize(i));
			System.out.println("Precision = "+rsmd.getPrecision(i));
			System.out.println();
			
		}
		
		
		
		
	}
	
}
