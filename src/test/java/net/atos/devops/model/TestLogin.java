package net.atos.devops.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestLogin {
	@Test
	public void testGetUserName(){
		Login login = new Login();
		login.setPassword("admin123");
		login.setUserName("admin");
		
		assertEquals(login.getUserName(),"admin");		
	}
	@Test
	public void testSetUserName(){
		Login login = new Login();
		login.setPassword("admin123");
		login.setUserName("admin");
		
		assertEquals(login.getUserName(),"admin");		
	}
	@Test
	public void testGetPassword(){
		Login login = new Login();
		login.setPassword("admin123");
		login.setUserName("admin");
		
		assertEquals(login.getPassword(),"admin123");		
	}
	@Test
	public void testSetPassword(){
		Login login = new Login();
		login.setPassword("admin123");
		login.setUserName("admin");
		
		assertEquals(login.getPassword(),"admin123");		
	}
}
