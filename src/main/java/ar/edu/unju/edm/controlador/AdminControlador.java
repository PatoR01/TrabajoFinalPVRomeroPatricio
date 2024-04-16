package ar.edu.unju.edm.controlador;

import ar.edu.unju.edm.servicio.CanchaDeFutbolServicio;
import ar.edu.unju.edm.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication; import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class AdminControlador {
    @Autowired
    UsuarioServicio usuarioServicio;

    @Autowired
    CanchaDeFutbolServicio canchaDeFutbolServicio;

    @GetMapping("/admin")
    String vistaDeAdministrador(Model model, Authentication authentication) {
        if (authentication.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        model.addAttribute("usuarios", usuarioServicio.listarUsuarios());
        //model.addAttribute("puntosDeInteres", canchaDeFutbolServicio.buscarTodos());
        model.addAttribute("canchas", canchaDeFutbolServicio.buscarTodos());
        return "admin";
    }

    @GetMapping("/admin/eliminar/cancha/{id}")
    String eliminarCancha(@PathVariable Long id, Authentication authentication) {
        if (authentication.getAuthorities().stream().noneMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        canchaDeFutbolServicio.eliminarCanchaDeFutbol(canchaDeFutbolServicio.buscarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return "redirect:/admin";
    }
}
