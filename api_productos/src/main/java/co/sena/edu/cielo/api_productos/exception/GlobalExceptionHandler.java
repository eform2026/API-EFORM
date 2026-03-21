package co.sena.edu.cielo.api_productos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
@RestControllerAdvice
public class GlobalExceptionHandler {
    // Captura RecursoNoEncontrado → responde 404
    @ExceptionHandler(RecursoNoEncontrado.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            RecursoNoEncontrado ex) {
        ErrorResponse error = new ErrorResponse(
                ex.getMessage(), 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }
    // Captura errores de validación → responde 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
            MethodArgumentNotValidException ex) {
        String msg = ex.getBindingResult().getAllErrors()
                .get(0).getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(msg, 400));
    }
}