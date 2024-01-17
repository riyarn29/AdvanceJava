package in.co.rays.roughwork;

import java.util.Iterator;
import java.util.List;
public class TestMarksheet {
	public static void main(String[] args) throws Exception {
//testAdd();

//testUpdate();
		//testDelete();
		//testRead();
	//	testFind();
		testSearch();
	//	testPkupdate();
		//testFind();
		
	}
	public static void testAdd() throws Exception {
		MarksheetModel model=new MarksheetModel();
		MarksheetBean bean=new MarksheetBean();
		bean.setName("reha");
		bean.setId(17);
		bean.setPhysics(23);
		bean.setChemistry(32);
		bean.setMaths(90);
		bean.setRollNo(67);
		model.add(bean);
		
	}
	
	
	public static void testUpdate()throws Exception{

		MarksheetBean bean=new MarksheetBean();
		MarksheetModel model=new MarksheetModel();
		bean.setName("rehan");
		bean.setId(17);
		bean.setPhysics(12);
		bean.setChemistry(32);
		bean.setMaths(90);
		bean.setRollNo(67);
		model.update(bean);
}
	
	public static void testDelete()throws Exception{


		
		MarksheetModel model=new MarksheetModel();
		model.delete(17);
}
	
	
	public static void testRead()throws Exception{

		MarksheetModel model=new MarksheetModel();
		model.read();
		
	}
	
	
	public static void testFind()throws Exception{
		MarksheetModel model=new MarksheetModel();
		MarksheetBean bean=	model.findPK(2);
		if(bean!=null) {
			System.out.println(bean.getId());
			System.out.print("\t"+bean.getRollNo());
			System.out.print("\t"+bean.getName());
			System.out.print("\t"+bean.getPhysics());
			System.out.print("\t"+bean.getChemistry());
			System.out.println("\t"+bean.getMaths());
		} else {
			System.out.println("not exists");
		}
		
		
	}
	
	
	public static void testSearch()throws Exception{
		MarksheetModel model=new MarksheetModel();
	MarksheetBean bean=new MarksheetBean();
	bean.setName("r");
	bean.setRollNo(103);
	
List list=model.search(bean,1,3);
Iterator it=list.iterator();
while(it.hasNext()) {
bean=	(MarksheetBean) it.next();
System.out.println(bean.getId());
System.out.print("\t"+bean.getRollNo());
System.out.print("\t"+bean.getName());
System.out.print("\t"+bean.getPhysics());
System.out.print("\t"+bean.getChemistry());
System.out.println("\t"+bean.getMaths());


}
	}
	
	
	public static void testPkupdate()throws Exception{
		MarksheetModel model=new MarksheetModel();
		MarksheetBean bean=new MarksheetBean();
	//bean=model.findbypk(10);
		bean.setPhysics(44);
		model.update(bean);
	}
}