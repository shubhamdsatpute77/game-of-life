package com.gameoflife.service.entity;

import com.gameoflife.entity.Cell;
import com.gameoflife.life.LifeStateType;
import com.gameoflife.life.criteria.LifeCriteriaEnum;
import com.gameoflife.pojo.Population;
import com.gameoflife.pojo.Position;
import com.gameoflife.service.helper.NeighbourService;

import java.util.List;

public class CellService {

    public static CellService getInstance() {
        return new CellService();
    }

    public Cell getNextGenerationCell(Cell currentCell, Population currentPopulation) {
        return new Cell(getNextGenerationCellState(currentCell, currentPopulation), new Position(currentCell.getPositionX(), currentCell.getPositionY()));
    }

    public LifeStateType getNextGenerationCellState(Cell cell, Population currentPopulation) {
        NeighbourService neighbourService = new NeighbourService();
        int aliveNeighourCount = neighbourService.getAliveNeighourCount(cell, currentPopulation);
        for (LifeCriteriaEnum criteria : LifeCriteriaEnum.values()) {
            if (criteria.getLifeCriteria().isApplicable(aliveNeighourCount)) {
                return criteria.getLifeStateType();
            }
        }
        return cell.getLifeState();
    }

    public Cell[][] getCellGrid(List<Position> livingCellPositions, int gridSize) {
        Cell[][] cellGrid = getDeadCellGrid(gridSize);
        for (Position position : livingCellPositions) {
            if (position.getX() < gridSize && position.getY() < gridSize) {
                cellGrid[position.getX()][position.getY()].setLifeState(LifeStateType.ALIVE);
            }
        }
        return cellGrid;
    }

    public Cell[][] getDeadCellGrid(int gridSize) {
        Cell[][] deadCellGrid = new Cell[gridSize][gridSize];
        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                deadCellGrid[x][y] = new Cell(LifeStateType.DEAD, new Position(x, y));
            }
        }
        return deadCellGrid;
    }

    public Cell[][] getNextGenerationCellGrid(Population currentPopulation) {
        int gridSize = currentPopulation.getGridSize();
        Cell[][] nextGenCells = new Cell[gridSize][gridSize];
        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                Position position = new Position(x, y);
                nextGenCells[x][y] = getNextGenerationCell(currentPopulation.getCell(position), currentPopulation); // Assuming currentGeneration is not needed here
            }
        }
        return nextGenCells;
    }
}
