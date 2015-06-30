package br.com.AndroidMapWebServiceJson.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.AndroidMapWebServiceJson.factory.ConnectionFactory;
import br.com.AndroidMapWebServiceJson.model.User;


public class UserDAO extends ConnectionFactory{

	private String USER_TABLE = "user";
	private String ID = "id";
	private String NAME = "name";
	private String EMAIL = "email";
	private String PASSWORD = "password";

	private static UserDAO instance;
	
	public static UserDAO getInstance(){
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}
	
	public ArrayList<User> listAllUsers(){
		ArrayList<User> userList = new ArrayList<User>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			
			connection = createConnection();
			pstmt = connection.prepareStatement("SELECT * FROM "+USER_TABLE);
			
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()){
				User user = new User();
				user.setId(result.getInt(1));
				user.setName(result.getString(2));
				user.setEmail(result.getString(3));
				user.setPassword(result.getString(4));
				
				userList.add(user);
			}			
			
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
//	public boolean insert(User user){
//		
//		try {
//			Connection connection = SQLConector.getConnection();
//			
//			String query = "INSERT INTO "+USER_TABLE+" VALUES (null, ?, ?, ?)";
//			
//			PreparedStatement ppstm = (PreparedStatement) connection.prepareStatement(query);
//			ppstm.setString(1, user.getName());
//			ppstm.setString(2, user.getEmail());
//			ppstm.setString(3, user.getPassword());
//			ppstm.executeUpdate();
//		
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//		
//		return true;
//	}
	
//	public boolean delete(int id){
//		return delete(new User(id, "", "",""));
//	}
//	
//	public boolean delete(User user){
//		try {
//			Connection connection = SQLConector.getConnection();
//			
//			String query = "DELETE FROM "+USER_TABLE+" WHERE "+ID+" = ?";
//			
//			PreparedStatement ppstm = (PreparedStatement) connection.prepareStatement(query);
//			ppstm.setInt(1, user.getId());
//			ppstm.executeUpdate();
//		
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//		
//		return true;
//	}
//	
//	public boolean update(User user){
//		try {
//			Connection connection = SQLConector.getConnection();
//			
//			String query = "UPDATE "+USER_TABLE+" SET "+NAME+" = ?, "+EMAIL+" = ?, "+PASSWORD+" = ?, WHERE "+ID+" = ?";
//			
//			PreparedStatement ppstm = (PreparedStatement) connection.prepareStatement(query);
//			ppstm.setString(1, user.getName());
//			ppstm.setString(2, user.getEmail());
//			ppstm.setString(3, user.getPassword());
//			ppstm.setInt(4, user.getId());
//			ppstm.executeUpdate();
//		
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//		
//		return true;
//	}
	
	
	
//	public User findById(int id){
//		User user = null;
//		
//		try {
//			Connection connection = SQLConector.getConnection();
//			
//			String query = "SELECT * FROM "+USER_TABLE+" WHERE "+ID+" = ?";
//			
//			PreparedStatement ppstm = (PreparedStatement) connection.prepareStatement(query);
//			ppstm.setInt(1, id);
//			
//			ResultSet result = ppstm.executeQuery();
//			
//			if(result.next()){
//				user = new User();
//				user.setId(result.getInt(1));
//				user.setName(result.getString(2));
//				user.setEmail(result.getString(3));
//				user.setPassword(result.getString(4));
//			}			
//			
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return user;
//	}
	
}
