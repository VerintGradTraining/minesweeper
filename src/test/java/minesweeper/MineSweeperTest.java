package minesweeper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class MineSweeperTest {

    @Test
    public void fourByFourGameShouldHaveWidthOfFourAndHeightOfFour() {
        MineSweeper mineSweeper = new MineSweeper(4, 4);
        assertThat(mineSweeper.width(), is(4));
        assertThat(mineSweeper.height(), is(4));
    }

    @Test
    public void threeBySixGameShouldHaveWidthOfThreeAndHeightOfSix() {
        MineSweeper mineSweeper = new MineSweeper(3, 6);
        assertThat(mineSweeper.width(), is(3));
        assertThat(mineSweeper.height(), is(6));
    }

    @Test
    public void allSquaresShouldBeHiddenWhenGameBegins() {
        MineSweeper mineSweeper = new MineSweeper(3, 5);
        for (int yPosition = 0; yPosition < mineSweeper.height(); yPosition++) {
            for (int xPosition = 0; xPosition < mineSweeper.width(); xPosition++) {
                assertThat(mineSweeper.squareState(xPosition, yPosition), is(SquareState.HIDDEN));
            }
        }
    }

    @Test
    public void fourByEightGameWithTwelveRequestedMinesShouldHaveTwelveMines() {
        MineSweeper mineSweeper = new MineSweeper(4, 8, 12);
        assertThat(mineSweeper.mineCount(), is(12));
    }

    @Test
    public void defaultMineCountShouldBeHalfTheGridSize() {
        MineSweeper mineSweeper = new MineSweeper(10, 10);
        assertThat(mineSweeper.mineCount(), is(50));
    }

    @Test
    public void defaultMineCountShouldBeRoundedDownWhenOddGridSize() {
        MineSweeper mineSweeper = new MineSweeper(9, 9);
        assertThat(mineSweeper.mineCount(), is(40));
    }

    @Test
    public void maximumMineCountShouldBeGridSizeMinusOne() {
        MineSweeper mineSweeper = new MineSweeper(10, 10, 100);
        assertThat(mineSweeper.mineCount(), is(99));
    }

}
