package com.gameoflife.life.criteria;

import static com.gameoflife.life.criteria.LifeCriteriaConstants.*;

public class LifeCriteriaImpl {
    public static LifeCriteria DEATH_BY_LONELINESS = aliveNeighborsCount -> aliveNeighborsCount <= MAX_NEIGHBOURS_FOR_DEATH_BY_LONELINESS;
    public static LifeCriteria DEATH_BY_CROWDEDNESS = aliveNeighborsCount -> aliveNeighborsCount >= MIN_NEIGHBOURS_FOR_DEATH_BY_CROWDEDNESS;
    public static LifeCriteria REBIRTH = aliveNeighborsCount -> aliveNeighborsCount == NEIGHBOURS_FOR_REBIRTH;

}
