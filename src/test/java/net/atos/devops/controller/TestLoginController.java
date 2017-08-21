package net.atos.devops.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import net.atos.devops.model.Login;
import net.atos.devops.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = {AppConfig.class})
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
@WebAppConfiguration
public class TestLoginController {
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
    
	@Before
    public void setup() {
    	/*InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");*/
        
        //mockMvc = MockMvcBuilders.annotationConfigSetup(AppConfig.class).build();
    	/*mockMvc = MockMvcBuilders.standaloneSetup(loginController)
    			.setViewResolvers(viewResolver)
    			.build();*/
        
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

    @Test
    public void testInit() throws Exception {    	
        System.out.println("testInit............");
    	mockMvc.perform(get("/login"))
    		.andExpect(status().isOk())
    		.andExpect(forwardedUrl("WEB-INF/pages/login.jsp"));
    		
    }
    @Test
    public void testLoginSuccess() throws Exception {    	
    	System.out.println("testSubmit............");
    	Login login = new Login();
    	login.setUserName("admin");
    	login.setPassword("admin123");
    	
    	mockMvc.perform(post("/submit")
    			.flashAttr("login", login)
    			.param("userName","admin")
    			.param("password","admin123")
    			)
    		.andExpect(status().isOk())
    		.andExpect(forwardedUrl("WEB-INF/pages/success.jsp"));
    		
    }
    @Test
    public void testLoginFailure() throws Exception {    	
    	System.out.println("testLoginFailure............");
    	Login login = new Login();
    	login.setUserName("incorrect_username");
    	login.setPassword("incorrect_password");
    	
    	mockMvc.perform(post("/submit")
    			.flashAttr("login", login)
    			.param("userName","incorrect_username")
    			.param("password","incorrect_password")
    			)
    		.andExpect(status().isOk())
    		.andExpect(forwardedUrl("WEB-INF/pages/login.jsp"));
    		
    }
    @Test
    public void testValidateEmailSuccess() throws Exception {
    	mockMvc.perform(get("/validateEmail").param("email","binal.gadani@atos.net"))
    		.andExpect(status().isOk())
    		.andExpect(forwardedUrl("WEB-INF/pages/success.jsp"))
    		.andExpect(model().attributeExists("isEmailValid"))
    		.andExpect(model().attribute("isEmailValid",true));
    }
    @Test
    public void testValidateEmailFailure() throws Exception {
    	mockMvc.perform(get("/validateEmail").param("email","incorrect_email"))
    		.andExpect(status().isOk())
    		.andExpect(forwardedUrl("WEB-INF/pages/success.jsp"))
    		.andExpect(model().attributeExists("isEmailValid"))
    		.andExpect(model().attribute("isEmailValid",false));
    }

}
