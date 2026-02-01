package application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Book.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();



        Book book = new Book();
        book.setAuthorName("Sir Arthur Conan Doyle");
        book.setBookTitle("A Study in Scarlet");
        book.setId(1);

        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();

        System.out.println("Record saved!!");
    }

}
