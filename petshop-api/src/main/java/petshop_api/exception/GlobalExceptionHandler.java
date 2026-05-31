package petshop_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, Object> erros = new HashMap<>();
        erros.put("timestamp", LocalDateTime.now());
        erros.put("status", 400);
        erros.put("erro", "Dados inválidos");

        Map<String, String> campos = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e ->
                campos.put(e.getField(), e.getDefaultMessage())
        );
        erros.put("campos", campos);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException ex) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", 404);
        erro.put("erro", "Não encontrado");
        erro.put("mensagem", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneric(Exception ex) {
        Map<String, Object> erro = new HashMap<>();
        erro.put("timestamp", LocalDateTime.now());
        erro.put("status", 500);
        erro.put("erro", "Erro interno");
        erro.put("mensagem", ex.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }
}
