package Persistencia;

import Modelo.UserTeste;

public class UserDao extends CrudDao<UserTeste>{

	public UserDao() {
		super(UserTeste.class);
	}

}
