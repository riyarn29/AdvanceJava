package in.co.rays.roughwork;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUser {
	public static void main(String[] args) throws Exception {
		// add();
		// update();
		// testDelete();
		// testFind();
		// testRead();
		// authenticate();
		// updatebypk();
		testsearch();

	}

	public static void add() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		UserBean bean = new UserBean();
		bean.setId(1);
		bean.setFirstName("akshay");
		bean.setLastName("l=khan");
		bean.setLoginId("78");
		bean.setPassword("kkk");
		bean.setDob(sdf.parse("29/01/2004"));
		bean.setAddress("mumbbai");
		UserModel model = new UserModel();

		UserBean existbean = new UserBean();
		existbean = model.findbylogin("78");
		if (existbean != null) {
			System.out.println("id exists");
		} else {
			model.add(bean);
		}

	}

	public static void update() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		UserBean bean = new UserBean();
		bean.setId(1);
		bean.setFirstName("akshay");
		bean.setLastName("kumar");
		bean.setLoginId("78@gmail.com");
		bean.setPassword("khiladi");
		bean.setDob(sdf.parse("29/01/1950"));
		bean.setAddress("mumbai");
		UserModel model = new UserModel();
		model.update(bean);
	}

	public static void testDelete() throws Exception {
		UserModel model = new UserModel();
		model.delete(10);
	}

	public static void testFind() throws Exception {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		// bean=model.findbypk(1);
		bean = model.findbylogin("@@1");
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
		} else {
			System.out.println("id not found");
		}
	}

	public static void testRead() throws Exception {
		UserModel model = new UserModel();
		model.read();
	}

	public static void authenticate() throws Exception {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		bean = model.authenticate("@@1", "tu mil mujhe");
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());

		} else {
			System.out.println("invalid");
		}
	}

	public static void updatebypk() throws Exception {

		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		bean = model.findbypk(2);
		bean.setLoginId("121@gmail.com");
		model.update(bean);

	}

	public static void testsearch() throws Exception {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		bean.setFirstName("r");
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		
		bean.setDob(sdf.parse("29-01-2003"));
		
		List list = model.search(bean, 1, 10);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
		}
	}
}