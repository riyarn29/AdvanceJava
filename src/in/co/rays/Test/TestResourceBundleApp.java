package in.co.rays.Test;

import java.util.ResourceBundle;

public class TestResourceBundleApp {

	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");
		
		System.out.println(rb.getString("greetings"));
		
		System.out.println(rb.getString("hindi"));
		
		System.out.println(rb.getString("spanish"));
	}
}
