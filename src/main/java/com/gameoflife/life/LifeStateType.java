package com.gameoflife.life;

public enum LifeStateType {
    ALIVE(1),
    DEAD(2);

    private int state;

    LifeStateType (int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
