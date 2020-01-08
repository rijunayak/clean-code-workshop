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
        Rental rentalOne = new Rental(movieOne, 5);
        Rental rentalTwo = new Rental(movieTwo, 10);
        customer.addRental(rentalOne);
        customer.addRental(rentalTwo);

        String statement = customer.statement();

        String expectedStatement = "Rental Record for Bruce Wayne\n" +
                "\tThe Dark Knight\t6.5\n" +
                "\tBatman Begins\t30.0\n" +
                "Amount owed is 36.5\n" +
                "You earned 3 frequent renter points";
        System.out.println("expectedStatement = " + expectedStatement);
        assertThat(statement, is(equalTo(expectedStatement)));
    }
}
