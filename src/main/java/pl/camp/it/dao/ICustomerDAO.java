package pl.camp.it.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.camp.it.App;
import pl.camp.it.model.Customer;

import java.util.List;

public interface ICustomerDAO {
     void saveCustomerToDatabase(Customer customer);
     void deleteCustomer(Customer customer);
     Customer getCustomerById(int id);
     List<Customer> getAllCustomers();
}
