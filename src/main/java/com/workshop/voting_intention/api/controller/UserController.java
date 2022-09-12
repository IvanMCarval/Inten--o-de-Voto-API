package com.workshop.voting_intention.api.controller;

import com.workshop.voting_intention.api.dto.UserDTO;
import com.workshop.voting_intention.model.entity.User;
import com.workshop.voting_intention.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;

    @PostMapping("/salvar")
    public ResponseEntity salvar(@RequestBody UserDTO dto) {
        User user = User.builder().voto(dto.getVoto()).idade(dto.getIdade()).cidade(dto.getCidade()).estado(dto.getEstado()).build();

        try {
            User usuarioSalvo = userDao.salvarUsuario(user);
            return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel salvar sua intenção de voto");
        }
    }

    @GetMapping
    public ResponseEntity buscarVotos() {
        try {
            List<User> users = userDao.buscarVotos();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel buscar os dados");
        }
    }

    @GetMapping("{voto}")
    public ResponseEntity obterVotos(@PathVariable("voto") Long voto) {
        List<User> votos = userDao.obterPorVoto(voto);

        try {
            if (votos.isEmpty()) {
                return ResponseEntity.badRequest().body("Este candidato não foi encontrado em nosso banco de dados");
            }
            return ResponseEntity.ok(votos);
        } catch (Exception e ) {
            return ResponseEntity.badRequest().body("Não foi possivel buscar os votos");
        }
    }
}
