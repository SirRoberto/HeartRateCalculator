package com.indproj.kalkulator.ui.heart;

public abstract class Formula {
    private String name;
    private String pattern;
    private String description;
    private String error;

    public Formula(String name, String pattern, String description, String error) {
        this.name = name;
        this.pattern = pattern;
        this.description = description;
        this.error = error;
    }

    public abstract int calculateMaxHeartRate(boolean isMan, int age, int weight);

    public String getName() {
        return name;
    }

    public String getPattern() {
        return pattern;
    }

    public String getDescription() {
        return description;
    }

    public String getError() {
        return error;
    }

}
