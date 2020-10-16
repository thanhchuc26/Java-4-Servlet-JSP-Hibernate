/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softech.onlineshop.controllers;

import com.softech.onlineshop.controllers.exceptions.NonexistentEntityException;
import com.softech.onlineshop.entities.ShopEntity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author June
 */
public class ShopEntityJpaController implements Serializable {

    public ShopEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ShopEntity shopEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(shopEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ShopEntity shopEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            shopEntity = em.merge(shopEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = shopEntity.getProductId();
                if (findShopEntity(id) == null) {
                    throw new NonexistentEntityException("The shopEntity with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ShopEntity shopEntity;
            try {
                shopEntity = em.getReference(ShopEntity.class, id);
                shopEntity.getProductId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The shopEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(shopEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ShopEntity> findShopEntityEntities() {
        return findShopEntityEntities(true, -1, -1);
    }

    public List<ShopEntity> findShopEntityEntities(int maxResults, int firstResult) {
        return findShopEntityEntities(false, maxResults, firstResult);
    }

    private List<ShopEntity> findShopEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ShopEntity.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ShopEntity findShopEntity(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ShopEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getShopEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ShopEntity> rt = cq.from(ShopEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
