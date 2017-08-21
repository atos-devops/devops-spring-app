package net.atos.devops.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import net.atos.devops.config.AppConfig;
import net.atos.devops.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TestUserService {
	
	@Autowired
    UserService userServiceImpl;

	@Test
    public void testAuthenticateSuccess() {

        //assert correct type/impl
        assertThat(userServiceImpl, instanceOf(UserService.class));
        
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin123");
        
        //assert true
        assertThat(userServiceImpl.authenticate(user), is(true));

    }
	@Test
    public void testAuthenticateFailure() {

        //assert correct type/impl
        assertThat(userServiceImpl, instanceOf(UserService.class));
        
        User user = new User();
        user.setUsername("incorrect_username");
        user.setPassword("incorrect_password");
        
        //assert true
        assertThat(userServiceImpl.authenticate(user), is(false));

    }
	@Test
    public void testValidateEmailSuccess() {

        //assert true
        assertThat(userServiceImpl.isValidEmailAddress("ram.k@atos.net"), is(true));

    }
	@Test
    public void testValidateEmailFailure() {

        //assert true
        assertThat(userServiceImpl.isValidEmailAddress("invalid_email_address"), is(false));

    }
}
