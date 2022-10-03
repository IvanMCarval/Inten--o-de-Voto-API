package com.workshop.voting_intention.bridge;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.workshop.voting_intention.api.dto.UserDTO;

public interface UserBridge {
    ResponseEntity salvar(@RequestBody UserDTO dto);
}
