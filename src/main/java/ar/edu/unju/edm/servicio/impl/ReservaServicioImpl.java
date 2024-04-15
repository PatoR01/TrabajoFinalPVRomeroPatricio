package ar.edu.unju.edm.servicio.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import ar.edu.unju.edm.modelo.Reserva;

import ar.edu.unju.edm.servicio.ReservaServicio;
import ar.edu.unju.edm.servicio.UsuarioServicio;
import ar.edu.unju.edm.repositorio.ReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.controlador.dto.UsuarioRegistroDTO;
import ar.edu.unju.edm.modelo.Rol;
import ar.edu.unju.edm.modelo.Usuario;
import ar.edu.unju.edm.repositorio.UsuarioRepositorio;

@Service
public class ReservaServicioImpl implements ReservaServicio {
    @Autowired
		private ReservaRepositorio reservaRepositorio;


    @Override
    public void agregarReserva(Reserva reserva) {
        reservaRepositorio.save(reserva);
    }

    @Override
    public List<Reserva> buscarTodos() {
        return reservaRepositorio.findByEstadoTrue();
    }

    @Override
    public void eliminarReserva(Reserva reserva) {
        reservaRepositorio.delete(reserva);
    }
}
