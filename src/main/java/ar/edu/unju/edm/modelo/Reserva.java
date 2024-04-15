package ar.edu.unju.edm.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.*;

@Entity
@Table(name = "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	private CanchaDeFutbol canchaDeFutbol;

	private boolean estado = true;

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Reserva(Usuario usuario, CanchaDeFutbol canchaDeFutbol) {
		this.usuario = usuario;
		this.canchaDeFutbol = canchaDeFutbol;
	}
	public Reserva() {

	}

	public Usuario getUsuario() {
		return this.usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/*
	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	*/
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}

}
