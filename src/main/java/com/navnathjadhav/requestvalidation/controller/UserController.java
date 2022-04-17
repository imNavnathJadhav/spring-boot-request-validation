package com.navnathjadhav.requestvalidation.controller;

import com.navnathjadhav.requestvalidation.dto.UserRequest;
import com.navnathjadhav.requestvalidation.entity.User;
import com.navnathjadhav.requestvalidation.exception.SaveFailedException;
import com.navnathjadhav.requestvalidation.exception.UserNotFoundException;
import com.navnathjadhav.requestvalidation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<User>> getUserById(@PathVariable long id) throws UserNotFoundException {
        return new ResponseEntity(userService.findUserById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody @Valid UserRequest userRequest) throws SaveFailedException {
        return new ResponseEntity(userService.save(userRequest), HttpStatus.OK);
    }
}
