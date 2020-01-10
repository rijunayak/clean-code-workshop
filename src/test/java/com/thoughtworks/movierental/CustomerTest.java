package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CustomerTest {

    @Test
    public void should_correctly_show_the_statement() {
        Customer customer = new Customer("Bruce Wayne");
        Movie movieOne = new Movie("The Dark Knight", Movie.REGULAR);
        Movie movieTwo = new Movie("Batman Begins", Movie.NEW_RELEASE);
        Movie movieThree = new Movie("Batman - The Animated Movie", Movie.CHILDRENS);
        Rental rentalOne = new Rental(movieOne, 5);
        Rental rentalTwo = new Rental(movieTwo, 10);
        Rental rentalThree = new Rental(movieThree, 4);
        customer.addRental(rentalOne);
        customer.addRental(rentalTwo);
        customer.addRental(rentalThree);

        String statement = customer.statement();

        String expectedStatement = "Rental Record for Bruce Wayne\n" +
                "\tThe Dark Knight\t6.5\n" +
                "\tBatman Begins\t30.0\n" +
                "\tBatman - The Animated Movie\t3.0\n" +
                "Amount owed is 39.5\n" +
                "You earned 4 frequent renter points";
        System.out.println("expectedStatement = " + expectedStatement);
        assertThat(statement, is(equalTo(expectedStatement)));
    }
}
