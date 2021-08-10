package encapsulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RentalTest {

    @Test
    public void getFrequentRenterPoints_NewReleaseAndMoreThanOneDay() throws Exception {
        //given
        int daysRented = 10;
        Movie movie = new Movie(MovieType.NEW_RELEASE);
        Rental rental = new Rental(movie, daysRented);

        //when
        int frequentRenterPoints = rental.getFrequentRenterPoints();

        //then
        assertThat(frequentRenterPoints).isEqualTo(2);
    }

    @Test
    public void getFrequentRenterPoints_NewReleaseAndLessThanOneDay() throws Exception {
        //given
        int daysRented = 1;
        Movie movie = new Movie(MovieType.NEW_RELEASE);
        Rental rental = new Rental(movie, daysRented);

        //when
        int frequentRenterPoints = rental.getFrequentRenterPoints();

        //then
        assertThat(frequentRenterPoints).isEqualTo(1);
    }

    @Test
    public void getFrequentRenterPoints_RegularAndMoreThanOneDay() throws Exception {
        //given
        int daysRented = 10;
        Movie movie = new Movie(MovieType.REGULAR);
        Rental rental = new Rental(movie, daysRented);

        //when
        int frequentRenterPoints = rental.getFrequentRenterPoints();

        //then
        assertThat(frequentRenterPoints).isEqualTo(1);
    }

}