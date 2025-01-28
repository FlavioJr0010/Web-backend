package br.com.ifba.usuario.controller;

import br.com.ifba.usuario.Usuario;
import br.com.ifba.usuario.service.UsuarioIService;
import br.com.ifba.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/usuarios")
//@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(path = "/findall", produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioService.findAll());
    }

    @PostMapping(path = "/save", consumes =  "application/json")
    public ResponseEntity<?> save(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioService.save(usuario));
    }
}
