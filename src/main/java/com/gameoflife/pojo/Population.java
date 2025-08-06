package com.gameoflife.pojo;

import com.gameoflife.entity.Cell;

public class Population {
    private Cell[][] cellGrid;
    private int[][] neighbourCountMatrix;
    private int gridSize;

    public Population(Cell[][] cellGrid,
                      int[][] neighbourCountMatrix,
                      int gridSize) {
        this.cellGrid = cellGrid;
        this.neighbourCountMatrix = neighbourCountMatrix;
        this.gridSize = gridSize;
    }

    public Cell[][] getCellGrid() {
        return cellGrid;
    }

    public void setCellGrid(Cell[][] cellGrid) {
        this.cellGrid = cellGrid;
    }

    public int[][] getNeighbourCountMatrix() {
        return neighbourCountMatrix;
    }

    public void setNeighbourCountMatrix(int[][] neighbourCountMatrix) {
        this.neighbourCountMatrix = neighbourCountMatrix;
    }

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    public Cell getCell(Position position) {
        return cellGrid[position.getX()][position.getY()];
    }
}
