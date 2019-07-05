package com.c4f.mvvm.login;

import com.c4f.mvvm.mvp.MVPView;

public interface LoginView extends MVPView {
    void onSuccess();
    void onFail();
}
