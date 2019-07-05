package com.c4f.mvvm.repository.repoImpl;

import com.c4f.mvvm.Data;
import com.c4f.mvvm.model.User;

public class ApiUserDataStore implements UserDataStore {
    @Override
    public void storeUser(User user) {
        // call api create user to api
        Data.USER_STORES.add(user);
    }

    @Override
    public User getUserById(String id) {
        for(User user : Data.USER_STORES) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
