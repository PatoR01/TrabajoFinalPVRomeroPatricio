package ar.edu.unju.edm.servicio;

import ar.edu.unju.edm.modelo.CanchaDeFutbol;

import java.util.List;
import java.util.Optional;

public interface CanchaDeFutbolServicio {
    void agregarCanchaDeFutbol(CanchaDeFutbol cancha);

    List<CanchaDeFutbol> buscarTodos();

    Optional<CanchaDeFutbol> buscarPorId(Long id);

    void eliminarCanchaDeFutbol(CanchaDeFutbol cancha);
}