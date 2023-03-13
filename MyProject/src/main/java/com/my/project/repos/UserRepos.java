package com.my.project.repos;

import com.my.project.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepos extends JpaRepository<User,Long> {
    User findByUsername(String username);
    User save(User user);
}
