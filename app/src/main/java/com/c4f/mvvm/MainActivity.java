package com.c4f.mvvm;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.c4f.mvvm.databinding.ActivityMainBinding;
import com.c4f.mvvm.model.User;
import com.c4f.mvvm.repository.UserRepository;
import com.c4f.mvvm.repository.repoImpl.ApiUserDataStore;
import com.c4f.mvvm.repository.repoImpl.DiskUserDataStore;

public class MainActivity extends AppCompatActivity {
    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        ActivityMainBinding bindingView = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final MainViewModel mainViewModel = MainViewModel.of(this);

        bindingView.setViewmodel(mainViewModel);
        bindingView.setLifecycleOwner(this);

        final EditText editUserId = findViewById(R.id.editUserId);
        final TextView txtResult = findViewById(R.id.txtResult);

        findViewById(R.id.userAction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = editUserId.getText().toString();
                if (userId.isEmpty()) {
                    return;
                }
                User user = userRepository.getUser(userId);
                if (user != null) {
                    txtResult.setText(user.getId() + " - " + user.getName());
                    return;
                }
                User newUser = new User(userId, "Ryan Nguyen");
                userRepository.storeUser(newUser);
            }
        });

    }

    private void init() {
        ApiUserDataStore apiUserDataStore = new ApiUserDataStore();
        DiskUserDataStore diskUserDataStore = new DiskUserDataStore(this);

        userRepository = new UserRepository(apiUserDataStore, diskUserDataStore);
    }
}

