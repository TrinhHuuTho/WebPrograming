package vn.iotstar.services.impl;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService {

	// Lay toan bo ham trong tang Dao
	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {

		UserModel user = this.findByUsername(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel findByUsername(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public boolean register(String username, String email, String password, String fullname) {
		UserModel existingUser = userDao.findByUserName(username);
		if (existingUser != null) {
			return false; 
		}
		UserModel newUser = new UserModel();
		newUser.setUsername(username);
		newUser.setEmail(email);
		newUser.setPassword(password); 
		newUser.setFullname(fullname);
		try {
	        userDao.insert(newUser);
	        return true;  
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;  
	    }
	}

	// Tìm người dùng qua email
    public UserModel findByEmail(String email) {
        return userDao.findByEmail(email);
    }
	
	public boolean resetPassword(String email, String newPassword, String confirmPassword) {
        // Kiểm tra nếu mật khẩu mới và xác nhận trùng khớp
        if (newPassword.equals(confirmPassword)) {
            userDao.resetPassword(email, newPassword); // Cập nhật mật khẩu trong DB
            return true;
        }
        return false;
    }
	
}
