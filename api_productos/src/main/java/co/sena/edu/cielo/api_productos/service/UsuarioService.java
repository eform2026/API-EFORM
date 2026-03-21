package co.sena.edu.cielo.api_productos.service;

import co.sena.edu.cielo.api_productos.exception.RecursoNoEncontrado;
import co.sena.edu.cielo.api_productos.model.Usuario;
import co.sena.edu.cielo.api_productos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repo;
    public List<Usuario> listarTodos() {
        return repo.findAll();
    }
    public Usuario buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado(
                        "Usuario no encontrado con id: " + id));
    }
    public Usuario guardar(Usuario p)  { return repo.save(p); }
    public Usuario actualizar(Long id, Usuario datos) {

        Usuario p = buscarPorId(id);
        p.setNombre(datos.getNombre());
        p.setCorreo(datos.getCorreo());
        p.setContrasena(datos.getContrasena());
        p.setRol(datos.getRol());

        return repo.save(p);
    }
    public void eliminar(Long id) {
        buscarPorId(id);  // lanza excepción si no existe
        repo.deleteById(id);
    }
}