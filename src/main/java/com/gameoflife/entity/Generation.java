package com.gameoflife.entity;

import com.gameoflife.life.GenerationStateType;
import com.gameoflife.pojo.Population;

public class Generation {

    private int order;
    private GenerationStateType state;
    private Population population;

    public Generation(Population population, GenerationStateType state, int order) {
        this.population = population;
        this.state = state;
        this.order = order;
    }

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

    public Cell[][] getAllCells() {
        return population.getCellGrid();
    }

    public int[][] getNeighbourCountMatrix() {
        return population.getNeighbourCountMatrix();
    }

    public int getPopulationRows() {
        return population.getCellGrid().length;
    }

    public int getPopulationColumns(int row) {
        return population.getCellGrid()[row].length;
    }

    public int getPopulationColumns() {
        return population.getCellGrid()[0].length;
    }

    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }
}
