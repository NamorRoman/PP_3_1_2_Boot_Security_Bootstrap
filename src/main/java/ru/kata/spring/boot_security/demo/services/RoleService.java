package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;

public interface RoleService {

    public List<Role> findAll();

    public void save(Role role);

    public void delete(Role role);

    public void update(Role role);

    public Role getByID(Long id);

}
