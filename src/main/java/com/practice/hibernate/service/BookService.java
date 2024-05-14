package com.practice.hibernate.service;

import com.practice.hibernate.dao.BookDao;
import com.practice.hibernate.entity.BookForSale;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void saveBook(BookForSale book) {
        bookDao.addBookEntity(book);
    }

    public List<?> findBookById(int id) {
        return bookDao.findBook(id);
    }


}
