package com.gameoflife;

import com.gameoflife.entity.Cell;
import com.gameoflife.entity.CellGrid;
import com.gameoflife.life.CellStateType;
import com.gameoflife.entity.Position;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Position> livingPositions = List.of(
                new Position(1, 1),
                new Position(1, 2),
                new Position(2, 1),
                new Position(2, 2)
        );

        CellGrid currentCellGrid = new CellGrid(livingPositions, 4);
        printCells(currentCellGrid);

        CellGrid nextGenerationCellGrid = currentCellGrid.getNextGenerationCellGrid();
        printCells(nextGenerationCellGrid);

    }

    private static void printCells(CellGrid cellGrid) {
        System.out.println("------------------------------------------------");
        for (int i = 0; i < cellGrid.getCellGrid().length; i++) {
            for (int j = 0; j < cellGrid.getCellGrid()[i].length; j++) {
                Cell cell = cellGrid.getCellGrid()[i][j];
                System.out.print(cell.getState() == CellStateType.ALIVE ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
}