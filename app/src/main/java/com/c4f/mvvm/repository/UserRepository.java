package com.c4f.mvvm.repository;

import com.c4f.mvvm.model.User;
import com.c4f.mvvm.repository.repoImpl.ApiUserDataStore;
import com.c4f.mvvm.repository.repoImpl.DiskUserDataStore;

public class UserRepository {
    private ApiUserDataStore apiUserDataStore;
    private DiskUserDataStore diskUserDataStore;

    public UserRepository(ApiUserDataStore apiUserDataStore, DiskUserDataStore diskUserDataStore) {
        this.apiUserDataStore = apiUserDataStore;
        this.diskUserDataStore = diskUserDataStore;
    }

    public User getUser(String id) {
        User user = diskUserDataStore.getUserById(id);
        if (user != null) {
            return user;
        }
        return apiUserDataStore.getUserById(id);
    }

    public void storeUser(User user) {
        diskUserDataStore.storeUser(user);
    }
}
