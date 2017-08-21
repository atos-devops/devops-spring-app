package net.atos.devops.service;

import org.springframework.stereotype.Service;

import net.atos.devops.model.User;
import org.apache.log4j.Logger;
@Service
public class UserServiceImpl implements UserService {
	final static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	public boolean authenticate(User user) {
		logger.info("UserServiceImpl.authenticate():::Start");
		if (user != null && user.getUsername() != null && user.getPassword() != null) {
            if (user.getUsername().equals("admin") && user.getPassword().equals("admin123")) {
                return true;
            }
        }
		
//		System.out.println("Hi");
		
//		System.out.println("User getting authenticated is : "+user.getUsername().substring(1));
		
		return false;        
	}
	@Override
	public boolean isValidEmailAddress(String email) {
		logger.info("UserServiceImpl.isValidEmailAddress("+email+")");
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
