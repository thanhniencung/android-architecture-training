package com.c4f.mvvm.mvp;

public class Presenter<T extends MVPView> {
    T view;

    public void attachView(T view) {
        this.view = view;
    }

    public void deAttchView() {
        view = null;
    }

    public T getView() {
        return view;
    }
}
