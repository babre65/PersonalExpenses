package com.reihaneh.personalexpenses.repository;

import com.reihaneh.personalexpenses.domain.Users;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
}
