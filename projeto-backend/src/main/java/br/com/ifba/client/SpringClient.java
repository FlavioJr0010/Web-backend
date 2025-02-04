package br.com.ifba.client;

import br.com.ifba.usuario.dto.UsuarioPostResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
//import org.springframework.web.reactive.function.client.WebClient;

@Log4j2
public class SpringClient {

    // PARA PODER RODAR TIVE QUE COLOCAR NO APPLICATION
    public static void main(String[] args) {

        // Criando uma instância de WebClient com a base da URL da API
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8080/usuarios")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) // Definindo o cabeçalho padrão como JSON
                .build();

        // Criando um objeto para envio no POST
        UsuarioPostResponseDto usuarioPostResponseDto = new UsuarioPostResponseDto();
        usuarioPostResponseDto.setNome("Tio Paulo");
        usuarioPostResponseDto.setEmail("tiopaulo@funeraria.com");
        usuarioPostResponseDto.setLogin("Paulo");
        usuarioPostResponseDto.setSenha("mortodecansaço");

        // Enviando uma requisição POST para salvar um usuário
        String Response1 = webClient
                .post()
                .uri("/save")
                .body(Mono.just(usuarioPostResponseDto), UsuarioPostResponseDto.class) // Enviando o corpo da requisição como JSON
                .retrieve()
                .bodyToMono(String.class) // Convertendo a resposta para String
                .block(); // Bloqueando a execução até receber a resposta

        log.info(Response1); // Exibindo a resposta do POST no log

        // Fazendo uma requisição GET para buscar todos os usuários
        String Response2 = webClient
                .get()
                .uri("/findall")
                .retrieve()
                .bodyToMono(String.class) // Convertendo a resposta para String
                .block(); // Bloqueando a execução até receber a resposta

        log.info(Response2); // Exibindo a resposta do GET no log

    }
}
