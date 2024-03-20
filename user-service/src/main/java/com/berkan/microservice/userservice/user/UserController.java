package com.berkan.microservice.userservice.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping("/user/create")
    public User createUser(@RequestBody User user){
        return service.createUser(user);
    }

    @GetMapping("user/get/{id}")
    public User getUser(@PathVariable int id){
        return service.getUser(id);
    }
    @GetMapping("user/wishlist/{id}")
    public List<Integer> getWishlist(@PathVariable int id){
        return service.getWishlist(id);
    }
}
