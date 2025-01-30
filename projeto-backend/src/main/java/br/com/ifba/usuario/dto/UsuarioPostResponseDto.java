package br.com.ifba.usuario.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Classe DTO para representar a resposta da API ao atualizar um usuário
@Data // Lombok gera automaticamente getters, setters, equals, hashCode e toString
@AllArgsConstructor // Lombok gera um construtor com todos os argumentos
@NoArgsConstructor // Lombok gera um construtor sem argumentos
public class UsuarioPostResponseDto {

    @JsonProperty(value = "nome") // Define o nome da propriedade no JSON
    @NotNull(message = "O nome é obrigatório!!") // Permite que o dado enviado seja obrigatório
    @NotBlank(message = "O nome não pode ser vazio!!") // Permite que o dado enviado não seja vazio
    private String nome;

    @JsonProperty(value = "email") // Define o nome da propriedade no JSON
    @Email(message = "O E-mail é invalido!!") //Valida para ser enviado emails corretos
    private String email;

    @JsonProperty(value = "login") // Define o nome da propriedade no JSON
    @NotNull(message = "O login é obrigatório!!") // Permite que o dado enviado seja obrigatório
    @NotBlank(message = "O login não pode ser vazio") // Permite que o dado enviado não seja vazio
    @Size(min = 3, max = 150, message = "O login precisa "  +
            "ter pelo menos 3 caracteres e 30 no máximo!!") // Determina um limite de caracteres
    private String login;

    @JsonProperty(value = "senha") // Define o nome da propriedade no JSON
    @NotNull(message = "A senha é obrigatória!!") // Permite que o dado enviado seja obrigatório
    @NotBlank(message = "A senha não pode ser vazia!!") // Permite que o dado enviado não seja vazio
    private String senha;
}