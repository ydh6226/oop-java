package encapsulation;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getFrequentRenterPoints() {
        if (movie.isNewRelease() && isDaysRentedMoreThanOneDay()) {
            return 2;
        }
        return 1;
    }

    private boolean isDaysRentedMoreThanOneDay() {
        return daysRented > 1;
    }
}
