package controller;

/**
 * Class Island has two-dimensional array for world game.
 */
public class Island {
    /**
     * Island length must be at least x - 5 and y - 5
     */
    private static final int SIZE_X = 5;
    private static final int SIZE_Y = 5;
    private static final Cell[][] CELLS = new Cell[SIZE_X][SIZE_Y];
    private static Island island;

    private Island() {

    }

    public static Island getInstanceIsland() {
        if (island == null) {
            island = new Island();
        }
        return island;
    }

    public int getCellCoordinateXLength() {
        return CELLS.length;
    }

    public int getCellCoordinateYLength() {
        return CELLS[0].length;
    }

    public synchronized Cell getCells(Coordinate coordinate) {
        if (!(cellIsNotNull(coordinate))) {
            CELLS[coordinate.getCoordinateX()][coordinate.getCoordinateY()] = new Cell();
        }
        return CELLS[coordinate.getCoordinateX()][coordinate.getCoordinateY()];
    }

    public synchronized void setCells(Coordinate coordinate, Cell cell) {
        CELLS[coordinate.getCoordinateX()][coordinate.getCoordinateY()] = cell;
    }

    private boolean cellIsNotNull(Coordinate coordinate) {
        return CELLS[coordinate.getCoordinateX()][coordinate.getCoordinateY()] != null;
    }

    public synchronized Cell[][] getCELLS() {
        return CELLS;
    }

}
