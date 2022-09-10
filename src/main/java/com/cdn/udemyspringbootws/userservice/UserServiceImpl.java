package com.cdn.udemyspringbootws.userservice;

import com.cdn.udemyspringbootws.shared.Utils;
import com.cdn.udemyspringbootws.ui.model.request.UserDetailsRequestModel;
import com.cdn.udemyspringbootws.ui.model.response.UserRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private Map<String, UserRest> users;
    private final Utils utils;

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest user = new UserRest();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());

        String userId = utils.generateUserId();
        user.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, user);

        return user;
    }

    public Map<String, UserRest> getUsers() {
        return users;
    }
}
