package com.gameoflife.service;

import com.gameoflife.entity.Cell;
import com.gameoflife.life.LifeStateType;
import com.gameoflife.life.criteria.LifeCriteriaEnum;

public class CellService {

    public Cell getNewCell(int x, int y, LifeStateType lifeState) {
        Cell cell = new Cell();
        cell.setX(x);
        cell.setY(y);
        cell.setLifeState(lifeState);
        return cell;
    }

    public Cell getNextGenerationCell(Cell cell, Cell[][] allCells) {
        return getNewCell(cell.getX(), cell.getY(), getNextGenerationCellState(cell, allCells));
    }

    public LifeStateType getNextGenerationCellState(Cell cell, Cell[][] allCells) {
        NeighbourService neighbourService = new NeighbourService();
        int aliveNeighourCount = neighbourService.getAliveNeighourCount(cell, allCells);
        for (LifeCriteriaEnum criteria : LifeCriteriaEnum.values()) {
            if (criteria.getLifeCriteria().isApplicable(aliveNeighourCount)) {
                return criteria.getLifeStateType();
            }
        }
        return cell.getLifeState();
    }
}
