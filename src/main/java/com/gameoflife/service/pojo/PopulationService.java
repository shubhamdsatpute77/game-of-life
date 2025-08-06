package com.gameoflife.service.pojo;

import com.gameoflife.entity.Cell;
import com.gameoflife.pojo.Population;
import com.gameoflife.pojo.Position;
import com.gameoflife.service.entity.CellService;
import com.gameoflife.service.helper.NeighbourService;

import java.util.List;

public class PopulationService {

    public static PopulationService getInstance() {
        return new PopulationService();
    }

    public Population getNewPopulation(List<Position> livingCellPositions, int gridSize) {
        Cell[][] cellGrid = CellService.getInstance().getCellGrid(livingCellPositions, gridSize);
        int[][] neighbourCountMatrix = NeighbourService.getInstance().getNeighbourCountMatrix(cellGrid, gridSize);
        return new Population(cellGrid, neighbourCountMatrix, gridSize);
    }

    public Population getNextGenerationPopulation(Population currentPopulation) {
        Cell[][] nextGenCells = CellService.getInstance().getNextGenerationCellGrid(currentPopulation);
        int[][] neighbourCountMatrix = NeighbourService.getInstance().getNeighbourCountMatrix(nextGenCells, currentPopulation.getGridSize());
        return new Population(nextGenCells, neighbourCountMatrix, currentPopulation.getGridSize());
    }
}
