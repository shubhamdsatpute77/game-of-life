package com.gameoflife.service;

import com.gameoflife.entity.Cell;

public class SocietyService {

    public int getAliveNeighourCount(Cell mainCell, Cell[][] allCells) {
        int aliveNeighbors = 0;
        for (int i = mainCell.getX() - 1; i <= mainCell.getX() + 1; i++) {
            for (int j = mainCell.getY() - 1; j <= mainCell.getY() + 1; j++) {
                if (isNeighbour(allCells, mainCell, i, j) && isNeighnourAlive(allCells, i, j)) {
                    aliveNeighbors++;
                }
            }
        }
        return aliveNeighbors;
    }

    public boolean isNeighbour(Cell[][] allCells, Cell mainCell, int x, int y) {
        return isValidCell(allCells, x, y) && !(x == mainCell.getX() && y == mainCell.getY());
    }

    public boolean isNeighnourAlive(Cell[][] allCells, int x, int y) {
        return isValidCell(allCells, x, y) && allCells[x][y].isAlive();
    }

    public boolean isValidCell(Cell[][] allCells, int x, int y) {
        return !(x < 0 || x >= allCells.length || y < 0 || y >= allCells[0].length);
    }

}
