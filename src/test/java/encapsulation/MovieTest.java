package encapsulation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovieTest {

    @Test
    public void isNewRelease() throws Exception {
        //given
        Movie movie = new Movie(MovieType.NEW_RELEASE);

        //when
        boolean newRelease = movie.isNewRelease();

        //then
        assertThat(newRelease).isTrue();
    }

    @Test
    public void isNewRelease_NonNewRelease() throws Exception {
        //given
        Movie movie = new Movie(MovieType.REGULAR);

        //when
        boolean newRelease = movie.isNewRelease();

        //then
        assertThat(newRelease).isFalse();
    }
}