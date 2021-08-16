package separation.example2;

import lombok.RequiredArgsConstructor;

import java.util.function.IntUnaryOperator;

@RequiredArgsConstructor
public enum MovieType {
    REGULAR(daysRented -> 1),
    NEW_RELEASE(daysRented -> daysRented > 1 ? 2 : 1);

    private final IntUnaryOperator operator;

    public int getFrequentRenterPoints(int daysRented) {
        return operator.applyAsInt(daysRented);
    }
}
