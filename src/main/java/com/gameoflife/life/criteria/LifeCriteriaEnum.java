package com.gameoflife.life.criteria;

import com.gameoflife.life.LifeStateType;

import java.util.ArrayList;
import java.util.List;

public enum LifeCriteriaEnum {
    LONELINESS_DEATH(new LonelinessDeath(), LifeStateType.DEAD),
    CROWDED_DEATH(new CrowdedDeath(), LifeStateType.DEAD),
    HAPPY_NEIGHBOUR_BIRTH(new HappyNeighbourCriteria(), LifeStateType.ALIVE);

    private LifeCriteria lifeCriteria;
    private LifeStateType lifeStateType;

    LifeCriteriaEnum (LifeCriteria lifeCriteria, LifeStateType lifeStateType) {
        this.lifeCriteria = lifeCriteria;
        this.lifeStateType = lifeStateType;
    }

    public LifeCriteria getLifeCriteria() {
        return lifeCriteria;
    }

    public LifeStateType getLifeStateType() {
        return lifeStateType;
    }

    public static List<LifeCriteriaEnum> getAllDeathCriteri() {
        List<LifeCriteriaEnum> deathCriteria = new ArrayList<>();
        for (LifeCriteriaEnum criteria : values()) {
            if (criteria.getLifeStateType() == LifeStateType.DEAD) {
                deathCriteria.add(criteria);
            }
        }
        return deathCriteria;
    }

    public static List<LifeCriteriaEnum> getAllBirthCriteri() {
        List<LifeCriteriaEnum> deathCriteria = new ArrayList<>();
        for (LifeCriteriaEnum criteria : values()) {
            if (criteria.getLifeStateType() == LifeStateType.ALIVE) {
                deathCriteria.add(criteria);
            }
        }
        return deathCriteria;
    }
}
