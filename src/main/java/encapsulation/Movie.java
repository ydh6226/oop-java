package encapsulation;

public class Movie {

    private MovieType movieType;

    public Movie(MovieType movieType) {
        this.movieType = movieType;
    }

    public boolean isNewRelease() {
        return movieType == MovieType.NEW_RELEASE;
    }
}
