package pl.camp.it.services;

import pl.camp.it.dao.CustomerDAO;
import pl.camp.it.dao.ICustomerDAO;
import pl.camp.it.dao.IProductDAO;
import pl.camp.it.dao.ProductDAO;
import pl.camp.it.model.Adress;
import pl.camp.it.model.Customer;
import pl.camp.it.model.Invoice;
import pl.camp.it.model.Product;

import java.util.Date;
import java.util.Random;

public class CustomerService implements ICustomerService{ //static nie dziala z interfejsami a chcemy uzywac implementacji

    static IProductDAO productDAO = new ProductDAO();
    static ICustomerDAO customerDAO = new CustomerDAO();
    static IRandomDataService randomDataService = new RandomDataService(); //mozemy zamienic na FakerDataService,  i dziala dokladnie tak samo,
    // implementuje inne metody a nie modyfikujemy kodu tylko rozszerzamy nasz kod

    public void generateAndSaveCustomer(String name, String surname, String pesel) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setSurname(surname);
        customer.setPesel(Long.parseLong(pesel)); // dajemy stringa i metoda Loong zamienia na longa

        Adress adress = new Adress();
        adress.setCity(randomDataService.generateCity());
        adress.setStreet(randomDataService.generateStreet());

        customer.setAdress(adress);

        Invoice invoice = new Invoice();
        invoice.setDate(new Date());
        invoice.setSignature(randomDataService.generateInvoiceSignature());

        customer.getInvoices().add(invoice); // chcemy pobrac zbior faktur i do tego dorzucic fakture jedna

        Product product = new Product();
        product.setName(randomDataService.generateProductName());
        product.setPrice(randomDataService.generateProductPrice());
        product.getCustomers().add(customer);

        customer.getProducts().add(product);

        customerDAO.saveCustomerToDatabase(customer);

    }
}
