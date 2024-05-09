package in.co.rays.roughwork;

//import java.sql.Connection;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//
//import sun.security.jca.GetInstance;
//
//public final class  JDBCDataSource {
//	
//	private static JDBCDataSource datasource;
//	
//	private ComboPooledDataSource cpds=null;
//	
//	private JDBCDataSource() {
//		
//	}
//	public static JDBCDataSource getInstance()throws Exception{
//		if(datasource==null) {
//			datasource=new JDBCDataSource();
//			datasource.cpds=new ComboPooledDataSource();
//			try {
//			datasource.cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			datasource.cpds.setJdbcUrl("jdbc:mysql://localhost:3306/employee1");
//			datasource.cpds.setUser("root");
//			datasource.cpds.setPassword("root");
//			datasource.cpds.setInitialPoolSize(5);
//			datasource.cpds.setAcquireIncrement(5);
//			datasource.cpds.setMaxPoolSize(30);
//		} 
//		return datasource;
//	}
//	
//	public static Connection getConnection()throws Exception{
//		return getInstance().cpds.getConnection();
//				}
//	
//	public static 
//}
