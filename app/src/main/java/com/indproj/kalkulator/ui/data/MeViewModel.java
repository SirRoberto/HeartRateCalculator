package com.indproj.kalkulator.ui.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public final class MeViewModel extends ViewModel {

    private static final MeViewModel instance = new MeViewModel();

    private MutableLiveData<Boolean> isMan;
    private MutableLiveData<Integer> age;
    private MutableLiveData<Integer> weight;
    private MutableLiveData<Integer> restHeartRate;
    private MutableLiveData<SliderSettings> sliderSettings;

    private MeViewModel() {
        init();
        setIsMan(true);
        SliderSettings settings = new SliderSettings();
        settings.ageStart = 10;
        settings.ageStop = 80;
        settings.agePos = 0.4f;
        settings.weightStart = 40;
        settings.weightStop = 120;
        settings.weightPos = 0.4f;
        settings.restRateStart = 30;
        settings.restRateStop = 100;
        settings.restPos = 0.4f;
        setSliderSettings(settings);
    }

    public static MeViewModel getInstance() {
        return instance;
    }

    private void init() {
        isMan = new MutableLiveData<>();
        age = new MutableLiveData<>();
        weight = new MutableLiveData<>();
        restHeartRate = new MutableLiveData<>();
        sliderSettings = new MutableLiveData<>();
    }


    public LiveData<Boolean> isMan() {
        if(isMan == null) {
            isMan = new MutableLiveData<>();
        }
        return isMan;
    }

    public LiveData<Integer> getAge() {
        if(age == null) {
            age = new MutableLiveData<>();
        }
        return age;
    }

    public LiveData<Integer> getWeight() {
        if(weight == null) {
            weight = new MutableLiveData<>();
        }
        return weight;
    }

    public LiveData<Integer> getRestHeartRate() {
        if(restHeartRate == null) {
            restHeartRate = new MutableLiveData<>();
        }
        return restHeartRate;
    }

    LiveData<SliderSettings> getSliderSettings() {
        if(sliderSettings == null) {
            sliderSettings = new MutableLiveData<>();
        }
        return sliderSettings;
    }

    void setIsMan(boolean isMan) {
        this.isMan.setValue(isMan);
    }

    void setAge(int age) {
        this.age.setValue(age);
    }

    void setWeight(int weight) {
        this.weight.setValue(weight);
    }

    void setRestHeartRate(int restHeartRate) {
        this.restHeartRate.setValue(restHeartRate);
    }

    private void setSliderSettings(SliderSettings set) {
        this.sliderSettings.setValue(set);
    }

    static class SliderSettings {
        int ageStart, ageStop;
        int weightStart, weightStop;
        int restRateStart, restRateStop;
        float agePos, weightPos, restPos;
    }
}