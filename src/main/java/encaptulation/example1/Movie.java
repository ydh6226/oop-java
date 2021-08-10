package encaptulation.example1;

public class Movie {

    private MovieType movieType;

    public Movie(MovieType movieType) {
        this.movieType = movieType;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if (movieType == MovieType.NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
