/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rentalsystest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Marco
 */
public class MovieRentalTest {
    
    Movie theManWhoKnewTooMuch, mulan, slumdogMillionaire;
    
    public MovieRentalTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        theManWhoKnewTooMuch = new Movie("The Man Who Knew Too Much", Movie.REGULAR);
        mulan = new Movie("Mulan", Movie.CHILDRENS);
        slumdogMillionaire = new Movie("Slumdog Millionaire", Movie.NEW_RELEASE);
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    /**
     * Test of getDaysRented method, of class MovieRental.
     */
    
    @org.junit.jupiter.api.Test
    public void testGetPriceCode() {
        System.out.println("getPriceCode");
        theManWhoKnewTooMuch = new Movie("The Man Who Knew Too Much", Movie.REGULAR);
        assertEquals(Movie.REGULAR, theManWhoKnewTooMuch.getPriceCode());
    }

    @org.junit.jupiter.api.Test
    public void testGetTitle() {
        System.out.println("getTitle");
        theManWhoKnewTooMuch = new Movie("The Man Who Knew Too Much", Movie.REGULAR);
        assertEquals("The Man Who Knew Too Much", theManWhoKnewTooMuch._title);
    }
    
    @org.junit.jupiter.api.Test
    public void testSetPriceCode() {
        theManWhoKnewTooMuch = new Movie("The Man Who Knew Too Much", Movie.REGULAR);
        
        theManWhoKnewTooMuch.setPriceCode(Movie.NEW_RELEASE);
        assertEquals(Movie.NEW_RELEASE, theManWhoKnewTooMuch.getPriceCode());
        theManWhoKnewTooMuch.setPriceCode(Movie.REGULAR);
        assertEquals(Movie.REGULAR, theManWhoKnewTooMuch.getPriceCode());
    }
    
    @Test
    public void testGetDaysRented() {
        assertEquals(2, new MovieRental(theManWhoKnewTooMuch, 2).getDaysRented());
    }

    @Test
    public void testGetMovie() {
        assertEquals(theManWhoKnewTooMuch, new MovieRental(theManWhoKnewTooMuch, 2).getMovie());
    }
    
    @Test
    public void testGetName() {
        String name = "John Doe"; 
        assertEquals(name, new Customer(name)._name);
    }
    
    @Test
    public void testStatementRegularMovieOnly() {
        // regular movies cost $2.00 for the first 2 days, and $1.50/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoe = new Customer("John Doe");
        theManWhoKnewTooMuch = new Movie("The Man Who Knew Too Much", Movie.REGULAR);
        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch,1));
        assertEquals("Rental Record for John Doe\n" +
                "\tThe Man Who Knew Too Much\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points",
           johnDoe.statement());
        
        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch,2));
        assertEquals("Rental Record for John Doe\n" +
                "\tThe Man Who Knew Too Much\t2.0\n" +
                "\tThe Man Who Knew Too Much\t2.0\n" +
                "Amount owed is 4.0\n" +
                "You earned 2 frequent renter points",
           johnDoe.statement());
        
        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch,4));
        assertEquals("Rental Record for John Doe\n" +
                "\tThe Man Who Knew Too Much\t2.0\n" +
                "\tThe Man Who Knew Too Much\t2.0\n" +
                "\tThe Man Who Knew Too Much\t5.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 3 frequent renter points",
           johnDoe.statement());
        
    }
    
     @Test
    public void testStatementChildrensMovieOnly() {
        // childrens' movies cost $1.50 for the first 3 days, and $1.25/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoeJr = new Customer("Johnny Doe, Jr.");
        mulan = new Movie("Mulan", Movie.CHILDRENS);
        johnDoeJr.addMovieRental(new MovieRental(mulan,1));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                "\tMulan\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points",
           johnDoeJr.statement());
        
        johnDoeJr.addMovieRental(new MovieRental(mulan,3));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                "\tMulan\t1.5\n" +
                "\tMulan\t1.5\n" +
                "Amount owed is 3.0\n" +
                "You earned 2 frequent renter points",
           johnDoeJr.statement());
        
        johnDoeJr.addMovieRental(new MovieRental(mulan,5));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                "\tMulan\t1.5\n" +
                "\tMulan\t1.5\n" +
                "\tMulan\t4.0\n" +
                "Amount owed is 7.0\n" +
                "You earned 3 frequent renter points",
           johnDoeJr.statement());
    }

    @Test
    public void testStatementNewReleaseOnly() {
        // new releases cost $3.00/day
        // a rental earns 1 frequent-renter point 1 day; 2 points for 2 or more days
        Customer janeDoe = new Customer("Jane Doe");
        slumdogMillionaire = new Movie("Slumdog Millionaire", Movie.NEW_RELEASE);
        janeDoe.addMovieRental(new MovieRental(slumdogMillionaire,1));
        assertEquals("Rental Record for Jane Doe\n" +
                "\tSlumdog Millionaire\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points",
           janeDoe.statement());
        
        janeDoe.addMovieRental(new MovieRental(slumdogMillionaire,2));
        assertEquals("Rental Record for Jane Doe\n" +
                "\tSlumdog Millionaire\t3.0\n" +
                "\tSlumdog Millionaire\t6.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 3 frequent renter points",
           janeDoe.statement());
        
        janeDoe.addMovieRental(new MovieRental(slumdogMillionaire,4));
        assertEquals("Rental Record for Jane Doe\n" +
                "\tSlumdog Millionaire\t3.0\n" +
                "\tSlumdog Millionaire\t6.0\n" +
                "\tSlumdog Millionaire\t12.0\n" +
                "Amount owed is 21.0\n" +
                "You earned 5 frequent renter points",
           janeDoe.statement());
    }
    
}
