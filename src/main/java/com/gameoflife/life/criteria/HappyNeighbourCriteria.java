package com.gameoflife.life.criteria;

import com.gameoflife.entity.Cell;
import com.gameoflife.life.LifeStateType;

public class HappyNeighbourCriteria  implements BirthCriteria {
    public static final int HAPPY_NEIGHBOUR_COUNT = 3;

    @Override
    public LifeStateType getLivingState(Cell cell, int aliveNeighborsCount) {
        if (aliveNeighborsCount == HAPPY_NEIGHBOUR_COUNT) {
            return LifeStateType.ALIVE;
        }
        return cell.getLifeState();
    }

    @Override
    public boolean isApplicable(int aliveNeighborsCount) {
        return aliveNeighborsCount == HAPPY_NEIGHBOUR_COUNT;
    }
}
