package co.sena.edu.cielo.api_productos.controller;


import co.sena.edu.cielo.api_productos.model.Usuario;
import co.sena.edu.cielo.api_productos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;
    @Autowired
    private UsuarioService usuarioService;

    // GET /api/productos → retorna lista JSON
    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }
    // GET /api/productos/1 → retorna un producto JSON
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // POST /api/productos → crear nuevo producto
    @PostMapping
    public ResponseEntity<Usuario> crear(
            @Validated @RequestBody Usuario usuario) {
        Usuario nuevo = service.guardar(usuario);
        return ResponseEntity.status(201).body(nuevo);
    }
    // PUT /api/productos/1 → actualizar producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(
            @PathVariable Long id,
            @Validated @RequestBody Usuario datos) {
        return ResponseEntity.ok(service.actualizar(id, datos));
    }
    // DELETE /api/productos/1 → eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build(); // 204
    }
}


