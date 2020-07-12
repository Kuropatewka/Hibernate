package pl.camp.it.services;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FakerDataService implements IRandomDataService {
    @Override
    public String generateCity() {  //zwraca Stringa, nie przyjmuje wartości
        List<String> cities = Arrays.asList(" Kraków",
                "Warszawa",
                "Poznań",
                "Katowice",
                "Gliwice",
                "New York",
                "London",
                "Paris",
                "Berlin",
                "Tokyo"); // argumenty tej listy
        //cities.add(); mozna tak zrobic ze pododawac recznie

        //Random random = new Random(); mozna tak przez obiekt i do niego sie dostac
        return cities.get(new Random().nextInt(cities.size())); //lub tak ze robimy random i od razu na nie generujemy randomowe miasto
    }
    @Override
    public String generateStreet() {  //zwraca Stringa, nie przyjmuje parametrów
        List<String> streets = Arrays.asList("Polna",
                "Ogrodowa",
                "Szewska",
                "Floriańska",
                "Malinowa",
                "Wall Street",
                "Aleje Kijowskie",
                "Krzywa",
                "Pokątna",
                "Spadzista"); // argumenty tej listy
        //cities.add(); mozna tak zrobic ze pododawac recznie

        //Random random = new Random(); mozna tak przez obiekt i do niego sie dostac
        return streets.get(new Random().nextInt(streets.size())); //lub tak ze robimy random i od razu na nie generujemy randomowe miasto
    }
    @Override
    public String generateInvoiceSignature() {
        Random random = new Random();
        int no = random.nextInt(10) + 1;
        int month = random.nextInt(12) + 1;
        int year  = random.nextInt(6) + 2015;

        return new StringBuilder()
                .append("FV/")
                .append(no)
                .append("/")
                .append(month)
                .append("/")
                .append(year)
                .toString();
    }
    @Override
    public String generateProductName() {
        List<String> names = Arrays.asList("Woda",
                "Kiełbasa",
                "Boczek",
                "Salceson",
                "Pasztet",
                "Paprykarz",
                "Chipsy",
                "Pepsi",
                "Linijka",
                "Ser"); // argumenty tej listy
        //cities.add(); mozna tak zrobic ze pododawac recznie

        //Random random = new Random(); mozna tak przez obiekt i do niego sie dostac
        return names.get(new Random().nextInt(names.size())); //lub tak ze robimy random i od razu na nie generujemy randomowe miasto
    }
    @Override
    public double generateProductPrice() {
        int generatedNumber = new Random().nextInt(1901) + 100;
        return ((double) generatedNumber) / 100.0;
    }
}


