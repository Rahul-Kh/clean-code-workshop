package com.movierental;

import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
    
    private static Customer regularCustomer;
    private static Customer childrenCustomer;
    private static Customer newMovieCustomer;
    private static Customer customer;
    
    @Test
    public void testRegularMovie() {
        regularCustomer = new Customer("regular");
        regularCustomer.addRental(new Rental(new Movie("regular", Movie.REGULAR), 2));
        String expected = "Rental Record for regular\n" +
"	regular	2.0\n" +
"Amount owed is 2.0\n" +
"You earned 1 frequent renter points";
        Assert.assertEquals(expected, regularCustomer.statement());
    }
     
    @Test
    public void testNewMovie() {
        newMovieCustomer = new Customer("new");
        newMovieCustomer.addRental(new Rental(new Movie("new", Movie.NEW_RELEASE), 1));
        String expected = "Rental Record for new\n" +
"	new	3.0\n" +
"Amount owed is 3.0\n" +
"You earned 1 frequent renter points";
        Assert.assertEquals(expected, newMovieCustomer.statement());
    }
     
    @Test
    public void testChildrenMovie() {
        childrenCustomer = new Customer("children");
        childrenCustomer.addRental(new Rental(new Movie("children", Movie.CHILDRENS), 3));
        String expected = "Rental Record for children\n" +
"	children	1.5\n" +
"Amount owed is 1.5\n" +
"You earned 1 frequent renter points";
        Assert.assertEquals(expected, childrenCustomer.statement());
    }
     
    @Test
    public void testRegularMovieLongDuration() {
        regularCustomer = new Customer("regular");
        regularCustomer.addRental(new Rental(new Movie("regular", Movie.REGULAR), 4));
        String expected = "Rental Record for regular\n" +
"	regular	5.0\n" +
"Amount owed is 5.0\n" +
"You earned 1 frequent renter points";
        Assert.assertEquals(expected, regularCustomer.statement());
    }
     
    @Test
    public void testNewMovieLongDuration() {
        newMovieCustomer = new Customer("new");
        newMovieCustomer.addRental(new Rental(new Movie("new", Movie.NEW_RELEASE), 2));
        String expected = "Rental Record for new\n" +
"	new	6.0\n" +
"Amount owed is 6.0\n" +
"You earned 2 frequent renter points";
        Assert.assertEquals(expected, newMovieCustomer.statement());
    }
     
    @Test
    public void testChildrenMovieLongDuration() {
        childrenCustomer = new Customer("children");
        childrenCustomer.addRental(new Rental(new Movie("children", Movie.CHILDRENS), 6));
        String expected = "Rental Record for children\n" +
"	children	6.0\n" +
"Amount owed is 6.0\n" +
"You earned 1 frequent renter points";
        Assert.assertEquals(expected, childrenCustomer.statement());
    }
    
    @Test
    public void testAllType() {
        customer = new Customer("All");
        customer.addRental(new Rental(new Movie("regular", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("new", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("children", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("regular", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("new", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("children", Movie.CHILDRENS), 6));
        String expected = "Rental Record for All\n" +
"	regular	2.0\n" +
"	new	3.0\n" +
"	children	1.5\n" +
"	regular	5.0\n" +
"	new	6.0\n" +
"	children	6.0\n" +
"Amount owed is 23.5\n" +
"You earned 7 frequent renter points";
        Assert.assertEquals(expected, customer.statement());
    }
     
    @Test
    public void testLoops() {
        for (int j = 0 ; j < 100 ; j++) {
            
            // single loop
            int x = 0, y = 0, z = 0;
            long l = System.currentTimeMillis();
            for (int i = 0 ; i < 100000000 ; i++) {
                x++;
                y++;
                z++;
            }
            l = System.currentTimeMillis() - l;
            
            // Multiple loops doing same thing
            int a = 0 , b = 0, c = 0;
            long m = System.currentTimeMillis();
            for (int i = 0 ; i < 100000000 ; i++) {
                a++;
            }
            for (int i = 0 ; i < 100000000 ; i++) {
                b++;
            }
            for (int i = 0 ; i < 100000000 ; i++) {
                c++;
            }
            m = System.currentTimeMillis() - m;
            
            System.out.println(String.format("%d, %d", l, m));
        }
    }
     
    @Test
    public void testhtmlStatement() {
        customer = new Customer("All");
        customer.addRental(new Rental(new Movie("regular", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("new", Movie.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("children", Movie.CHILDRENS), 3));
        customer.addRental(new Rental(new Movie("regular", Movie.REGULAR), 4));
        customer.addRental(new Rental(new Movie("new", Movie.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("children", Movie.CHILDRENS), 6));
        String expected = "<h1>Rental Record for <b>All</b></h1><br/> regular 2.0<br/> new 3.0<br/> children 1.5<br/> regular 5.0<br/> new 6.0<br/> children 6.0<br/>Amount owed is <b>23.5</b><br/>You earned <b>7</b> frequent renter points";
        Assert.assertEquals(expected, customer.htmlStatement());
    }
}