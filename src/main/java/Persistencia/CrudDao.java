/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anne
 */
public abstract class CrudDao<T> {
    
    private Class<T> entityClass;

    public CrudDao(Class<T> entityClass) {
       this.entityClass = entityClass;       
    }
    
    /**
     * @param Entiade a ser pesistida.
     * @return Retorna TRUE se a entidade for persistida no banco de dados
     * e FALSE se houver um erro durante a persitência.
     */
    public boolean inserir(T entidade) {
        EntityManager em = Banco.getInstance().getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CrudDao.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        return false;
    }

    /**
     * 
     * @param Entidade a ser alterada.
     * @return Retorna TRUE se a entidade for persistida no banco de dados
     * e FALSE se houver um erro durante a persitência.
     */
    public boolean alterar(T entidade) {
        EntityManager em = Banco.getInstance().getEntityManager();;
        try {
            em.getTransaction().begin();
            em.merge(entidade);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CrudDao.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        return false;
    }
    
    /**
     * 
     * @param Entidade a ser excluida.
     * @return Retorna TRUE se a entidade for persistida no banco de dados
     * e FALSE se houver um erro durante a persitência.
     */
    public boolean excluir(T entidade){
        EntityManager em = Banco.getInstance().getEntityManager();;
        try {
            //em = getEntityManager();
            em.getTransaction().begin();
            em.remove(entidade);
            em.getTransaction().commit();
            return true;
        } catch (Exception ex){
            Logger.getLogger(CrudDao.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        return false;
    }
    
    /**
     * 
     * @param Id da entidade a ser pesquisada
     * @return Retorna uma entidade genérica caso o Id seja encontrado.
     */
    public T pesquisarPorId(long id) {
        EntityManager em = Banco.getInstance().getEntityManager();
        try {
            //em = getEntityManager();
            T t = em.find(entityClass, id);
            return t;
        } catch(Exception ex) {
            Logger.getLogger(CrudDao.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        return null;
    }
    
    /**
     * 
     * @return Lista genérica de entidades
     */
    public List<T> listarTodos() {
        javax.persistence.criteria.CriteriaQuery cq = Banco.getInstance().getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return Banco.getInstance().getEntityManager().createQuery(cq).getResultList();
    }

}
