package in.co.rays.user;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
public class UserTest {
public static void main(String[] args) throws Exception {
	testAdd();
//testSearch();
	//testFind();
//	testUpdate();
//	testDelete();
	//readAll();
	//testUpdatepk();
//testAuth();
	
}
public static void testAdd()throws Exception{
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	UserBean bean=new UserBean();
	bean.setId(1);
	bean.setFirstName("sheesh");
	bean.setLastName("rana");
	bean.setLoginId("@hotmaill");
	bean.setPassword("122");
	bean.setDob(sdf.parse("28/01/2005"));
	bean.setAddress("indore");
	
	
	
	UserModel model=new UserModel();
	UserBean existBean=new UserBean();
	
	existBean=model.findByLogin("@hotmaill");
	
	if(existBean !=null) {
		System.out.println("id exists");
	} else {
	model.add(bean);
	}
}

public static void testUpdate()throws Exception{
	
	UserBean bean=new UserBean();
	bean.setId(2);
	bean.setFirstName("siddhu");
	bean.setLastName("rana");
	bean.setLoginId("siddhu@gmail.com");
	bean.setPassword("1234");
	bean.setDob(new Date());
	bean.setAddress("indore");
	
	UserModel model=new UserModel();
	model.update(bean);
}

public static void testDelete() throws Exception {

	UserModel model=new UserModel();
	model.delete(3);
	
}


public static void readAll()throws Exception{
	UserModel model=new UserModel();
	model.readAll();
}


public static void testSearch()throws Exception{
	

SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	UserBean bean= new UserBean();

bean.setDob(sdf.parse("2004-01-14"));
bean.setFirstName("r");
UserModel model =new UserModel();
List list =model.search(bean,1,5);
Iterator it=list.iterator();
while(it.hasNext()) {
	bean=(UserBean) it.next();
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
	UserModel model =new UserModel();
	UserBean bean=new UserBean();
	bean =model.findPk(1);
	if(bean!=null) {
		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getLoginId());
		System.out.println(bean.getPassword());
		System.out.println(bean.getDob());
		System.out.println(bean.getAddress());
	}
	else {
		System.out.println("not ");
	}
}

public static void testUpdatepk()throws Exception{
	UserModel model=new UserModel();
	UserBean bean=new UserBean();
	bean=model.findPk(4);
	bean.setLastName("dd");
	
	model.update(bean);
}

public static void testAuth()throws Exception{
	UserModel model=new UserModel();
	UserBean bean=new UserBean();
bean=	model.authenticate("@hotmaill","122");
if(bean!=null) {
	System.out.println(bean.getId());
	System.out.println(bean.getFirstName());
	System.out.println(bean.getLastName());
	System.out.println(bean.getLoginId());
	System.out.println(bean.getPassword());
	System.out.println(bean.getDob());
	System.out.println(bean.getAddress());
}
else {
	System.out.println("invalid password");
}
}
}


