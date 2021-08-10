package encaptulation.example1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovieTest {

    @Test
    public void getFrequentRenterPoints_NewReleaseAndMoreThanOneDay() throws Exception {
        //given
        Movie movie = new Movie(MovieType.NEW_RELEASE);
        int daysRented = 10;

        //when
        int frequentRenterPoints = movie.getFrequentRenterPoints(daysRented);

        //then
        assertThat(frequentRenterPoints).isEqualTo(2);
    }

    @Test
    public void getFrequentRenterPoints_NewReleaseAndLessThanOneDay() throws Exception {
        //given
        Movie movie = new Movie(MovieType.NEW_RELEASE);
        int daysRented = 1;

        //when
        int frequentRenterPoints = movie.getFrequentRenterPoints(daysRented);

        //then
        assertThat(frequentRenterPoints).isEqualTo(1);
    }

    @Test
    public void getFrequentRenterPoints_RegularAndMoreThanOneDay() throws Exception {
        //given
        Movie movie = new Movie(MovieType.REGULAR);
        int daysRented = 10;

        //when
        int frequentRenterPoints = movie.getFrequentRenterPoints(daysRented);

        //then
        assertThat(frequentRenterPoints).isEqualTo(1);
    }
}