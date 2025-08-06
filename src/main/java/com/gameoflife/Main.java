package com.gameoflife;

import com.gameoflife.entity.Cell;
import com.gameoflife.entity.Civilization;
import com.gameoflife.life.LifeStateType;
import com.gameoflife.pojo.Position;
import com.gameoflife.service.entity.CivilizationService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Position> livingPositions = List.of(
                new Position(1, 1),
                new Position(1, 2),
                new Position(1, 3),
                new Position(2, 2),
                new Position(2, 3),
                new Position(2, 4)
        );

        CivilizationService civilizationService = CivilizationService.geInstance();
        Civilization civilization = civilizationService.createNewCivilization(livingPositions, 5);
        printCells(civilization);

        Civilization nextCivilization = civilizationService.getNextCivilizationState(civilization);
        printCells(nextCivilization);
    }

    private static void printCells(Civilization nextCivilization) {
        System.out.println("------------------------------------------------");
        for (int i = 0; i < nextCivilization.getCurrentGeneration().getAllCells().length; i++) {
            for (int j = 0; j < nextCivilization.getCurrentGeneration().getAllCells()[i].length; j++) {
                Cell cell = nextCivilization.getCurrentGeneration().getAllCells()[i][j];
                System.out.print(cell.getLifeState() == LifeStateType.ALIVE ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
}