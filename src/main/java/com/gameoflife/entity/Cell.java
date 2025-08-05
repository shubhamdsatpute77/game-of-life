package com.gameoflife.entity;

import com.gameoflife.life.LifeStateType;

public class Cell {

    private LifeStateType lifeState;
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public LifeStateType getLifeState() {
        return lifeState;
    }

    public void setLifeState(LifeStateType lifeState) {
        this.lifeState = lifeState;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAlive() {
        return lifeState == LifeStateType.ALIVE;
    }

    public boolean isDead() {
        return lifeState == LifeStateType.DEAD;
    }
}
