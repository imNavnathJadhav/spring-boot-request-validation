package com.navnathjadhav.requestvalidation.repository;

import com.navnathjadhav.requestvalidation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailEqualsIgnoreCase(String email);

}
