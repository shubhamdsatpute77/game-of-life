package com.gameoflife.life.criteria;

import com.gameoflife.entity.Cell;
import com.gameoflife.life.LifeStateType;

public class LonelinessDeath implements DeathCriteria {
    public static final int LONELINESS_NEIGHBOUR_COUNT = 2;


    @Override
    public LifeStateType getLivingState(Cell cell, int aliveNeighborsCount) {
        if (isApplicable(aliveNeighborsCount)) {
            return LifeStateType.DEAD;
        }
        return cell.getLifeState();
    }

    @Override
    public boolean isApplicable(int aliveNeighborsCount) {
        return aliveNeighborsCount < LONELINESS_NEIGHBOUR_COUNT;
    }
}
