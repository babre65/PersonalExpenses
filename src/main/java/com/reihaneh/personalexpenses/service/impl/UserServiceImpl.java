package com.reihaneh.personalexpenses.service.impl;

import com.reihaneh.personalexpenses.domain.Users;
import com.reihaneh.personalexpenses.repository.UserRepository;
import com.reihaneh.personalexpenses.service.UserService;
import com.reihaneh.personalexpenses.service.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<Users, UserDto, UserRepository, Long> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository, Users.class, UserDto.class, log);
    }
}
