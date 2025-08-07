package com.gameoflife.life;

public enum CellStateType {
    ALIVE(1),
    DEAD(2);

    private int state;

    CellStateType(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
