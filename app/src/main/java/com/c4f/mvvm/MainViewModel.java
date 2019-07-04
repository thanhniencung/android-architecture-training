package com.c4f.mvvm;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public class MainViewModel extends ViewModel  {
    private final MutableLiveData<Integer> counter = new MutableLiveData<>();

    public static MainViewModel of(FragmentActivity activity) {
        return ViewModelProviders.of(activity).get(MainViewModel.class);
    }

    public LiveData<Integer> getCounter() {
        return counter;
    }

    public void increment() {
        int value = counter.getValue() == null ? 0 : counter.getValue() + 1;
        counter.setValue(value);
    }

    public void decrement() {
        if (counter.getValue() != null && counter.getValue() == 0) {
            counter.setValue(0);
            return;
        }
        int value = counter.getValue() == null ? 0 : counter.getValue() -  1;
        counter.setValue(value);
    }
}
