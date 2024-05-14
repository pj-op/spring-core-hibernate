package com.practice.hibernate.dao;

import com.practice.hibernate.entity.Owner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OwnerDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addOwnerInformation(Owner owner) {
        entityManager.persist(owner);
    }

    public List<?> getOwnerInfo(int ownerId){
        Query query = entityManager.createQuery("SELECT o FROM Owner o where id=:ownerId");
        query.setParameter("ownerId", ownerId);

        return query.getResultList();

    }
}
