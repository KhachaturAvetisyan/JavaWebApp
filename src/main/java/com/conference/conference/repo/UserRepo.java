package com.conference.conference.repo;

import com.conference.conference.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
