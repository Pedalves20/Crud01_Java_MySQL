package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.model.User;

public class UserDAOImpl implements UserDAO {

	String jdbcURL = "jdbc:mysql://localhost:3306/sampledb";
	String username = "root";
	String password = "pedrodev110800$";

	@Override
	public void insertUser(User user) {

		try {

			Connection connection = DriverManager.getConnection(jdbcURL, username, password);

			String sql = "INSERT INTO users (username, email, fullname, password)" + "VALUE ('" + user.getUsername()
					+ "', '" + user.getEmail() + "', '" + user.getFullname() + "', '" + user.getPassword() + "')";

			Statement statement = connection.createStatement();

			int rows = statement.executeUpdate(sql);

			if (rows > 0) {
				System.out.println("A new user has been inserted succesfully.");
			}

			connection.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void deleteUser(User user) {

		try {

			Connection connection = DriverManager.getConnection(jdbcURL, username, password);

			String sql = "DELETE INTO user (username, email, fullname, password)" + "VALUE ('" + user.getUsername()
					+ "', '" + user.getEmail() + "', '" + user.getFullname() + "', '" + user.getPassword() + "')";

			Statement statement = connection.createStatement();

			int rows = statement.executeUpdate(sql);

			if (rows > 0) {
				System.out.println("A new user has been deleted succesfully.");
			}

			connection.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void updateUser(User user) {

		try {

			Connection connection = DriverManager.getConnection(jdbcURL, username, password);

			String sql = "UPDATE INTO user (username, email, fullname, password)" + "VALUE ('" + user.getUsername()
					+ "', '" + user.getEmail() + "','" + user.getFullname() + "','" + user.getPassword() + "')";

			Statement statement = connection.createStatement();

			int rows = statement.executeUpdate(sql);

			if (rows > 0) {
				System.out.println("A new user has been uptaded succesfully.");
			}

			connection.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public List<User> getAllUsers() {

		List<User> listUsuers = new ArrayList<User>();

		try {

			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			String sql = "select * from users;";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				System.out.print("user_id: " + rs.getInt("user_id"));
				System.out.print(", username: " + rs.getString("username"));
				System.out.print(", fullname: " + rs.getString("fullname"));
				System.out.println(", email: " + rs.getString("email"));
				System.out.println(", password: " + rs.getString("password"));
			}
			connection.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return listUsuers;
	}

}