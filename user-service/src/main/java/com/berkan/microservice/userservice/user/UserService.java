package com.berkan.microservice.userservice.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user){
        return repository.save(user);
    }

    public User getUser(int id){

        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("Could not find user with id:" + id);
        }

        return repository.findById(id).get();
    }

    public List<Integer> getWishlist(int id){

        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("Couldn't find user with id: " + id);
        }

        return  repository.findById(id).get().getWishlist();
    }

}
