package com.practice.hibernate.dao;

import com.practice.hibernate.entity.Pet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetsDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addPetInfo(Pet pet) {
        entityManager.persist(pet);
    }

    public List<Pet> getAllPets() {
        return (List<Pet>) entityManager.createQuery("SELECT p FROM Pet p INNER JOIN owner o ON p.owner_id=o.id").getResultList();
    }
}
