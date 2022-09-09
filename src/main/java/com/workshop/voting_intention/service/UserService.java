package com.workshop.voting_intention.service;

import com.workshop.voting_intention.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User salvarUsuario(User usuario);

    List<User> buscarVotos();

    Optional<User> obterPorId(Long id);
}
