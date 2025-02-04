package br.com.ifba;

import br.com.ifba.usuario.dto.UsuarioPostResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
@Log4j2
public class ProjetoBackendApplication {

	public static void main(String[] args) {SpringApplication.run(ProjetoBackendApplication.class, args);}

}
