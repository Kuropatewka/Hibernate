package pl.camp.it.model; // przez adnotacje przekazujemy mapowanie obiektów na relacje do bazy danych, ale mozemy zrobic too przez plik konfiguracyjny

// SOLID 5 podstawowych założeń programowania obiektowego, wzorzec MVC - model(dane), view(widok), controller(logika)
// DAO data access object

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
// hibernate jest implementacja tego konkretnego mechanizmu JPA, Entity to adnotacja z Appy

@Entity(name = "tcustomer")
public class Customer { // musi byc pusty konstruktor i wszystkie gettery i setttery bo hibernate sam uzupelnia i pobiera dane

    @Id // id musi byc kluczem glownym, tyczy sie pierwszej rzeczy jaka spotka
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private int id;
    @Column(nullable = false) //nie moze byc nullem
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(unique = true, nullable = false) //unique
    private long pesel;                   // defaultowe wrtosci sa agresywne w przypadku onetone - eager, nie kosztuje to za duzo
    @OneToOne(cascade = CascadeType.ALL) // nie musze osobno zapisywac adresu tylko zrobic kaskadowosc, wszystkie encje które posiada zapisuje,
    // przeszukuje wszystkie jego pola i zapisuje przed metoda saveCystomerToDatabase
    // jak wycigamy customera to wyciagamy jednoczesnie jego adress
    //zapisujac pole zapisuje wszystkie obiekty, lawina, zapisujemy wszystkiie obiekty dzieki kaskadowosci
    private Adress adress; // relacja 1;1 z klasą adress
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // chcemy zeby zapisaly sie wszystkie jego faktury, kaskadowosc zawieramy w klasie nadrzednej
    private Set<Invoice> invoices = new HashSet<>(); // 2 tabelki umie joinowac ale 3 juz nie moze dlatego wybieramy seta a nie liste
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Product> products = new HashSet<>();

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", surname= '" + surname + '\'' +
                ", pesel= " + pesel +
                ", adress= " + adress +
                ", invoices= " + invoices +
                ", products= " + products +
                '}';
    }
}
