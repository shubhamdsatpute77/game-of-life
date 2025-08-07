package com.gameoflife.life.criteria;

import com.gameoflife.life.CellStateType;

import java.util.ArrayList;
import java.util.List;

public enum LifeCriteriaEnum {
    DEATH_BY_LONELINESS(LifeCriteriaImpl.DEATH_BY_LONELINESS, CellStateType.DEAD),
    DEATH_BY_CROWDEDNESS(LifeCriteriaImpl.DEATH_BY_CROWDEDNESS, CellStateType.DEAD),
    RE_BIRTH(LifeCriteriaImpl.REBIRTH, CellStateType.ALIVE);

    private LifeCriteria lifeCriteria;
    private CellStateType cellStateType;

    LifeCriteriaEnum (LifeCriteria lifeCriteria, CellStateType cellStateType) {
        this.lifeCriteria = lifeCriteria;
        this.cellStateType = cellStateType;
    }

    public LifeCriteria getLifeCriteria() {
        return lifeCriteria;
    }

    public CellStateType getLifeStateType() {
        return cellStateType;
    }

    public static List<LifeCriteriaEnum> getAllDeathCriteri() {
        List<LifeCriteriaEnum> deathCriteria = new ArrayList<>();
        for (LifeCriteriaEnum criteria : values()) {
            if (criteria.getLifeStateType() == CellStateType.DEAD) {
                deathCriteria.add(criteria);
            }
        }
        return deathCriteria;
    }

    public static List<LifeCriteriaEnum> getAllBirthCriteri() {
        List<LifeCriteriaEnum> deathCriteria = new ArrayList<>();
        for (LifeCriteriaEnum criteria : values()) {
            if (criteria.getLifeStateType() == CellStateType.ALIVE) {
                deathCriteria.add(criteria);
            }
        }
        return deathCriteria;
    }
}
