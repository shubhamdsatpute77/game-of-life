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
        Cell nextGenCell = new Cell();
        nextGenCell.setX(cell.getX());
        nextGenCell.setY(cell.getY());
        nextGenCell.setLifeState(getNextGenerationCellState(cell, allCells));
        return nextGenCell;
    }

    public LifeStateType getNextGenerationCellState(Cell cell, Cell[][] allCells) {
        SocietyService societyService = new SocietyService();
        int aliveNeighourCount = societyService.getAliveNeighourCount(cell, allCells);
        for (LifeCriteriaEnum criteria : LifeCriteriaEnum.values()) {
            if (criteria.getLifeCriteria().isApplicable(aliveNeighourCount)) {
                return criteria.getLifeCriteria().getLivingState(cell, aliveNeighourCount);
            }
        }
        return cell.getLifeState();
    }
}
