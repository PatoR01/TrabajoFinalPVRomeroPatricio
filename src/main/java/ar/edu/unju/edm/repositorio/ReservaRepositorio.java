package ar.edu.unju.edm.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.modelo.Reserva;

import java.util.List;
import ar.edu.unju.edm.modelo.Usuario;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Long>{
		public List<Reserva>  findByEstadoTrue();	
}
