package com.gameoflife;

public class Main {

    public static void main(String[] args) {

        int[][] cells = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        int gridSize = 5;
        printCells(cells, gridSize);

        int[][] nextGenerationCells = getNextGenerationCells(cells, gridSize);
        printCells(nextGenerationCells, gridSize);

    }

    private static int[][] getNextGenerationCells(int[][] cells, int gridSize) {
        int[][] nextGenerationCells = new int[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                int aliveNeighbourCount = getAliveNeighboursCount(cells, i, j, gridSize);
                if (cells[i][j] == 1) {
                    nextGenerationCells[i][j] = (aliveNeighbourCount < 2 || aliveNeighbourCount > 3) ? 0 : 1;
                } else {
                    nextGenerationCells[i][j] = (aliveNeighbourCount == 3) ? 1 : 0;
                }
            }
        }
        return nextGenerationCells;
    }

    private static int getAliveNeighboursCount(int[][] cells, int x, int y, int gridSize) {
        int aliveCount = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {continue;}
                int neighbourX = x + i;
                int neighbourY = y + j;
                if (neighbourX >= 0 && neighbourX < gridSize && neighbourY >= 0 && neighbourY < gridSize) {
                    aliveCount += cells[neighbourX][neighbourY];
                }

            }
        }
        return aliveCount;
    }

    private static void printCells(int[][] cells, int gridSize) {
        System.out.println("------------------------------------------------");
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }
    }
}