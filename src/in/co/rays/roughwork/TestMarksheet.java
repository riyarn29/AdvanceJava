package in.co.rays.roughwork;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet {
	public static void main(String[] args) throws Exception {
//testAdd();
	//	testUpdate();
	//	testDelete();
		//testfind();
		testSearch();
		
	}
	
	public static void testAdd()throws Exception{
		MarksheetBean bean= new MarksheetBean();
		bean.setId(1);
bean.setRollNo(121);
bean.setName("yessss");
bean.setPhysics(12);
bean.setChemistry(13);
bean.setMaths(44);

MarksheetModel model= new MarksheetModel();
model.add(bean);
	}
	
	public static void testUpdate()throws Exception{
		MarksheetBean bean= new MarksheetBean();
		bean.setId(19);
bean.setRollNo(119);
bean.setName("yess");
bean.setPhysics(12);
bean.setChemistry(13);
bean.setMaths(44);
MarksheetModel model= new MarksheetModel();
model.update(bean);
	}
	
	public static void testDelete()throws Exception{
		MarksheetModel model= new MarksheetModel();
		model.delete(19);
	}
	
	public static void testfind()throws Exception{
		MarksheetModel model= new MarksheetModel();
		MarksheetBean bean= new MarksheetBean();
	bean=	model.findbypk(4);
	if(bean!=null) {
		System.out.println(bean.getId());
		System.out.println(bean.getRollNo());
		System.out.println(bean.getName());
		System.out.println(bean.getPhysics());
		System.out.println(bean.getChemistry());
		System.out.println(bean.getMaths());
	} else {
		System.out.println("id not found");
	}
	
	}
	
	public static void testSearch()throws Exception{
		MarksheetModel model= new MarksheetModel();
		MarksheetBean bean= new MarksheetBean();
		bean.setName("r");
		bean.setRollNo(103);
		List list= model.search(bean,1,5);
		Iterator it = list.iterator();
		while(it.hasNext()) {
		bean=	(MarksheetBean) it.next();
		System.out.print(bean.getId());
		System.out.print("\t"+bean.getRollNo());
		System.out.print("\t"+bean.getName());
		System.out.print("\t"+bean.getPhysics());
		System.out.print("\t"+bean.getChemistry());
		System.out.println("\t"+bean.getMaths());
		
		}
		
	
	}
}