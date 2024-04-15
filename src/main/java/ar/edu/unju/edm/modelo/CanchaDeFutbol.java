package ar.edu.unju.edm.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.OptionalDouble;

@Entity
public class CanchaDeFutbol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cancha_id")
    private Long id;

    @NotBlank
    private String capacidad; // Puede ser "FUTBOL 7" o "FUTBOL 5"

    private double precio;

    private String horario1;

    private String horario2;

    private String horario3;
    
    private boolean estado = true ;

    public CanchaDeFutbol() {
    }

    public CanchaDeFutbol( String capacidad, double precio, String horario1, String horario2, String horario3) {
        this.capacidad = capacidad;
        this.precio = precio;
        this.horario1 = horario1;
        this.horario2 = horario2;
        this.horario3 = horario3;
    }
    
    public CanchaDeFutbol(Long id, String capacidad, double precio, String horario1, String horario2, String horario3) {
    	this.id = id;
        this.capacidad = capacidad;
        this.precio = precio;
        this.horario1 = horario1;
        this.horario2 = horario2;
        this.horario3 = horario3;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getHorario1() {
        return horario1;
    }

    public void setHorario1(String horario1) {
        this.horario1 = horario1;
    }

    public String getHorario2() {
        return horario2;
    }

    public void setHorario2(String horario2) {
        this.horario2 = horario2;
    }

    public String getHorario3() {
        return horario3;
    }

    public void setHorario3(String horario3) {
        this.horario3 = horario3;
    }
    
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}