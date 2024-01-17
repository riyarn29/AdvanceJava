package in.co.rays.marksheet;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet {
public static void main(String[] args) throws Exception{
	//testAdd();
//	testUpdate();
	//testDelete();
	//testRead();
	testFindByPk();
	//testSearch();

	
	
}
public static void testAdd() throws Exception {
	
	MarksheetBean bean=new MarksheetBean();
	
	bean.setId(1);
	bean.setRollNo(112);
	bean.setName("bc");
	bean.setPhysics(15);
	bean.setChemistry(3);
	bean.setMaths(44);
		
	MarksheetModel model= new MarksheetModel();
	model.add(bean);
}


public static void testUpdate()throws Exception{
	MarksheetBean bean =new MarksheetBean();
	bean.setId(10);
	bean.setRollNo(110);
	bean.setChemistry(41);
	bean.setMaths(31);
	bean.setPhysics(11);
	bean.setName("riyaaaaa");

	MarksheetModel model = new MarksheetModel();
	model.update(bean);
}


public static void testDelete() throws Exception{
	MarksheetModel model=new MarksheetModel();
	model.delete(11);
}

public static void testRead()throws Exception{
	MarksheetModel model= new MarksheetModel();
	model.readAll();
}

public static void testFindByPk()throws Exception{
	MarksheetModel model= new MarksheetModel();
	MarksheetBean bean=model.findByPk(100);
	if(bean!=null ) {
	System.out.println(bean.getId());
	System.out.println(bean.getRollNo());
	System.out.println(bean.getPhysics());
	System.out.println(bean.getName());
	System.out.println(bean.getChemistry());
	System.out.println(bean.getMaths());
	} else {
		System.out.println("id doesnt exist");
	}
	
}

public static void testSearch()throws Exception{
	MarksheetModel model = new MarksheetModel();
	MarksheetBean bean=new MarksheetBean();
	bean.setName("r");
//bean.setRollNo(101);

	List list=model.search(bean, 1, 5);
	Iterator it=list.iterator();
	while(it.hasNext()) {
	 bean= (MarksheetBean) it.next();
	System.out.print(bean.getId());
	System.out.print("\t"+bean.getRollNo());
	System.out.print("\t"+bean.getName());
	System.out.print("\t"+bean.getPhysics());
	System.out.print("\t"+bean.getChemistry());
	System.out.println("\t"+bean.getMaths());
}
}
}