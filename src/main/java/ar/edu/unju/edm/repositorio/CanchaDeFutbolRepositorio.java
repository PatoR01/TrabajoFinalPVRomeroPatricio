package ar.edu.unju.edm.repositorio;

import ar.edu.unju.edm.modelo.CanchaDeFutbol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CanchaDeFutbolRepositorio extends CrudRepository<CanchaDeFutbol, Long> {
    // Ejemplo de método personalizado para buscar todas las canchas de fútbol disponibles
    List<CanchaDeFutbol> findByEstadoTrue();
}
