package encapsulation2;

import java.time.Duration;
import java.time.LocalDateTime;

public class Timer {

    private LocalDateTime startTime;
    private LocalDateTime stopTime;

    public void start() {
        if (stopTime != null) {
            throw new IllegalStateException();
        }
        startTime = LocalDateTime.now();
    }

    public void stop() {
        if (startTime == null) {
            throw new IllegalStateException();
        }
        stopTime = LocalDateTime.now();
    }

    public void prettyPrint() {
        Duration elaspedTime = Duration.between(startTime, startTime);
        System.out.println("경과시간: " + elaspedTime);
    }
}
