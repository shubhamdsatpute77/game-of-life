package com.gameoflife.life.criteria;

import com.gameoflife.entity.Cell;
import com.gameoflife.life.LifeStateType;

public class CrowdedDeath implements DeathCriteria {
    public static final int CROWDED_NEIGHBOUR_COUNT = 3;


    @Override
    public LifeStateType getLivingState(Cell cell, int aliveNeighborsCount) {
        if (isApplicable(aliveNeighborsCount)) {
            return LifeStateType.DEAD;
        }
        return cell.getLifeState();
    }

    @Override
    public boolean isApplicable(int aliveNeighborsCount) {
        return aliveNeighborsCount > CROWDED_NEIGHBOUR_COUNT;
    }
}
