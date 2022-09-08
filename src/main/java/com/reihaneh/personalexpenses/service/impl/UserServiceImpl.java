package com.reihaneh.personalexpenses.service.impl;

import com.reihaneh.personalexpenses.domain.User;
import com.reihaneh.personalexpenses.repository.UserRepository;
import com.reihaneh.personalexpenses.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRepository, Long> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}
