package com.otusmicroservicescourse.otushw3.controller;

import com.otusmicroservicescourse.otushw3.exeption.UserNotFound;
import com.otusmicroservicescourse.otushw3.model.User;
import com.otusmicroservicescourse.otushw3.repository.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<Long> delUser(@PathVariable Long id) {
        if (userRepo.findById(id).isPresent()) {
            userRepo.deleteById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/user/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<User> oUser = userRepo.findById(id);
        if (oUser.isPresent()) {
            User userFromDb = oUser.get();
            userFromDb.setUserName(user.getUserName());
            userFromDb.setPhone(user.getPhone());
            userFromDb.setEmail(user.getEmail());
            userFromDb.setFirstName(user.getFirstName());
            userFromDb.setLastName(user.getLastName());
            User updUser = userRepo.save(userFromDb);
            return new ResponseEntity<>(updUser, HttpStatus.OK);
        } else {
            User newUser = userRepo.save(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }
    }
}
