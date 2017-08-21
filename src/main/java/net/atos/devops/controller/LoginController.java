package net.atos.devops.controller;

import net.atos.devops.model.Login;
import net.atos.devops.model.User;
import net.atos.devops.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.log4j.Logger;

@Controller
public class LoginController {
	
	final static Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	UserService userServiceImpl;
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(Model model) {
    	logger.info("init");
    	String viewName="login";
        model.addAttribute("msg", "Please Enter Your Login Details");
        return viewName;
    }
 
    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("login") Login login) {
    	logger.info("submit.."+login.getUserName() +","+login.getPassword());
    	String viewSuccessName="success";
    	String viewLoginName="login";
    	User user = new User();
    	user.setUsername(login.getUserName());
    	user.setPassword(login.getPassword());
    	//Call service method to authenticate
    	boolean isUserValid = userServiceImpl.authenticate(user);
    	if(isUserValid){    	
    		model.addAttribute("msg", "Welcome " + login.getUserName());
            return viewSuccessName;
        } else {
            model.addAttribute("error", "Invalid user. Please enter details again.");
            return viewLoginName;
        }
    }
    @RequestMapping(value = "/validateEmail", method = RequestMethod.GET)
    public String validateEmail(Model model, @RequestParam("email") String email){
    	logger.info("Validate email..."+email);
    	String viewSuccessName="success";
    	boolean isValidEmail = userServiceImpl.isValidEmailAddress(email);
    	if(isValidEmail){
    		model.addAttribute("emailStatus", "[" + email +"] Valid email address!");
    		model.addAttribute("isEmailValid", true);
    	}
    	else
    	{
    		model.addAttribute("emailStatus", "[" + email +"] Invalid email address!");
    		model.addAttribute("isEmailValid", false);
    	}
    	return viewSuccessName;
    }
    
}