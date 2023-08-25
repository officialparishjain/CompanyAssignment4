package com.parishjain.usermanagement.controller;

import com.parishjain.usermanagement.model.Users;
import com.parishjain.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    // CREATE USER RECORD
    @PostMapping("save")
    public ResponseEntity<Users> createUser(@RequestBody Users users){
        return ResponseEntity.ok().body(userService.save(users));
    }

    // GET ALL USERS
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUsers());
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findUserById(id));
    }

    // DELETE COMPLETE USER BY ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        String res = userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    // UPDATE USER MOBILE WITH USER ID
    @PutMapping("/{id}/{mobile}")
    public ResponseEntity<String> updateMobileById(@PathVariable Long id,@PathVariable String mobile){
        String res = userService.updateMobileById(id,mobile);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }


    // DELETE USER MOBILE WITH USER ID
    @DeleteMapping("{id}/{mobile}")
    public ResponseEntity<String> deleteMobileMyId(@PathVariable Long id , @PathVariable String mobile){
        String res = userService.deleteMobileById(id,mobile);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }


}
