package com.c4f.mvvm;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainViewModel mainViewModel = MainViewModel.of(this);
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

        mainViewModel.getCounter().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                ((TextView) findViewById(R.id.txtCounter)).setText(integer.toString());
            }
        });
    }
}
