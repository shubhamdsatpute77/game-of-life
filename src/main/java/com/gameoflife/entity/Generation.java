package com.gameoflife.entity;

import com.gameoflife.life.GenerationStateType;

public class Generation {

    private int order;
    private GenerationStateType state;
    private Cell[][] cells;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public GenerationStateType getState() {
        return state;
    }

    public void setState(GenerationStateType state) {
        this.state = state;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
