package com.c4f.mvvm;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.c4f.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Nếu lỗi xảy ra
        ActivityMainBinding bindingView = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final MainViewModel mainViewModel = MainViewModel.of(this);

        bindingView.setViewmodel(mainViewModel);
        bindingView.setLifecycleOwner(this);

        findViewById(R.id.btnIncrement).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewModel.increment();
            }
        });

        findViewById(R.id.btnDecrement).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewModel.decrement();
            }
        });

    }
}
