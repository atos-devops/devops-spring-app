package net.atos.devops.service;

import net.atos.devops.model.User;

public interface UserService {
	public boolean authenticate(User user);
	public boolean isValidEmailAddress(String email);
}
