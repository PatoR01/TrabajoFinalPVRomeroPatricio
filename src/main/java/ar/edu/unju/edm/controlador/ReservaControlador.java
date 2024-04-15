package ar.edu.unju.edm.controlador;

import ar.edu.unju.edm.modelo.Reserva;
import ar.edu.unju.edm.servicio.CanchaDeFutbolServicio;
import ar.edu.unju.edm.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ar.edu.unju.edm.servicio.ReservaServicio;

@Controller
public class ReservaControlador {
    @Autowired
    UsuarioServicio usuarioServicio;

    @Autowired
    CanchaDeFutbolServicio canchaDeFutbolServicio;
    
    @Autowired
    ReservaServicio reservaServicio; 

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/reservar")
    public String nuevaReserva(@RequestParam Long canchaId, @RequestParam String horario) {
        var cancha = canchaDeFutbolServicio.buscarPorId(canchaId).orElseThrow();
        var usuario = usuarioServicio.obtenerUsuarioActual().orElseThrow();

        var nueva_reserva =  new Reserva(usuario, cancha);
        // FIX: this fucking line
        reservaServicio.agregarReserva(nueva_reserva);
        usuario.getReservas().add(nueva_reserva);

        return "/reservas";
    }
    @GetMapping("/reservas") 
    public String mostrarReservasDeUsuario(Model model) {
        var usuario = usuarioServicio.obtenerUsuarioActual().orElseThrow();
        model.addAttribute("reservas", usuario.getReservas());
        return "/reservas";
    }

}
