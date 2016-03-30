package Dao;

import java.util.HashMap;

import Model.User;

public interface UserDao {

	
	public boolean checkUser(String username,HashMap mymap);
	
	public HashMap createUser(HashMap mymap,User user);
	
	public boolean authenticateUser(HashMap mymap,User user);
	
	
	
}
