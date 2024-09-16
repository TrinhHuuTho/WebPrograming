package vn.iotstar.services.impl;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.models.UserModel;
import vn.iotstar.services.IUserService;

public class UserService implements IUserService{

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
	public void insert(UserModel newuser) {
		// TODO Auto-generated method stub
		
	}

}
