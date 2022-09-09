package com.workshop.voting_intention.api.resource;

import com.workshop.voting_intention.api.dto.UserDTO;
import com.workshop.voting_intention.model.entity.User;
import com.workshop.voting_intention.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UserResource {
    private final UserService service;

    @PostMapping("/salvar")
    public ResponseEntity salvar(@RequestBody UserDTO dto) {
        User user = User.builder().voto(dto.getVoto()).idade(dto.getIdade()).cidade(dto.getCidade()).estado(dto.getEstado()).build();

        try {
            User usuarioSalvo = service.salvarUsuario(user);
            return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel salvar sua intenção de voto");
        }
    }

    @GetMapping
    public ResponseEntity buscarVotos() {
        try {
            List<User> users = service.buscarVotos();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possivel buscar os dados");
        }
    }
}
