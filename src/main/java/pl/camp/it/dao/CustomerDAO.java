package pl.camp.it.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.camp.it.App;
import pl.camp.it.model.Customer;
import pl.camp.it.services.CustomerService;
import pl.camp.it.services.ICustomerService;

import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    @Override
    public void saveCustomerToDatabase(Customer customer) {
        Session session = App.sessionFactory.openSession(); // jedna sesja komunikacji z baza danych
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
    @Override
    public void deleteCustomer(Customer customer) {
        Session session = App.sessionFactory.openSession();
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
    @Override
    public Customer getCustomerById(int id) {
        Session session = App.sessionFactory.openSession();
        Query<Customer> query = session.createQuery("FROM pl.camp.it.model.Customer WHERE id = " + id); // HQL - to samo co SQL tylko uproszczony od hibernate
        // piszemy obiektowo więc ściezke klasy a nie nazwe tabelki z bazy jak w SQL, poslugujemy sie wszytskim z Javy
        // Customer customer = (Customer) query.getSingleResult();
        // return customer; mozna rzutowac na customera
        Customer customer = query.getSingleResult(); // teraz nie zwroci mi objecta wiec nie musimy rzutowac tylko od razu zwroci mi
        session.close();
        return customer; // Query jest teraz typowane na customera
    }
    @Override
    public List<Customer> getAllCustomers() {
        Session session = App.sessionFactory.openSession();
        Query<Customer> query = session.createQuery("FROM pl.camp.it.model.Customer");
        List<Customer> result = query.getResultList(); // mozna zrobic jak wyzej albo od razy zwrocic bez zmiennej
        session.close();
        return result;
    }
}
