package com.reihaneh.personalexpenses.repository;

import com.reihaneh.personalexpenses.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {
}
