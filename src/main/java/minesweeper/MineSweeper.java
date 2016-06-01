package minesweeper;

public class MineSweeper {

    private int width;
    private int height;
    private int mineCount;

    public MineSweeper(int width, int height) {
        this(width, height, calculateDefaultMineCount(width, height));
    }

    public MineSweeper(int width, int height, int mineCount) {
        this.width = width;
        this.height = height;
        int maximumMineCount = maximumMineCount(width, height);
        if (mineCount < maximumMineCount) {
            this.mineCount = mineCount;
        } else {
            this.mineCount = maximumMineCount;
        }
    }

    private static int maximumMineCount(int width, int height) {
        return width * height - 1;
    }

    public int width() {
        return this.width;
    }

    public int height() {
        return this.height;
    }

    public SquareState squareState(int xPosition, int yPosition) {
        return SquareState.HIDDEN;
    }

    public int mineCount() {
        return this.mineCount;
    }

    private static int calculateDefaultMineCount(int width, int height) {
        return width * height / 2;
    }
}
