package com.indproj.kalkulator.ui.heart;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public final class HeartViewModel extends ViewModel {

    private final static HeartViewModel instance = new HeartViewModel();

    private MutableLiveData<Integer> maxHeartRate;
    private MutableLiveData<Integer> restMaxRate;

    private HeartViewModel() {
        maxHeartRate = new MutableLiveData<>();
        restMaxRate = new MutableLiveData<>();
    }

    public static HeartViewModel getInstance() {
        return instance;
    }

    void setMaxHeartRate(int value) {
        this.maxHeartRate.setValue(value);
    }

    public LiveData<Integer> getMaxHeartRate() {
        return maxHeartRate;
    }

    void setRestMaxRate(int value) {
        this.restMaxRate.setValue(value);
    }

    public MutableLiveData<Integer> getRestMaxRate() {
        return restMaxRate;
    }
}