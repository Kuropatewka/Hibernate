package pl.camp.it.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "tproduct")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;

    @ManyToMany(fetch = FetchType.EAGER) //fetch, to dociaganie danych przez hibernate bo jest leniwy i trzeba mu powiedziec zeby dociagnal wszystko
    // dociagniecie danych od razu w ramach tej sesji, a nie w momencie uzycia
    private Set<Customer> customers = new HashSet<>(); // relacja many to many czyli dziala w dwie strony

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price + // musielismy usunac customera bo ciagle sie zapetlalo, i byl stackoverflow
                '}';
    }

    public String toString2() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price + // musielismy usunac customera bo ciagle sie zapetlalo, i byl stackoverflow
                ", customer=" + customers +
                '}';
    }
}
