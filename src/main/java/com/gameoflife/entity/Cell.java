package com.gameoflife.entity;

import com.gameoflife.life.CellStateType;
import com.gameoflife.life.criteria.LifeCriteriaEnum;

public class Cell {

    private CellStateType state;
    private int x;
    private int y;

    public Cell(CellStateType state, int x, int y) {
        this.state = state;
        this.x = x;
        this.y = y;
    }

    public CellStateType getState() {
        return state;
    }

    public void setState(CellStateType state) {
        this.state = state;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isAlive() {
        return state == CellStateType.ALIVE;
    }

    public boolean isDead() {
        return state == CellStateType.DEAD;
    }

    public Cell getNextGenCell(int aliveNeighourCount) {
        return new Cell(getNextGenCellState(aliveNeighourCount), getX(), getY());
    }

    public CellStateType getNextGenCellState(int aliveNeighourCount) {
        for (LifeCriteriaEnum criteria : LifeCriteriaEnum.values()) {
            if (criteria.getLifeCriteria().isApplicable(aliveNeighourCount)) {
                return criteria.getLifeStateType();
            }
        }
        return getState();
    }
}
