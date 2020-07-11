package pl.camp.it.model;

import javax.persistence.*;
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
    private long pesel;

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

    @Override
    public String toString() {
        return "Customer{" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", surname= '" + surname + '\'' +
                ", pesel= " + pesel +
                '}';
    }
}
