package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    public List<User> findAll();

    @Transactional
    public void save(User user);

    @Transactional
    public void delete(User user);

    @Transactional
    public void update(User user);

    public User getByID(Long id);
}
