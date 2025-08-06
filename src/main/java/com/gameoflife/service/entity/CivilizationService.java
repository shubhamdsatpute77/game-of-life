package com.gameoflife.service.entity;

import com.gameoflife.entity.Civilization;
import com.gameoflife.entity.Generation;
import com.gameoflife.pojo.Position;

import java.util.List;

public class CivilizationService {

    public static CivilizationService geInstance() {
        return new CivilizationService();
    }

    public Civilization createNewCivilization(List<Position> livingCellPositions, int gridSize) {
        Generation seedGeneration = GenerationService.geInstance().getSeedGeneration(livingCellPositions, gridSize);
        return new Civilization(seedGeneration);
    }

    public Civilization getNextCivilizationState(Civilization civilization) {
        Generation nextGeneration = GenerationService.geInstance().getNextGeneration(civilization.getCurrentGeneration());
        civilization.setCurrentGeneration(nextGeneration);
        civilization.getAllGenerations().add(nextGeneration);
        return civilization;
    }
}
