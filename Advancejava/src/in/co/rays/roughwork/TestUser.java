package in.co.rays.roughwork;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUser {
public static void main(String[] args) throws Exception{
//testadd();
//testupdate();
//	testRead();
	//testdelete();
//testSearch();
//testFind();
//testAuth();
	testUpdatepk();
	
}
	public static void testadd()throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		UserModel model=new UserModel();
		UserBean bean=new UserBean();
		bean.setId(1);
		bean.setFirstName("ruhi");
		bean.setLastName("gupta");
		bean.setLoginId("$@gmail");
		bean.setPassword("oo");
		bean.setDob(sdf.parse("29/01/2003"));
		bean.setAddress("lahore");
		
		UserBean existbean=new UserBean();
	existbean =	model.findbylogin("$@gmail");
	if(existbean!=null) {
		System.out.println("data found");
	} else {
		model.add(bean);
	}
	}
	
	public static void testupdate()throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		UserModel model=new UserModel();
		UserBean bean=new UserBean();
		bean.setId(8);
		bean.setFirstName("khushi");
		bean.setLastName("gupta");
		bean.setLoginId("$@nmail");
		bean.setPassword("oooo");
		bean.setDob(sdf.parse("29/01/2004"));
		bean.setAddress("lahore");

		model.update(bean);
}


public static void testRead()throws Exception{
	UserModel model=new UserModel();
	model.read();
}

public static void testdelete()throws Exception{
	UserModel model=new UserModel();
	model.delete(7);
}

public static void testSearch()throws Exception{
	UserModel model=new UserModel();
	UserBean bean=new UserBean();
	bean.setFirstName("r");
	List list=model.search(bean,1,3);
	Iterator it=list.iterator();
	while(it.hasNext()) {
	bean=	(UserBean) it.next();
	System.out.println(bean.getId());
	System.out.println(bean.getFirstName());
	System.out.println(bean.getLastName());
	System.out.println(bean.getLoginId());
	System.out.println(bean.getPassword());
	System.out.println(bean.getDob());
	System.out.println(bean.getAddress());
	}
}

public static void testFind()throws Exception{
	UserModel model=new UserModel();
	UserBean bean=new UserBean();
bean=	model.findbypk(1);
if(bean!=null) {
	System.out.println(bean.getId());
	System.out.println(bean.getFirstName());
	System.out.println(bean.getLastName());
	System.out.println(bean.getLoginId());
	System.out.println(bean.getPassword());
	System.out.println(bean.getDob());
	System.out.println(bean.getAddress());
} else {
	System.out.println("id not found");
}
}

public static void testAuth()throws Exception{
	UserModel model=new UserModel();
	UserBean bean=new UserBean();
bean=	model.authenticate("$@gmail", "o");
if(bean!=null) {
	System.out.println(bean.getId());
	System.out.println(bean.getFirstName());
	System.out.println(bean.getLastName());
	System.out.println(bean.getLoginId());
	System.out.println(bean.getPassword());
	System.out.println(bean.getDob());
	System.out.println(bean.getAddress());
} else {
	System.out.println("password invalid");
}
}

public static void testUpdatepk()throws Exception{
	UserModel model=new UserModel();
	UserBean bean=new UserBean();
	bean=model.findbypk(5);
	bean.setFirstName("oye");
	model.update(bean);
}
}