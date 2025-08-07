package com.gameoflife.entity;

import com.gameoflife.life.CellStateType;

import java.util.List;

public class CellGrid {
    private Cell[][] cellGrid;
    private int gridSize;
    private int[][] neighbourCountMatrix;

    public CellGrid(List<Position> livingCellPositions, int gridSize) {
        this.cellGrid = getCellGrid(livingCellPositions, gridSize);
        this.gridSize = gridSize;
        this.neighbourCountMatrix = getNeighbourCountMatrix();
    }

    public CellGrid(Cell[][] cellGrid, int gridSize) {
        this.cellGrid = cellGrid;
        this.gridSize = gridSize;
        this.neighbourCountMatrix = getNeighbourCountMatrix();
    }

    public Cell[][] getCellGrid() {
        return cellGrid;
    }

    public void setCellGrid(Cell[][] cellGrid) {
        this.cellGrid = cellGrid;
    }

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    public Cell getCell(int x, int y) {
        return cellGrid[x][y];
    }

    public int[][] getNeighbourCountMatrix() {
        int[][] neighbourCountMatrix = new int[gridSize][gridSize];
        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                Cell cell = getCell(x, y);
                increamentNeighbourCountIfCellIsAlive(neighbourCountMatrix, cell);
            }
        }
        return neighbourCountMatrix;
    }

    public int[][] increamentNeighbourCountIfCellIsAlive(int[][] neighbourCountMatrix, Cell cell) {
        if (cell.isAlive()) {
            increamentNeighbourCount(neighbourCountMatrix, cell);
        }
        return neighbourCountMatrix;
    }

    private void increamentNeighbourCount(int[][] neighbourCountMatrix, Cell cell) {
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                int neighbourX = cell.getX() + x;
                int neighbourY = cell.getY() + y;
                if (!(x == 0 && y == 0) && isNeighbourExist(neighbourX, neighbourY)) {
                    neighbourCountMatrix[neighbourX][neighbourY]++;
                }
            }
        }
    }

    public boolean isNeighbourExist(int x, int y) {
        return x >= 0 && x < gridSize && y >= 0 && y < gridSize;
    }

    public Cell[][] getCellGrid(List<Position> livingCellPositions, int gridSize) {
        Cell[][] cellGrid = getDeadCellGrid(gridSize);
        for (Position position : livingCellPositions) {
            if (position.getX() < gridSize && position.getY() < gridSize) {
                cellGrid[position.getX()][position.getY()].setState(CellStateType.ALIVE);
            }
        }
        return cellGrid;
    }

    public Cell[][] getDeadCellGrid(int gridSize) {
        Cell[][] deadCellGrid = new Cell[gridSize][gridSize];
        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                deadCellGrid[x][y] = new Cell(CellStateType.DEAD, x, y);
            }
        }
        return deadCellGrid;
    }

    public CellGrid getNextGenerationCellGrid() {
        Cell[][] nextGenCells = new Cell[gridSize][gridSize];
        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                Cell currentCell = getCell(x, y);
                int aliveNeighourCount = neighbourCountMatrix[x][y];
                nextGenCells[x][y] = currentCell.getNextGenCell(aliveNeighourCount);
            }
        }
        return new CellGrid(nextGenCells, gridSize);
    }
}
