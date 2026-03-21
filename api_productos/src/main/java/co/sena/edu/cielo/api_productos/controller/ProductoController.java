package co.sena.edu.cielo.api_productos.controller;

import co.sena.edu.cielo.api_productos.model.Producto;
import co.sena.edu.cielo.api_productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService service;
    // GET /api/productos → retorna lista JSON
    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }
    // GET /api/productos/1 → retorna un producto JSON
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

        // POST /api/productos → crear nuevo producto
        @PostMapping
        public ResponseEntity<Producto> crear(
                @Validated @RequestBody Producto producto) {
            Producto nuevo = service.guardar(producto);
            return ResponseEntity.status(201).body(nuevo);
        }
// PUT /api/productos/1 → actualizar producto existente
        @PutMapping("/{id}")
        public ResponseEntity<Producto> actualizar(
                @PathVariable Long id,
                @Validated @RequestBody Producto datos) {
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


