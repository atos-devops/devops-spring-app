package net.atos.devops.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestUser {
	@Test
	public void testGetUsername(){
		User user = new User();
		user.setPassword("admin123");
		user.setUsername("admin");
		
		assertEquals(user.getUsername(),"admin");		
	}
	@Test
	public void testSetUsername(){
		User user = new User();
		user.setPassword("admin123");
		user.setUsername("admin");
		
		assertEquals(user.getUsername(),"admin");		
	}
	@Test
	public void testGetPassword(){
		User user = new User();
		user.setPassword("admin123");
		user.setUsername("admin");
		
		assertEquals(user.getPassword(),"admin123");		
	}
	@Test
	public void testSetPassword(){
		User user = new User();
		user.setPassword("admin123");
		user.setUsername("admin");
		
		assertEquals(user.getPassword(),"admin123");		
	}
}
