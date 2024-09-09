package vn.HuuTho.Dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.HuuTho.Configs.DBConnectSQL;
import vn.HuuTho.Dao.IUserDao;
import vn.HuuTho.Models.UserModel;

public class UserDaoImpl extends DBConnectSQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public List<UserModel> findAll() {
	    String sql = "SELECT * FROM GetUser";
	    List<UserModel> list = new ArrayList<>();
	    
	    try {
	        conn = super.getConnection();
	        
	        if (conn == null && conn.isClosed()) {
	            System.out.println("Kết nối tới cơ sở dữ liệu thất bại.");
	            return list;
	        }

	        ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            UserModel user = new UserModel(
	                rs.getInt("id"), 
	                rs.getString("username"), 
	                rs.getString("pass"), 
	                rs.getString("img"), 
	                rs.getString("fullname")
	            );
	            list.add(user);
	        }

	        return list; 
	    } catch (SQLException e) {
	        System.out.println("Lỗi SQL: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null && !conn.isClosed()) conn.close();
	        } catch (SQLException e) {
	            System.out.println("Lỗi khi đóng tài nguyên: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    return null;
	}




	@Override
	public UserModel findById(int id) {
		String sql = "select * from GetUser where id = ?";
	    
	    try {
	        conn = super.getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            return new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("pass"), rs.getString("img"), rs.getString("fullname"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO Table_1(id, username, pass, img, fullname) VALUES (?,?,?,?,?)";
		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, (user.getUsername() != null && !user.getUsername().isEmpty()) ? user.getUsername() : null);
	        ps.setString(3, (user.getPassword() != null && !user.getPassword().isEmpty()) ? user.getPassword() : null);
	        ps.setString(4, (user.getImages() != null && !user.getImages().isEmpty()) ? user.getImages() : null);
	        ps.setString(5, (user.getFullname() != null && !user.getFullname().isEmpty()) ? user.getFullname() : null);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();
		List<UserModel> list = userDao.findAll();
		for (UserModel user : list) {
			System.out.println(user);
		}
	}
	
//	public static void main(String[] args) {
//    UserDaoImpl userDao = new UserDaoImpl();
//    int idToFind = 1; 
//    UserModel user = userDao.findById(idToFind);
//    
//    if (user != null) {
//        System.out.println("Thông tin người dùng với ID " + idToFind + ":");
//        System.out.println(user);
//    } else {
//        System.out.println("Không tìm thấy người dùng với ID " + idToFind + ".");
//    }
//}

//public static void main(String[] args) {
//    UserDaoImpl userDao = new UserDaoImpl();
//    UserModel newUser = new UserModel(4, "Van A", "1080", "", "Nguyen VAn A");
//    userDao.insert(newUser);
//    System.out.println("Đã chèn người dùng mới vào cơ sở dữ liệu.");
//}

}

