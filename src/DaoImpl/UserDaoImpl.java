package DaoImpl;

import java.util.HashMap;

import Dao.UserDao;
import Model.User;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean checkUser(String username,HashMap mymap) {
		// TODO Auto-generated method stub
	
		if(mymap!=null && mymap.containsKey(username))
		{
			return true;	
		}
		else
		{
			return false;
		}
	}

	@Override
	public HashMap createUser(HashMap mymap, User user) {
		// TODO Auto-generated method stub
		mymap.put(user.getUserName(),user);
		return mymap;
	
	}

	@Override
	public boolean authenticateUser(HashMap mymap, User user) {
		// TODO Auto-generated method stub
		
		User users=(User)mymap.get(user.getUserName());


		//System.out.println(users.getUserName()+"="+user.getUserName());
		//System.out.println(users.getPassword()+"="+user.getPassword());
		if(users.getUserName().equals(user.getUserName()) && users.getPassword().equals(user.getPassword()))
		{
			
			return true;
		}
		
		return false;
	}

																																																															
}
