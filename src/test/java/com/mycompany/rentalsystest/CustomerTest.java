/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rentalsystest;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Kevin Chevez pc
 */
public class CustomerTest {
    Ps3Game littleBigPlanet;
    Xbox360Game fable2;
    WiiGame superSmashBrosBrawl;
    Movie peliculaDBZ;
    
    public CustomerTest() {
        setUp();
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        littleBigPlanet = new Ps3Game("Little Big Planet");
    	fable2 = new Xbox360Game("Fable 2");
    	superSmashBrosBrawl = new WiiGame("Super Smash Bros. Brawl");  
        peliculaDBZ = new Movie("Dragon ball Z", 2);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addMovieRental method, of class Customer.
     */
    @Test
    public void testAddMovieRental() {
        System.out.println("addMovieRental");
        MovieRental arg = new MovieRental(peliculaDBZ, 2);
        Customer instance = new Customer("John Doe");
        assertTrue(instance.addMovieRental(arg));
    }

    /**
     * Test of addVideoGameRental method, of class Customer.
     */
    @Test
    public void testAddVideoGameRental() {
        System.out.println("addVideoGameRental");
        VideoGameRental arg = new VideoGameRental(littleBigPlanet, 0, true);
        Customer instance = new Customer("John Doe");
        instance.addVideoGameRental(arg);
        assertTrue(instance.getVideoGames().contains(arg));
    }

    /**
     * Test of statement method, of class Customer.
     */
    @Test
    public void testStatement() {
        System.out.println("statement");
        Customer johnDoe = new Customer("John Doe");
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
    
}
