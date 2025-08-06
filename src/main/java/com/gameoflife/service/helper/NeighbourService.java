package com.gameoflife.service.helper;

import com.gameoflife.entity.Cell;
import com.gameoflife.pojo.Colony;
import com.gameoflife.pojo.Population;
import com.gameoflife.pojo.Position;

public class NeighbourService {

    public static NeighbourService getInstance() {
        return new NeighbourService();
    }

    public int getAliveNeighourCount(Cell headCell, Population population) {
        return population.getNeighbourCountMatrix()[headCell.getPositionX()][headCell.getPositionY()];
    }

    public int[][] getNeighbourCountMatrix(Cell[][] cellGrid, int gridSize) {
        int[][] neighbourCountMatrix = new int[gridSize][gridSize];
        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                Cell headCell = cellGrid[x][y];
                neighbourCountMatrix = increamentNeighbourCountIfCellIsAlive(neighbourCountMatrix, headCell, gridSize);
            }
        }
        return neighbourCountMatrix;
    }

    public int[][] increamentNeighbourCountIfCellIsAlive(int[][] neighbourCountMatrix, Cell headCell, int gridSize) {
        if (headCell.isAlive()) {
            increamentNeighbourCount(neighbourCountMatrix, headCell, gridSize);
        }
        return neighbourCountMatrix;
    }

    private void increamentNeighbourCount(int[][] neighbourCountMatrix, Cell headCell, int gridSize) {
        Colony colony = new Colony(headCell);
        int colonyWidthAroundHead = colony.getWidthAroundHeadCell();
        for (int xWRTHead = -colonyWidthAroundHead; xWRTHead <= colonyWidthAroundHead; xWRTHead++) {
            for (int yWRTHead = -colonyWidthAroundHead; yWRTHead <= colonyWidthAroundHead; yWRTHead++) {
                int neighbourPositionX = headCell.getPositionX() + xWRTHead;
                int neighbourPositionY = headCell.getPositionY() + yWRTHead;
                Position neighbourPosition = new Position(neighbourPositionX, neighbourPositionY);
                if (isNeighbourExist(neighbourPosition, gridSize) && !isHeadCell(neighbourPosition, colony)) {
                    neighbourCountMatrix[neighbourPositionX][neighbourPositionY] += 1;
                }
            }
        }
    }

    public boolean isNeighbourExist(Position neighbourPosition,
                                    int gridSize) {
        return neighbourPosition.getX() >= 0 && neighbourPosition.getX() < gridSize
                && neighbourPosition.getY() >= 0 && neighbourPosition.getY() < gridSize;
    }

    public boolean isHeadCell(Position position, Colony colony) {
        return position.getX() == colony.getHeadCell().getPositionX()
                && position.getY() == colony.getHeadCell().getPositionY();
    }
}
