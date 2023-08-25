package com.parishjain.usermanagement.service;

import com.parishjain.usermanagement.model.Users;
import com.parishjain.usermanagement.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    public Users save(Users users) {
        return userRepo.save(users);
    }

    public List<Users> findAllUsers() {

        return userRepo.findAll();
    }

    public Users findUserById(Long id) {
        return userRepo.findById(id).get();
    }

    public String deleteById(Long id) {
        userRepo.deleteById(id);
        return "Deleted";
    }

    @Transactional
    public String updateMobileById(Long id,String mobile) {

        Users users =  findUserById(id);
        users.setMobile(mobile);
        userRepo.save(users);
        return "Updated";
    }


    public String deleteMobileById(Long id, String mobile) {
        Optional<Users> optional = userRepo.findById(id);
        if(optional.isPresent()) {
            Users users = optional.get();
            users.setMobile(null);
            userRepo.save(users);
            return "User Mobile Number Deleted";
        }
        else {
            return "User with this Id not exist !!!";
        }
    }
}
