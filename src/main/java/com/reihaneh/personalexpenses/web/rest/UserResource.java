package com.reihaneh.personalexpenses.web.rest;

import com.reihaneh.personalexpenses.service.UserService;
import com.reihaneh.personalexpenses.service.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserResource extends BaseResource<UserDto, UserService, Long> {

    public UserResource(UserService service) {
        super(service, log);
    }
}
