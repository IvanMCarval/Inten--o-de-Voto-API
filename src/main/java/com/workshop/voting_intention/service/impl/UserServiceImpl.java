package com.workshop.voting_intention.service.impl;

import com.workshop.voting_intention.dao.UserDao;
import com.workshop.voting_intention.model.entity.User;
import com.workshop.voting_intention.model.repository.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDao {

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public User salvarUsuario(User usuario) {
        return repository.save(usuario);
    }

    @Override
    public List<User> buscarVotos() {
        return repository.findAll();
    }

    @Override
    public List<User> obterPorVoto(Long voto) {
        return repository.findByVoto(voto);
    }
}
