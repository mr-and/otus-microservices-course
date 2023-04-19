package com.otusmicroservicescourse.otushw3.repository;

import com.otusmicroservicescourse.otushw3.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
