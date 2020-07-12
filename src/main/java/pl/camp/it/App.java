package pl.camp.it;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.camp.it.dao.CustomerDAO;
import pl.camp.it.dao.ProductDAO;
import pl.camp.it.model.Adress;
import pl.camp.it.model.Customer;
import pl.camp.it.model.Invoice;
import pl.camp.it.model.Product;

import java.util.Date;
import java.util.List;

public class App {

    public static SessionFactory sessionFactory =
            new Configuration().configure().buildSessionFactory();

    /*public static void main(String[] args) {
        System.out.println("Hibernate !!");

        Customer customer = new Customer();
        //TODO co się stanie
        //customer.setId(10); // jesli podamy id to zachowalo sie tak jakbymsy chcieli updatowac customera o id 10
        customer.setName("Mateusz");
        customer.setSurname("Bereda");
        customer.setPesel(5345345353545L);

        Adress adress = new Adress();
        adress.setCity("Kraków");
        adress.setStreet("Ogrodowa");

        customer.setAdress(adress);

        Invoice invoice = new Invoice();
        invoice.setDate(new Date()); // nie zapamiętywać tego z datą hehe
        invoice.setSignature("FV/1/7/2020");

        customer.getInvoices().add(invoice);

        Invoice invoice2 = new Invoice();
        invoice2.setDate(new Date());
        invoice2.setSignature("FV/2/7/2020");

        customer.getInvoices().add(invoice2);

        Product product = new Product();
        product.setPrice(100.0);
        product.setName("Mikser");
        product.getCustomers().add(customer);

        customer.getProducts().add(product);


        // transakcja to zestaw operacji atomowych, otwieram transakcje a na koncu ja zamykam
        // wszystkie zmiany, które się wykonały a coś się wysypało to chciałbym zeby zostały zrollbackowane czyli wycofane
        // każda operacja, która modyfikuje dane w bazie danych musi być transakcyjna

        customerDAO.saveCustomerToDatabase(customer);

        Customer customer1 = new Customer();
        customer1.setName("Jan");
        customer1.setSurname("Kowalski");
        customer1.setPesel(23434534543L);

        CustomerDAO.saveCustomerToDatabase(customer1); // podalismy referencje do tej metody i ten obiekt zostal od razu zmieniony w bazie danych

        System.out.println("CUSTOMER 1");
        System.out.println(CustomerDAO.getCustomerById(1));

        System.out.println(CustomerDAO.getAllCustomers());

        System.out.println(ProductDAO.getProductById(1));

        Product p = ProductDAO.getProductById(1);
        System.out.println(p.toString2()); // hibernate nie wyciaga wszystkiego z bazy, jest leniwy, dlatego musimy powiedziec zeby byl nie leniwy
        // i zeby wszystko dociagal,

    }*/
}
