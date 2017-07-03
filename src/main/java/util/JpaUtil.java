package util;

import javax.persistence.EntityManager;
/**
 * Classe de persistencia usada para criar a EntityManagerFactory somente uma
 * vez. 
 * @author Josaf� Rebou�as
 * classe criada em 08/01/2016
 */
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	

	/**
	 * Retorna uma fabrica de gerenciadoes de entidade
	 */
	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("helppettads");

	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

	

}
