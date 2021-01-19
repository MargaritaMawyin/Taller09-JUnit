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
 * @author Rafael
 */
public class VideoGameRentalTest { 
    
    public VideoGameRentalTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    /**
     * Test of getDaysRented method, of class VideoGameRental.
     */
    @Test
    public void testGetDaysRented() {
        System.out.println("getDaysRented");
        WiiGame superSmashBrosBrawl = new WiiGame("Super Smash Bros. Brawl");
        VideoGameRental instance = new VideoGameRental(superSmashBrosBrawl, 3, false);
        int expResult = 3;
        int result = instance.getDaysRented();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVideoGame method, of class VideoGameRental.
     */
    @Test
    public void testGetVideoGame() {
        System.out.println("getVideoGame");
        Ps3Game littleBigPlanet = new Ps3Game("Little Big Planet");
        VideoGameRental instance = new VideoGameRental(littleBigPlanet, 1, false);
        Object expResult = littleBigPlanet;
        Object result = instance.getVideoGame();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCharge method, of class VideoGameRental.
     */
    @Test
    public void testGetCharge() {
        System.out.println("getCharge");
        Xbox360Game fable2 = new Xbox360Game("Fable 2");
        VideoGameRental instance = new VideoGameRental(fable2, 4, false);
        double expResult = 5.0;
        double result = instance.getCharge();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getFrequentRenterPoints method, of class VideoGameRental.
     */
    @Test
    public void testGetFrequentRenterPoints() {
        System.out.println("getFrequentRenterPoints");
        WiiGame superSmashBrosBrawl = new WiiGame("Super Smash Bros. Brawl");
        VideoGameRental instance = new VideoGameRental(superSmashBrosBrawl, 1, false);
        int expResult = 1;
        int result = instance.getFrequentRenterPoints();
        assertEquals(expResult, result);
        
    }
    
    @Deprecated
    @Test
    public void testStatementPs3GameOnly() {
        // Ps3 games cost $4.00 for the first 4 days, and $1.250/day thereafter
        // a rental earns 2 frequent-renter point no matter how many days
        Customer johnDoe = new Customer("John Doe");
        Ps3Game littleBigPlanet = new Ps3Game("Little Big Planet");
        johnDoe.addVideoGameRental(new VideoGameRental(littleBigPlanet, 1, false));
        assertEquals("Rental Record for John Doe\n" +
                "\tLittle Big Planet\t4.0\n" +
                "Amount owed is 4.0\n" +
                "You earned 2 frequent renter points",
           johnDoe.statement());
        johnDoe.addVideoGameRental(new VideoGameRental(littleBigPlanet, 3, false));
        assertEquals("Rental Record for John Doe\n" +
                "\tLittle Big Planet\t4.0\n" +
                "\tLittle Big Planet\t4.0\n" +
                "Amount owed is 8.0\n" +
                "You earned 4 frequent renter points",
           johnDoe.statement());
        johnDoe.addVideoGameRental(new VideoGameRental(littleBigPlanet, 5, false));
        assertEquals("Rental Record for John Doe\n" +
                "\tLittle Big Planet\t4.0\n" +
                "\tLittle Big Planet\t4.0\n" +
                "\tLittle Big Planet\t5.25\n" +
                "Amount owed is 13.25\n" +
                "You earned 6 frequent renter points",
           johnDoe.statement());
    }
    
    @Deprecated
    @Test
    public void testStatementWiiGameOnly() {
        // childrens' movies cost $1.50 for the first 3 days, and $1.50/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoeJr = new Customer("Johnny Doe, Jr.");
        WiiGame superSmashBrosBrawl = new WiiGame("Super Smash Bros. Brawl");
        johnDoeJr.addVideoGameRental(new VideoGameRental(superSmashBrosBrawl, 1, false));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                     "\tSuper Smash Bros. Brawl\t3.0\n" +
                     "Amount owed is 3.0\n" +
                     "You earned 1 frequent renter points",
                johnDoeJr.statement());
        johnDoeJr.addVideoGameRental(new VideoGameRental(superSmashBrosBrawl, 3, false));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
                	 "\tSuper Smash Bros. Brawl\t3.0\n" +
                	 "\tSuper Smash Bros. Brawl\t3.0\n" +
                     "Amount owed is 6.0\n" +
                     "You earned 2 frequent renter points",
                johnDoeJr.statement());
        johnDoeJr.addVideoGameRental(new VideoGameRental(superSmashBrosBrawl, 5, false));
        assertEquals("Rental Record for Johnny Doe, Jr.\n" +
           	         "\tSuper Smash Bros. Brawl\t3.0\n" +
        	         "\tSuper Smash Bros. Brawl\t3.0\n" +
        	         "\tSuper Smash Bros. Brawl\t4.5\n" +
                     "Amount owed is 10.5\n" +
                     "You earned 3 frequent renter points",
                johnDoeJr.statement());
    }
    
    @Deprecated
    @Test
    public void testStatementXbox360GameOnly() {
        // new releases cost $3.00/day
        // a rental earns 1 frequent-renter point 1 day; 2 points for 2 or more days
        Customer janeDoe = new Customer("Jane Doe");
        Xbox360Game fable2 = new Xbox360Game("Fable 2");
        janeDoe.addVideoGameRental(new VideoGameRental(fable2, 1, false));
        assertEquals("Rental Record for Jane Doe\n" +
                     "\tFable 2\t3.5\n" +
                     "Amount owed is 3.5\n" +
                     "You earned 2 frequent renter points",
                janeDoe.statement());
        janeDoe.addVideoGameRental(new VideoGameRental(fable2, 2, false));
        assertEquals("Rental Record for Jane Doe\n" +
                     "\tFable 2\t3.5\n" +
                     "\tFable 2\t3.5\n" +
                     "Amount owed is 7.0\n" +
                     "You earned 4 frequent renter points",
           janeDoe.statement());
        janeDoe.addVideoGameRental(new VideoGameRental(fable2, 4, false));
        assertEquals("Rental Record for Jane Doe\n" +
	                 "\tFable 2\t3.5\n" +
	                 "\tFable 2\t3.5\n" +
	                 "\tFable 2\t5.0\n" +
	                 "Amount owed is 12.0\n" +
	                 "You earned 6 frequent renter points",
	      janeDoe.statement());
    }
    
}