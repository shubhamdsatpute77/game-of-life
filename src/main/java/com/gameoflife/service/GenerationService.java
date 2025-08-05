package com.gameoflife.service;

import com.gameoflife.entity.Cell;
import com.gameoflife.entity.Generation;
import com.gameoflife.life.GenerationStateType;

public class GenerationService {

    public Generation getNewGeneration(Cell[][] cells, GenerationStateType generationState, int order) {
        Generation newGeneration = new Generation();
        newGeneration.setCells(cells);
        newGeneration.setState(generationState);
        newGeneration.setOrder(order);
        return newGeneration;
    }


    public Generation getNextGeneration(Generation currentGeneration) {
        CellService cellService = new CellService();
        Cell[][] currentCell = currentGeneration.getCells();
        Cell[][] nextGenCells = new Cell[currentCell.length][currentCell[0].length];
        for (int i = 0; i < currentCell.length; i++) {
            for (int j = 0; j < currentCell[i].length; j++) {
                Cell cell = currentCell[i][j];
                nextGenCells[i][j] = cellService.getNextGenerationCell(cell, currentCell);
            }
        }
        return getNewGeneration(nextGenCells, GenerationStateType.AFTER_SEED,currentGeneration.getOrder() + 1);
    }
}
