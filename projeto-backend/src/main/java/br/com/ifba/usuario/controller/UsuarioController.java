package br.com.ifba.usuario.controller;

import br.com.ifba.usuario.Usuario;
import br.com.ifba.usuario.service.UsuarioIService;
import br.com.ifba.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
@RequestMapping(path = "/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    //Injeção da dependência
    private final UsuarioService usuarioService;

    //Função para retornar todos os dados relacionados ao usuário
    @GetMapping(path = "/findall", produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(usuarioService.findAll());
    }

    //Função para salvar os dados relacionados ao usuário
    @PostMapping(path = "/save", consumes =  "application/json")
    public ResponseEntity<?> save(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.save(usuario));
    }

    //Função para atualizar os dados relacionados ao usuário
    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody Usuario usuario) {
        usuarioService.update(usuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Função para deletar os dados relacionados ao usuario
    @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        usuarioService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
