package com.c4f.mvvm.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.c4f.mvvm.R;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenter();
        loginPresenter.attachView(this);

        final EditText editUserName = findViewById(R.id.editUsername);
        final EditText editPassword = findViewById(R.id.editPassword);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editUserName.getText().toString();
                String password = editPassword.getText().toString();

                loginPresenter.doLogin(userName, password);
            }
        });
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFail() {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.deAttchView();
    }
}
