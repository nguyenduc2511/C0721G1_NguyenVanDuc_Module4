package com.example.demo.model.service.security;

import com.example.demo.model.entity.security.User;
import com.example.demo.model.repository.security.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return this.iUserRepository.findAll();
    }

    @Override
    public User save(User user) {
        return this.iUserRepository.save(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public User findById(int id) {
        return null;
    }
}
