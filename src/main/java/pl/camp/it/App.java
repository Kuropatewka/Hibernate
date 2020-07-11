package pl.camp.it;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pl.camp.it.model.Customer;

public class App {
    public static SessionFactory sessionFactory =
            new Configuration().configure().buildSessionFactory();

    public static void main(String[] args) {
        System.out.println("Hibernate !!");

        Customer customer = new Customer();
        //TODO co się stanie
        //customer.setId(10); // jesli podamy id to zachowalo sie tak jakbymsy chcieli updatowac customera o id 10
        customer.setName("Mateusz");
        customer.setSurname("Bereda");
        customer.setPesel(5345345353545L);

        // transakcja to zestaw operacji atomowych, otwieram transakcje a na koncu ja zamykam
        // wszystkie zmiany, które się wykonały a coś się wysypało to chciałbym zeby zostały zrollbackowane czyli wycofane
        // każda operacja, która modyfikuje dane w bazie danych musi być transakcyjna

        saveCustomerToDatabase(customer);

        Customer customer1 = new Customer();
        customer1.setName("Jan");
        customer1.setSurname("Kowalski");
        customer1.setPesel(23434534543L);

        saveCustomerToDatabase(customer1); // podalismy referencje do tej metody i ten obiekt zostal od razu zmieniony w bazie danych

        System.out.println(customer1);

        deleteCustomer(customer1);

        System.out.println(customer1);

    }

    public static void saveCustomerToDatabase(Customer customer) {
        Session session = sessionFactory.openSession(); // jedna sesja komunikacji z baza danych
        Transaction tx = null; // na poczatku deklarujemy nulla bo cos moze sie wysypac
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(customer);
            tx.commit(); //jak sie uda to commit
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback(); // jak sie nie uda to rollback, czyli cofamy te zmiany
            }
        } finally { // zawsze to się wykona czy sie uda czy sie nie uda
            session.close();
        }
    }

    public static void deleteCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(customer);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}
