package com.gameoflife.entity;

import com.gameoflife.life.LifeStateType;
import com.gameoflife.pojo.Position;

public class Cell {

    private LifeStateType lifeState;
    private Position position;

    public Cell(LifeStateType lifeState, Position position) {
        this.lifeState = lifeState;
        this.position = position;
    }

    public LifeStateType getLifeState() {
        return lifeState;
    }

    public void setLifeState(LifeStateType lifeState) {
        this.lifeState = lifeState;
    }

    public int getPositionX() {
        return position.getX();
    }

    public int getPositionY() {
        return position.getY();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isAlive() {
        return lifeState == LifeStateType.ALIVE;
    }

    public boolean isDead() {
        return lifeState == LifeStateType.DEAD;
    }
}
