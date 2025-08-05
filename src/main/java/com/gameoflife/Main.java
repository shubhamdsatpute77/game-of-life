package com.gameoflife;

import com.gameoflife.entity.Cell;
import com.gameoflife.entity.Civilization;
import com.gameoflife.life.LifeStateType;
import com.gameoflife.service.CellService;
import com.gameoflife.service.CivilizationService;

public class Main {
    public static void main(String[] args) {

        int[][] initialState = {
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        Cell[][] cells = new Cell[initialState.length][initialState[0].length];
        CellService cellService = new CellService();

        for (int i = 0; i < initialState.length; i++) {
            for (int j = 0; j < initialState[i].length; j++) {
                cells[i][j] = cellService.getNewCell(i, j, initialState[i][j] == 1 ? LifeStateType.ALIVE : LifeStateType.DEAD);
            }
        }

        CivilizationService civilizationService = new CivilizationService();
        Civilization civilization = civilizationService.createNewCivilization(cells, 2);
        printCells(civilization);

        Civilization nextCivilization = civilizationService.getNextCivilizationState(civilization);
        printCells(nextCivilization);
    }

    private static void printCells(Civilization nextCivilization) {
        System.out.println("------------------------------------------------");
        for (int i = 0; i < nextCivilization.getCurrentGeneration().getCells().length; i++) {
            for (int j = 0; j < nextCivilization.getCurrentGeneration().getCells()[i].length; j++) {
                Cell cell = nextCivilization.getCurrentGeneration().getCells()[i][j];
                System.out.print(cell.getLifeState() == LifeStateType.ALIVE ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
}