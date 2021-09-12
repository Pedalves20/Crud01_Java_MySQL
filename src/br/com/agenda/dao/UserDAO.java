package br.com.agenda.dao;

import java.util.List;

import br.com.agenda.model.User;

public interface UserDAO {

	void insertUser(User user);
	
	void deleteUser(User user);
	
	void updateUser(User user);
	
	List<User> getAllUsers();
	
}