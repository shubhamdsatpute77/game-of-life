package com.gameoflife.service.entity;

import com.gameoflife.entity.Generation;
import com.gameoflife.life.GenerationStateType;
import com.gameoflife.pojo.Population;
import com.gameoflife.pojo.Position;
import com.gameoflife.service.pojo.PopulationService;

import java.util.List;

public class GenerationService {

    public static GenerationService geInstance() {
        return new GenerationService();
    }

    public Generation getSeedGeneration(List<Position> livingCellPositions, int gridSize) {
        return getNewGeneration(livingCellPositions, GenerationStateType.SEED, gridSize, 0);
    }

    public Generation getNewGeneration(List<Position> livingCellPositions,
                                       GenerationStateType generationState,
                                       int gridSize,
                                       int order) {
        Population population = PopulationService.getInstance().getNewPopulation(livingCellPositions, gridSize);
        return new Generation(population, generationState, order);
    }

    public Generation getNextGeneration(Generation currentGeneration) {
        Population population = PopulationService.getInstance().getNextGenerationPopulation(currentGeneration.getPopulation());
        return new Generation(population, GenerationStateType.AFTER_SEED,currentGeneration.getOrder() + 1);
    }
}
