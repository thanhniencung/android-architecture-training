package com.c4f.mvvm.login;

import com.c4f.mvvm.mvp.Presenter;

public class LoginPresenter extends Presenter<LoginView> {
    void doLogin(String userName, String password) {
        if (userName.equals("ryan") && password.equals("123456")) {
            getView().onSuccess();
        } else {
            getView().onFail();
        }
    }
}
