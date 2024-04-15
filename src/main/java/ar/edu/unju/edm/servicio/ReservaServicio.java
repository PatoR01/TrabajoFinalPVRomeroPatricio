package ar.edu.unju.edm.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import ar.edu.unju.edm.controlador.dto.UsuarioRegistroDTO;
import ar.edu.unju.edm.modelo.Usuario;
import ar.edu.unju.edm.repositorio.ReservaRepositorio;
import ar.edu.unju.edm.modelo.Reserva;


public interface ReservaServicio {

    public void agregarReserva(Reserva reserva);

    public List<Reserva> buscarTodos();

    public void eliminarReserva(Reserva reserva);
}
