package com.association;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // One to One example
       /* SessionFactory sessionFactory =  new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory();
        Session session =  sessionFactory.openSession();
        Transaction transaction=  session.beginTransaction();

        Passport passport = new Passport();
        passport.setCountry("");

        Person person1 = new Person();
        person1.setName("cristiano ronaldo");
        person1.setPassport(passport);

        session.persist(person1);
        session.persist(passport);

        transaction.commit();


        List<Person> fromPerson = session.createQuery("from Person", Person.class).getResultList();
        for (Person person : fromPerson)
            System.out.println(person.getName() + " "+ person.getPassport().getCountry());

        session.close();
        sessionFactory.close();*/

        // One to Many

    /*SessionFactory sessionFactory =    new Configuration()
                                            .addAnnotatedClass(Library.class)
                                            .addAnnotatedClass(Book.class)
                                            .buildSessionFactory();

    Session session= sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

        Library library = new Library();
        library.setLibraryName("Vidya");

        Library library2 = new Library();
        library2.setLibraryName("Ganesh");


        Book book1 = new Book();
        book1.setBookName("Core Java");
        book1.setLibrary(library);

        Book book2 = new Book();
        book2.setBookName("Hibernate");
        book2.setLibrary(library);

        Book book3 = new Book();
        book3.setBookName("Spring Boot");
        book3.setLibrary(library2);

        Book book4 = new Book();
        book4.setBookName("Redis cache");
        book4.setLibrary(library2);

        List<Book> books = List.of(book1, book2);

        library.setBooks(books);

        library2.setBooks(List.of(book3, book4));

        session.persist(library2);
        session.persist(library);
//        session.persist(books);
        transaction.commit();*/

        // many to many

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user1 = new User();
        user1.setUserName("Suraj Bhosale");

        User user2 = new User();
        user2.setUserName("Sujal Bhosale");


        Product product1 = new Product();
        product1.setBrandName("Apple");
        product1.setUsers(List.of(user1, user2));

        Product product2 = new Product();
        product2.setBrandName("Samsung");
        product2.setUsers(List.of(user1, user2));

        Product product3 = new Product();
        product3.setBrandName("Window");
        product3.setUsers(List.of(user1, user2));

        user2.setProducts(List.of(product1, product2));
        user1.setProducts(List.of(product1, product2, product3));

        session.persist(user1);
        session.persist(user2);
        session.persist(product1);
        session.persist(product2);
        session.persist(product3);



        transaction.commit();


    }
}
