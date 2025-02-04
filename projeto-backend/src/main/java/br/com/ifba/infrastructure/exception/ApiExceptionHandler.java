package br.com.ifba.infrastructure.exception;

import lombok.Value;
import org.apache.el.util.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Classe que trata exceções globais para a aplicação
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException) {
        // Lista de campos inválidos
        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();

        String fields = fieldErrors.stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));

        // Mensagem detalhada para desenvolvedores
        String fieldsMessage = methodArgumentNotValidException.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));

        // Criação do mapa de erro
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error", "Bad Request, campos inválidos");
        errorResponse.put("message", "Campos com erro");
        errorResponse.put("developerMessage", fieldsMessage);
        errorResponse.put("fields", fields);

        // Retorno da resposta
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
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