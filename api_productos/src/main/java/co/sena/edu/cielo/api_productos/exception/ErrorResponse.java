package co.sena.edu.cielo.api_productos.exception;

// exception/ErrorResponse.java (DTO para respuesta de error)
public class ErrorResponse {
    private String mensaje;
    private int status;
    private String timestamp;
    public ErrorResponse(String mensaje, int status) {
        this.mensaje = mensaje;
        this.status = status;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
