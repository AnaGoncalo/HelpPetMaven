/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author anne
 */
public class Banco {
    
    private static final Banco instanciaDeBanco = new Banco();
    private static EntityManager manager;

    private Banco() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("helppetweb");
        manager = factory.createEntityManager();
    }

    /**
     *
     * @return Instância de Banco de Dados.
     */
    public static Banco getInstance() {
        return instanciaDeBanco;
    }

    /**
     *
     * @return Genrênciador de entidades JPAs
     */
    public EntityManager getEntityManager() {
        return manager;
    }

}

