package vn.HuuTho.Dao;

import java.util.List;

import vn.HuuTho.Models.UserModel;

public interface IUserDao {
	List<UserModel> findAll();
	UserModel findById (int id);
	void insert (UserModel user);
}
