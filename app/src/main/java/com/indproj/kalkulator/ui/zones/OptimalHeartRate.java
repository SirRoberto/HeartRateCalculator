package com.indproj.kalkulator.ui.zones;

public class OptimalHeartRate {

    private int heartRateMax;
    private int heartRateRest;

    public OptimalHeartRate(int heartRateMax, int heartRateRest) {
        this.heartRateMax = heartRateMax;
        this.heartRateRest = heartRateRest;
    }

    public int getIntensityTrainingPulse() {
        return kavonenFormula(0.8);
    }

    public int getLongTrainingPulse() {
        return kavonenFormula(0.6);
    }

    public int getBasicTrainingPulse() {
        return kavonenFormula(0.5);
    }

    private int kavonenFormula( double x ) {
        return (int) ((heartRateMax - heartRateRest) * x + heartRateRest);
    }
}
