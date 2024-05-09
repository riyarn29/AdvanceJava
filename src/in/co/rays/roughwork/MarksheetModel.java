package in.co.rays.roughwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.util.JDBCDataSource;


public class MarksheetModel {
	
	public static Integer nextpk()throws Exception{
		
		int pk=0;
Connection conn= JDBCDataSource.getConnection();
		
		PreparedStatement pstmt= conn.prepareStatement("select max(id) from marksheet");
		ResultSet rs= pstmt.executeQuery();
		while(rs.next()) {
			pk= rs.getInt(1);
		}
		return pk+1;
	}
	
	
	
	public void add(MarksheetBean bean)throws Exception{
		
	
		Connection conn= JDBCDataSource.getConnection();
		
		PreparedStatement pstmt= conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");
		int pk= nextpk();
		pstmt.setInt(1,pk);
		pstmt.setInt(2,bean.getRollNo());
		pstmt.setString(3,bean.getName());
		pstmt.setInt(4,bean.getPhysics());
		pstmt.setInt(5,bean.getChemistry());
		pstmt.setInt(6,bean.getMaths());
	
		int i= pstmt.executeUpdate();
		System.out.println("data inserted="+i);
}
	
public void update(MarksheetBean bean)throws Exception{
		
		Connection conn= JDBCDataSource.getConnection();
		
		PreparedStatement pstmt= conn.prepareStatement("update marksheet set roll_no=?,name=?,physics=?,chemistry=?,maths=? where id=?");
		
		pstmt.setInt(1,bean.getRollNo());
		pstmt.setString(2,bean.getName());
		pstmt.setInt(3,bean.getPhysics());
		pstmt.setInt(4,bean.getChemistry());
		pstmt.setInt(5,bean.getMaths());
		pstmt.setInt(6,bean.getId());
		
		int i=pstmt.executeUpdate();
		System.out.println("data updated="+i);
		
}


public void delete(int id)throws Exception{
	
	Connection conn= JDBCDataSource.getConnection();
	
	PreparedStatement pstmt= conn.prepareStatement("delete from marksheet where id=?");
	pstmt.setInt(1,id);
	
	int i=pstmt.executeUpdate();
	System.out.println("data deleted="+i);
	
}

public void read()throws Exception{
	
	Connection conn= JDBCDataSource.getConnection();
	
	PreparedStatement pstmt= conn.prepareStatement("select * from marksheet");

	ResultSet rs= pstmt.executeQuery();
	while(rs.next()) {
		
		System.out.println("\t"+rs.getInt(1));
		System.out.println("\t"+rs.getInt(2));
		System.out.println("\t"+rs.getString(3));
		System.out.println("\t"+rs.getInt(4));
		System.out.println("\t"+rs.getInt(5));
		System.out.println("\t"+rs.getInt(6));
	}
}

public MarksheetBean findbypk(int id)throws Exception{
	
	Connection conn= JDBCDataSource.getConnection();
	
	PreparedStatement pstmt= conn.prepareStatement("select * from marksheet where id=?");
	
	pstmt.setInt(1,id);
	
	ResultSet rs= pstmt.executeQuery();
	MarksheetBean bean =null;
	while(rs.next()) {
		bean=new MarksheetBean();
		bean.setId(rs.getInt(1));
		bean.setRollNo(rs.getInt(2));
		bean.setName(rs.getString(3));
		bean.setPhysics(rs.getInt(4));
		bean.setChemistry(rs.getInt(5));
		bean.setMaths(rs.getInt(6));
	}
	return bean;
}

public List search(MarksheetBean bean,int pageNo,int pageSize)throws Exception{
	
	Connection conn= JDBCDataSource.getConnection();
	
	StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");
	if(bean!=null) {
		if(bean.getName()!=null && bean.getName().length()>0) {
			sql.append(" and name like '"+bean.getName()+"%'");
		}
		if(bean.getRollNo()>0) {
			sql.append(" and roll_no="+bean.getRollNo());
		}
		
	}
	
	if(pageSize>0) {
		pageNo=(pageNo-1)*pageSize;
		sql.append(" limit "+pageNo+","+pageSize);
	}
	
	
	
	PreparedStatement pstmt= conn.prepareStatement(sql.toString());
	ResultSet rs= pstmt.executeQuery();
	List list =new ArrayList();
	while(rs.next()) {
		 bean= new MarksheetBean();
		bean.setId(rs.getInt(1));
		bean.setRollNo(rs.getInt(2));
		bean.setName(rs.getString(3));
		bean.setPhysics(rs.getInt(4));
		bean.setChemistry(rs.getInt(5));
		bean.setMaths(rs.getInt(6));
		list.add(bean);
	}
		return list;
	}


}