package com.example.mylianxi.present;


import com.example.mylianxi.view.iview.IMvpView;


public class MvpPresent<T extends IMvpView> {
    private T mt;
    public void attachView(T t) {
        this.mt = t;
    }

    public T getMT() {
        return mt;
    }
}
