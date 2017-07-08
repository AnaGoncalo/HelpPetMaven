package Persistencia;

import Modelo.User;

public class UserDao extends CrudDao<User>{

	public UserDao() {
		super(User.class);
	}

}
