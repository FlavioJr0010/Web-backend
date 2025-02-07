package br.com.ifba.usuario;

// Importações de dependências e bibliotecas
import br.com.ifba.infrastructure.entity.PersitenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

// A classe Usuario estende PersistenceEntity e implementa Serializable para permitir
// a persistência dos dados no banco de dados e garantir a serialização dos objetos.
// O equalsAndHashCode gerado considera a classe Pai (PersistenceEntity).
@EqualsAndHashCode(callSuper = true)
@Entity // Define que a classe Usuario é uma entidade JPA (usada para persistência no banco de dados)
@Table(name = "Usuarios") // Especifica o nome da tabela no banco de dados que armazenará os dados dessa entidade
@Data // Anotação do Lombok que gera automaticamente os getters, setters, equals, hashCode e toString
@AllArgsConstructor // Anotação Lombok para gerar um construtor com todos os campos
@NoArgsConstructor // Anotação Lombok para gerar um construtor sem argumentos (padrão)
@Builder
public class Usuario extends PersitenceEntity implements Serializable {

    // Definição dos campos que representam as colunas da tabela no banco de dados

    @Column(name = "nome", nullable = false) // Anotação JPA que mapeia a coluna 'nome' e define que não pode ser nula
    private String nome;

    @Column(name = "email", nullable = false, unique = true) // Mapeia a coluna 'email', define como não nula e única
    private String email;

    @Column(name = "user_name", nullable = false, unique = true) // Mapeia a coluna 'user_name', define como não nula e única
    private String login;

    @Column(name = "Senha", nullable = false) // Mapeia a coluna 'Senha' como não nula
    private String senha;
}
