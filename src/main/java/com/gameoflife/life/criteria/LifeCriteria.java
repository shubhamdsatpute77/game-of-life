package com.gameoflife.life.criteria;


@FunctionalInterface
public interface LifeCriteria {

    boolean isApplicable(int aliveNeighborsCount);

}
