package br.com.ifba.infrastructure.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

// Define esta classe como uma superclasse mapeada para JPA,
// permitindo que suas propriedades sejam herdadas por outras entidades.
@MappedSuperclass
@Data // Lombok gera automaticamente os métodos getter, setter, equals, hashCode e toString.
public class PersitenceEntity {

    @Id // Define o identificador único da entidade
    @GeneratedValue(strategy = GenerationType.AUTO) // Gera automaticamente o ID conforme a estratégia do banco de dados
    private Long id;
}