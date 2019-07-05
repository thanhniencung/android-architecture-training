package com.c4f.mvvm.repository.repoImpl;

import com.c4f.mvvm.model.User;

public interface UserDataStore {
    void storeUser(User user);
    User getUserById(String id);
}
