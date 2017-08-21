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
public class TestCounterController {
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
    
	@Before
    public void setup() {
    	/*InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        */
        //mockMvc = MockMvcBuilders.annotationConfigSetup(AppConfig.class).build();
    	/*mockMvc = MockMvcBuilders.standaloneSetup(loginController)
    			.setViewResolvers(viewResolver)
    			.build();*/
        
        mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

    @Test
    public void testStartCalculator() throws Exception {    	
        System.out.println("testStartCalculator............");
    	mockMvc.perform(get("/calculator"))
    		.andExpect(status().isOk())
    		.andExpect(forwardedUrl("WEB-INF/pages/calculator.jsp"));
    		
    }
    @Test
    public void testIncrementCounter() throws Exception {    	
        System.out.println("testIncrementCounter............");
    	mockMvc.perform(get("/counter"))
    		.andExpect(status().isOk())
    		.andExpect(forwardedUrl("WEB-INF/pages/counter.jsp"))
    		.andExpect(model().attributeExists("message"))
    		.andExpect(model().attribute("message","Welcome"))
    		.andExpect(model().attributeExists("counter"));    		
    }
}
