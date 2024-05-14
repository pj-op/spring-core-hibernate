package com.practice.hibernate.dao;

import com.practice.hibernate.entity.BookForSale;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addBookEntity(BookForSale book) {
        entityManager.persist(book);
    }

    public List<?> findBook(int bookId) {
        Query query = entityManager.createQuery("SELECT t from BookForSale t where Id=:bookId");
        query.setParameter("bookId", bookId);

        return query.getResultList();
    }

}
