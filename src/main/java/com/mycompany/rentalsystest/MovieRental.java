package com.mycompany.rentalsystest;

class MovieRental {

    private Movie _movie;
    private int _daysRented;

    public MovieRental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public Movie getMovie() {
        return _movie;
    }
    /**
     * Para las pruebas unitarias
     * 
    Movie theManWhoKnewTooMuch, mulan, slumdogMillionaire;
    @Before
    public void setUp() {
        theManWhoKnewTooMuch = new Movie("The Man Who Knew Too Much", Movie.REGULAR);
        mulan = new Movie("Mulan", Movie.CHILDRENS);
        slumdogMillionaire = new Movie("Slumdog Millionaire", Movie.NEW_RELEASE);
    }
    @Test
    public void testGetPriceCode() {
        assertEquals(Movie.REGULAR, theManWhoKnewTooMuch.getPriceCode());
    }
     */
}
