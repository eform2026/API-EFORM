package co.sena.edu.cielo.api_productos.service;
import co.sena.edu.cielo.api_productos.exception.RecursoNoEncontrado;
import co.sena.edu.cielo.api_productos.model.Producto;
import co.sena.edu.cielo.api_productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repo;
    public List<Producto> listarTodos() {
        return repo.findAll();
    }
    public Producto buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado(
                        "Producto no encontrado con id: " + id));
    }
    public Producto guardar(Producto p)  { return repo.save(p); }
    public Producto actualizar(Long id, Producto datos) {
        Producto p = buscarPorId(id);
        p.setNombre(datos.getNombre());
        p.setPrecio(datos.getPrecio());
        p.setDescripcion(datos.getDescripcion());
        return repo.save(p);
    }
    public void eliminar(Long id) {
        buscarPorId(id);  // lanza excepción si no existe
        repo.deleteById(id);
    }
}