package com.gameoflife.life.criteria;

import com.gameoflife.entity.Cell;
import com.gameoflife.life.LifeStateType;

public interface LifeCriteria {

    LifeStateType getLivingState(Cell cell, int aliveNeighborsCount);

    boolean isApplicable(int aliveNeighborsCount);

}
