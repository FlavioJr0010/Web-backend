package br.com.ifba.infrastructure.exception;

import lombok.Value;
import org.apache.el.util.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

// Classe que trata exceções globais para a aplicação
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    /*@Value(value = "${server.error.include-exception}")
    private boolean printStackTrace;*/

    // Manipulador de exceções para BusinessException
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Define o status HTTP como 400 (Bad Request)
    public ResponseEntity<Object> handleBusinessException(
            final BusinessException businessException,
            final WebRequest request
    ) {
        final String mensagemErro = businessException.getMessage(); // Obtém a mensagem da exceção

        logger.error(mensagemErro, businessException); // Registra o erro no log

        return buildErrorMessage(
                businessException,
                mensagemErro,
                HttpStatus.INTERNAL_SERVER_ERROR,
                request);
    }

    // Método auxiliar para construir a resposta de erro
    private ResponseEntity<Object> buildErrorMessage(
            final Exception exception, final String message, final HttpStatus httpStatus, final WebRequest request
    ) {
        // Mapa contendo os detalhes da resposta de erro
        Map<String, Object> errorDetails = new LinkedHashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now()); // Data e hora do erro
        errorDetails.put("status", httpStatus.value()); // Código de status HTTP
        errorDetails.put("error", httpStatus.getReasonPhrase()); // Descrição do status HTTP
        errorDetails.put("message", message); // Mensagem específica do erro
        errorDetails.put("path", request.getDescription(false)); // Caminho da requisição que gerou o erro
        errorDetails.put("exception", exception.getClass().getSimpleName()); // Nome da exceção capturada

        // Retorna a resposta com o status HTTP e os detalhes do erro
        return ResponseEntity.status(httpStatus).body(errorDetails);
    }
}