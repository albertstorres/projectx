package com.cesar.projx.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cesar.projx.modelos.Usuario;
import com.cesar.projx.repositorios.UsuarioRepository;
import com.cesar.projx.utils.ResponseHandler;


@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/buscar")
    public List<Usuario> buscar() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> detalharUsuario(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (!usuario.isPresent()) {
            return ResponseHandler.generate("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Object>(usuario.get(), HttpStatus.OK);
    }

    @PostMapping("/cadastrar")//Resolvido o erro de "NO STATIC RESOURCE" adicionando o caminho ("/cadastrar")
    public ResponseEntity<Object> cadastrarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getUsername() == null) {
            return ResponseHandler.generate("Username obrigatório.", HttpStatus.BAD_REQUEST);
        } else if (usuario.getSenha() == null) {
            return ResponseHandler.generate("Password obrigatório.", HttpStatus.BAD_REQUEST);
        }

        Usuario novoUsuario = usuarioRepository.save(usuario);

        return ResponseHandler.generate("Usuário criado com sucesso.", HttpStatus.CREATED);
    }
}
