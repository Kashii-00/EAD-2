package com.hotellanka.userlogin.service;
import com.hotellanka.userlogin.model.UserEntity;
import com.hotellanka.userlogin.repository.UserRepository;
import com.hotellanka.userlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        UserEntity user = getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }
}
