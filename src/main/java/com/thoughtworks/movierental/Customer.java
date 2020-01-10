package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : rentals) {
            double rentalAmount = 0;
            //determine amounts for each line
            switch (rental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    rentalAmount += 2;
                    if (rental.getDaysRented() > 2)
                        rentalAmount += (rental.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    rentalAmount += rental.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    rentalAmount += 1.5;
                    if (rental.getDaysRented() > 3)
                        rentalAmount += (rental.getDaysRented() - 3) * 1.5;
                    break;
            }
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                    &&
                    rental.getDaysRented() > 1) frequentRenterPoints++;

            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    rentalAmount + "\n";
            totalAmount += rentalAmount;
        }

        //add footer lines result
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return result;
    }
}
