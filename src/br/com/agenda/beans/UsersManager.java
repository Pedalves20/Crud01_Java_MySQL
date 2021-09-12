package br.com.agenda.beans;

import java.util.List;

import br.com.agenda.dao.UserDAOImpl;
import br.com.agenda.model.User;

public class UsersManager {

	public static void main(String[] args) {

		//inserir();
		selecionar();
	}
	
	private static void inserir() {
		UserDAOImpl dao = new UserDAOImpl();
		User user = new User();
		user.setUsername("Pedro");
		user.setFullname("da Silva");
		user.setEmail("pedalves27@gmail.com");
		user.setPassword("ASDFG");
		dao.insertUser(user);		
	}

	private static void alterar() {
		UserDAOImpl dao = new UserDAOImpl();
		User user = new User();
		user.setId(5);
		user.setUsername("Pedro");
		user.setFullname("da Silva");
		user.setEmail("pedalves24@gmail.com");
		user.setPassword("ASDFG");
		dao.insertUser(user);		
	}
	
	private static void deletar() {		
		UserDAOImpl dao = new UserDAOImpl();
		User user = new User();
		user.setId(5);
		dao.updateUser(user);
	}
	
	private static void selecionar() {		
		UserDAOImpl dao = new UserDAOImpl();
		dao.getAllUsers();
	}
	
}