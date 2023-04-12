package com.otusmicroservicescourse.otushw3.controller;

import com.otusmicroservicescourse.otushw3.exeption.UserNotFound;
import com.otusmicroservicescourse.otushw3.model.User;
import com.otusmicroservicescourse.otushw3.repository.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFound("User not exist with id :" + id));
        return ResponseEntity.ok(user);
    }
}
