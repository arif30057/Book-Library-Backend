package com.j2ee.miniproject.bookLibrary.repository;

import com.j2ee.miniproject.bookLibrary.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByEmail( String email);
}