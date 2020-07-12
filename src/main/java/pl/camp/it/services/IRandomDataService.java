package pl.camp.it.services;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public interface IRandomDataService {

     String generateCity();
     String generateStreet();
     String generateInvoiceSignature();
     String generateProductName();
     double generateProductPrice();
}
