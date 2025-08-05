package com.gameoflife.life;

public enum GenerationStateType {
    SEED(1),
    AFTER_SEED(2);

    private int state;

    GenerationStateType (int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
