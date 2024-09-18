package com.tallerms.alanisforero_dipardo_valuisa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/nombre")
public class UserController {
    private static final Map<String, String> userNames = new HashMap<>();
    
    static {
        userNames.put("valuisa", "Luisa Fernanda Vargas Gomez");
        userNames.put("alanisforero", "Alanis Nicole Forero Salas");
        userNames.put("dipardo", "Diego Alejandro Pardo Montero");
    }

    @GetMapping("/{usuario}")
    public ResponseEntity<String> getNombreCompleto(@PathVariable String usuario) {
        String nombreCompleto = userNames.get(usuario.toLowerCase());

        if (nombreCompleto == null) {
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }

        return ResponseEntity.ok(nombreCompleto);
    }

}

