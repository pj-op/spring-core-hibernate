package com.practice.hibernate;

import com.practice.hibernate.config.MySQLDbConfig;
import com.practice.hibernate.dao.BookDao;
import com.practice.hibernate.dao.OwnerDao;
import com.practice.hibernate.dao.PetsDao;
import com.practice.hibernate.entity.BookForSale;
import com.practice.hibernate.entity.Owner;
import com.practice.hibernate.entity.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MySQLDbConfig.class);

        BookDao bookDao = context.getBean(BookDao.class);
        bookDao.addBookEntity(prepareBookForSale());
        System.out.println(bookDao.findBook(1));

        PetsDao petsDao = context.getBean(PetsDao.class);

        Pet pet1 = new Pet();
        pet1.setName("rabbit");

        Pet pet2 = new Pet();
        pet2.setName("cat");

        HashSet<Pet> pets = new HashSet<>();
        pets.add(pet1);
        pets.add(pet2);

        OwnerDao ownerDao = context.getBean(OwnerDao.class);
        ownerDao.addOwnerInformation(prepareOwner(pets));

        List<?> owner = ownerDao.getOwnerInfo(1);

        pet1.setOwner((Owner) owner.get(0));
        pet2.setOwner((Owner) owner.get(0));

        petsDao.addPetInfo(pet1);
        petsDao.addPetInfo(pet2);

        petsDao.getAllPets().forEach(pet -> System.out.println(pet.getOwnerName()));
    }

    private static Owner prepareOwner(Set<Pet> pets) {
        Owner owner = new Owner();
        owner.setFirstName("Mike");
        owner.setPets(pets);
        return owner;
    }

    private static BookForSale prepareBookForSale() {
        BookForSale book = new BookForSale();
        book.setAuthor("test author");
        book.setIsbn("test isbn");
        book.setName("Test Book Name");

        return book;
    }
}
