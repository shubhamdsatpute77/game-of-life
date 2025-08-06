package com.gameoflife.entity;

import java.util.ArrayList;
import java.util.List;

public class Civilization {

    private Generation seedGeneration;
    private Generation currentGeneration;
    private List<Generation> allGenerations;

    public Civilization(Generation seedGeneration) {
        this.seedGeneration = seedGeneration;
        this.currentGeneration = seedGeneration;
        this.allGenerations = new ArrayList<>();
    }

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

    public List<Generation> getAllGenerations() {
        return allGenerations;
    }

    public Generation getNthGeneration(int order) {
        return allGenerations.get(order - 1);
    }
}
