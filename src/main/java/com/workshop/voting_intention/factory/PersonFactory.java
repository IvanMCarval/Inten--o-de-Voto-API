package com.workshop.voting_intention.factory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface PersonFactory {
    public ResponseEntity busca();
    public ResponseEntity buscaPorId(@PathVariable("id") Long id);
}
