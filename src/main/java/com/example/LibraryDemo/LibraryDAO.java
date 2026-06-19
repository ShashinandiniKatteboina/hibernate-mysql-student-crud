package com.example.LibraryDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class LibraryDAO {

    public void saveBook(Library book) {

        Session session = Utility.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(book);

        tx.commit();
        session.close();
    }

    public List<Library> getAllBooks() {

        Session session = Utility.getSessionFactory().openSession();

        List<Library> books =
                session.createQuery("FROM Library", Library.class)
                       .list();

        session.close();

        return books;
    }

    public Library getBookById(int id) {

        Session session = Utility.getSessionFactory().openSession();

        Library book = session.get(Library.class, id);

        session.close();

        return book;
    }

    public void updateBook(Library book) {

        Session session = Utility.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.merge(book);

        tx.commit();
        session.close();
    }

    public void deleteBook(int id) {

        Session session = Utility.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Library book = session.get(Library.class, id);

        if (book != null) {
            session.remove(book);
        }

        tx.commit();
        session.close();
    }
}