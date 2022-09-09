package com.reihaneh.personalexpenses.repository;

import com.reihaneh.personalexpenses.domain.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<Users, Long> {
}
