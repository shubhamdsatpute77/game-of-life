package com.gameoflife.entity;

public class Civilization {

    private Generation seedGeneration;
    private Generation currentGeneration;
    private Generation[] allGenerations;

    public Generation getSeedGeneration() {
        return seedGeneration;
    }

    public void setSeedGeneration(Generation seedGeneration) {
        this.seedGeneration = seedGeneration;
    }

    public Generation getCurrentGeneration() {
        return currentGeneration;
    }

    public void setCurrentGeneration(Generation currentGeneration) {
        this.currentGeneration = currentGeneration;
    }

    public Generation[] getAllGenerations() {
        return allGenerations;
    }

    public void setAllGenerations(Generation[] allGenerations) {
        this.allGenerations = allGenerations;
    }
}
