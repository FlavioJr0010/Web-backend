package br.com.ifba.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Classe DTO para representar a resposta da API ao criar um usuário
@Data // Lombok gera automaticamente getters, setters, equals, hashCode e toString
@AllArgsConstructor // Lombok gera um construtor com todos os argumentos
@NoArgsConstructor // Lombok gera um construtor sem argumentos
public class UsuarioPostResponseDto {

    @JsonProperty(value = "nome") // Define o nome da propriedade no JSON
    private String nome;

    @JsonProperty(value = "email") // Define o nome da propriedade no JSON
    private String email;

    @JsonProperty(value = "login") // Define o nome da propriedade no JSON
    private String login;

    @JsonProperty(value = "senha") // Define o nome da propriedade no JSON
    private String senha;
}