package com.prueba.ejercicio.controller;

import com.prueba.ejercicio.model.Usuario;
import com.prueba.ejercicio.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador de usuarios
 * @author Santiago Pérez
 * @since 2022-03-24
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService service;
    @GetMapping()
    public List<Usuario> list() {
        return service.all();
    }
    
    @GetMapping("/{id}")
    public Usuario get(@PathVariable String id) {
        return service.read(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public Boolean put(@PathVariable String id, @RequestBody Object input) {
        return service.update(Integer.parseInt(id),(Usuario) input);
    }
    
    @PostMapping
    public Boolean post(@RequestBody Usuario input) {
        return service.create(input);
    }
    
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable String id) {
        return service.delete(Integer.parseInt(id));
    }
}