package com.reihaneh.personalexpenses.web.rest;

import com.reihaneh.personalexpenses.domain.User;
import com.reihaneh.personalexpenses.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserResource extends BaseResource<User, UserService, Long> {

    public UserResource(UserService service) {
        super(service);
    }
}
