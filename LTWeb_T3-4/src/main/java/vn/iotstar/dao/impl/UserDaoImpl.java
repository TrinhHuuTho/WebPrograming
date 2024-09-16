package vn.iotstar.dao.impl;

import java.lang.classfile.TypeAnnotation.ThrowsTarget;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectSQLServer;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.models.UserModel;

public class UserDaoImpl extends DBConnectSQLServer implements IUserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {

		String sql = "SELECT * FROM GetUser";
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			conn = new DBConnectSQLServer().getConnection();
			ps = conn.prepareStatement(sql);			
			rs = ps.executeQuery();
			while (rs.next()) {						
				list.add(new UserModel(
					rs.getInt("id"),				
					rs.getString("username"),
					rs.getString("password"),
					rs.getString("images"),
					rs.getString("fullname"),
					rs.getString("email"),								
					rs.getString("phone"),
					rs.getInt("roleid"),
					rs.getDate("createDate")));				
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM GetUser WHERE id = ? ";
		try {
			conn = new DBConnectSQLServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setImages(rs.getString("images"));
				user.setEmail(rs.getString("email"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedate(rs.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user){

		String sql = "INSERT INTO GetUser(id, username, password, images, fullname, email, phone, roleid, createDate) VALUES (?, ?, ?, ?, ?,?,?,?,?)";
			
		try {
			conn = new DBConnectSQLServer().getConnection(); //kết nối database 
			ps = conn.prepareStatement(sql);//ném câu sql vào cho thực thi
			
			 ps.setInt(1, user.getId());
		        ps.setString(2, user.getUsername());
		        ps.setString(3, user.getPassword());
		        ps.setString(4, user.getImages());
		        ps.setString(5, user.getFullname());
		        ps.setString(6, user.getEmail());
		        ps.setString(7, user.getPhone());
		        ps.setInt(8, user.getRoleid());
		        ps.setDate(9, user.getCreatedate());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM GetUser WHERE username = ? ";
		
		try {
			conn = new DBConnectSQLServer().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFullname(rs.getString("fullname"));
				user.setImages(rs.getString("images"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setCreatedate(rs.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {

		IUserDao userDao = new UserDaoImpl();

//		// Insert a new user
//	    userDao.insert(new UserModel(4,
//	    		"Thọ", "2508", "qwerty",
//	    		"Trịnh Hửu Thọ", "aido@gmail.com",
//	    		"0123456789", 2, 
//	    		new java.sql.Date(System.currentTimeMillis())));
//		
		// findAll
		List<UserModel> list = userDao.findAll();
		if (!list.isEmpty()) {
			System.out.println("Users List:");
			for (UserModel user : list) {
				System.out.println(user);
			}
		} else {
			System.out.println("No users found.");
		}
//
//		// findById
//		int testId = 3;
//		UserModel user = userDao.findById(testId);
//		if (user != null) {
//			System.out.println("\nUser found by ID: " + user);
//		} else {
//			System.out.println("\nUser with ID " + testId + " not found.");
//		}
//
//		// findByUserName
//		String Username = "Tho";
//		UserModel userByUsername = userDao.findByUserName(Username);
//		if (userByUsername != null) {
//			System.out.println("\nUser found by username: " + userByUsername);
//		} else {
//			System.out.println("\nUser with username '" + Username + "' not found.");
//		}

	}

}
