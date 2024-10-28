package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private Car car1;
    private Car car2;
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        Car.resetNames();
        car1 = new Car("pobi");
        car2 = new Car("woni");
        racingGame = new RacingGame(Arrays.asList(car1, car2));
    }

    @Test
    void 자동차가_전진하거나_멈추는지_확인() {
        racingGame.playRound();

        assertThat(car1.getPosition()).isBetween(0, 1);
        assertThat(car2.getPosition()).isBetween(0, 1);
    }

    @Test
    void 여러_라운드_후_자동차_위치_확인() {
        int totalRounds = 3;
        for (int i = 0; i < totalRounds; i++) {
            racingGame.playRound();
        }

        assertThat(car1.getPosition()).isBetween(0, totalRounds);
        assertThat(car2.getPosition()).isBetween(0, totalRounds);
    }
}