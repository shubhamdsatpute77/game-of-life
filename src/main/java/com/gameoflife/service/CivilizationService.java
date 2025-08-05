package com.gameoflife.service;

import com.gameoflife.entity.Cell;
import com.gameoflife.entity.Civilization;
import com.gameoflife.entity.Generation;
import com.gameoflife.life.GenerationStateType;

import static com.gameoflife.entity.Generation.SEED_GENERATION;

public class CivilizationService {

    public Civilization createNewCivilization(Cell[][] cells, int generationCount) {
        GenerationService generationService = new GenerationService();
        Civilization civilization = new Civilization();
        Generation[] allGenerations = new Generation[generationCount];
        Generation generation = generationService.getNewGeneration(cells, GenerationStateType.SEED, SEED_GENERATION);
        civilization.setSeedGeneration(generation);
        civilization.setCurrentGeneration(generation);
        civilization.setAllGenerations(allGenerations);
        return civilization;
    }

    public Civilization getNextCivilizationState(Civilization civilization) {
        GenerationService generationService = new GenerationService();
        Generation nextGeneration = generationService.getNextGeneration(civilization.getCurrentGeneration());
        civilization.setCurrentGeneration(nextGeneration);
        civilization.getAllGenerations()[nextGeneration.getOrder()] = nextGeneration;
        return civilization;
    }
}
