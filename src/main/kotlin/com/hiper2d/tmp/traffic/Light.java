package com.hiper2d.tmp.traffic;

public class Light {

    public Light(LightState currentState) {
        this.currentState = currentState;
    }

    private LightState currentState;

    public LightState next() throws LightStateNotDefinedException, LightStateUnknownException {
        if (currentState == null) {
            throw new LightStateNotDefinedException();
        }
        switch (currentState) {
            case RED:
                currentState = LightState.YELLOW_TO_GREEN;
                break;
            case YELLOW_TO_GREEN:
                currentState = LightState.GREEN;
                break;
            case GREEN:
                currentState = LightState.YELLOW_TO_RED;
                break;
            case YELLOW_TO_RED:
                currentState = LightState.RED;
                break;
            default:
                throw new LightStateUnknownException();
        }
        return currentState;
    };

    public LightState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(LightState currentState) {
        this.currentState = currentState;
    }
}
