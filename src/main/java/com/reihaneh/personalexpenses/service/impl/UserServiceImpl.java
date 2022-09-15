package com.reihaneh.personalexpenses.service.impl;

import com.reihaneh.personalexpenses.domain.Users;
import com.reihaneh.personalexpenses.repository.UserRepository;
import com.reihaneh.personalexpenses.service.UserService;
import com.reihaneh.personalexpenses.service.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<Users, UserDto, UserRepository, Long> implements UserService, UserDetailsService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        super(repository, Users.class, UserDto.class, log);
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Check to find User: {}", username);

        Optional<Users> users = repository.findByUsername(username);

        return users.map(user -> {
            log.info("User found in database : {}", username);

            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("USER_ROLE"));

            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserDto findByUsername(String username) {
        log.info("Request to find a user by username: {}", username);

        Optional<Users> optionalUser = repository.findByUsername(username);

        return optionalUser.map(user -> mapper.map(user, UserDto.class))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


    @Override
    public UserDto save(UserDto userDto) {
        log.info("Request to save User : {}", userDto);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return super.save(userDto);
    }
}
