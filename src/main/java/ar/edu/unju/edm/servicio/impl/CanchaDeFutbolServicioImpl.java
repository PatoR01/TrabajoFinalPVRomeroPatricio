package ar.edu.unju.edm.servicio.impl;

import ar.edu.unju.edm.modelo.CanchaDeFutbol;
import ar.edu.unju.edm.repositorio.CanchaDeFutbolRepositorio;
import ar.edu.unju.edm.servicio.CanchaDeFutbolServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CanchaDeFutbolServicioImpl implements CanchaDeFutbolServicio {
    @Autowired
    private CanchaDeFutbolRepositorio canchaDeFutbolRepositorio;

    @Override
    public void agregarCanchaDeFutbol(CanchaDeFutbol cancha) {
        canchaDeFutbolRepositorio.save(cancha);
    }

    @Override
    public List<CanchaDeFutbol> buscarTodos() {
        return canchaDeFutbolRepositorio.findByEstadoTrue();
    }

    @Override
    public Optional<CanchaDeFutbol> buscarPorId(Long id) {
        return canchaDeFutbolRepositorio.findById(id);
    }

    @Override
    public void eliminarCanchaDeFutbol(CanchaDeFutbol cancha) {
        canchaDeFutbolRepositorio.delete(cancha);
    }
}