package separation.example2;

public class Movie {

    private MovieType movieType;

    public Movie(MovieType movieType) {
        this.movieType = movieType;
    }

    public int getFrequentRenterPoints(int daysRented) {
        return movieType.getFrequentRenterPoints(daysRented);
    }
}
