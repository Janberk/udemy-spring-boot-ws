package com.cdn.udemyspringbootws.userservice;

import com.cdn.udemyspringbootws.ui.model.request.UserDetailsRequestModel;
import com.cdn.udemyspringbootws.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
