package com.workshop.voting_intention.dao.impl;

import com.workshop.voting_intention.dao.UserDao;
import com.workshop.voting_intention.model.entity.User;
import com.workshop.voting_intention.model.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDAOImpl implements UserDao {

    private UserRepository repository;

    public UserDAOImpl(UserRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public User salvarUsuario(User usuario) {
        return repository.save(usuario);
    }

    @Override
    public List<User> buscarUsuarios() {
        return repository.findAll();
    }

    @Override
    public Optional<User> obterPorId(Long id) {
        return repository.findById(id);
    }
}
