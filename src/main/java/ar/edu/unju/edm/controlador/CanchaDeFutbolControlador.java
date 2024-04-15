package ar.edu.unju.edm.controlador;

import ar.edu.unju.edm.modelo.CanchaDeFutbol;
import ar.edu.unju.edm.servicio.CanchaDeFutbolServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Base64;

@Controller
public class CanchaDeFutbolControlador {
    @Autowired
    private CanchaDeFutbolServicio canchaDeFutbolServicio;

    private final Logger logger = LoggerFactory.getLogger(CanchaDeFutbolControlador.class);

    @GetMapping("/")
    public String mostrarCanchasDeFutbol(Model model) {
        model.addAttribute("canchas", canchaDeFutbolServicio.buscarTodos());
        return "index";
    }
    @GetMapping("/cancha/{id}")
    public String mostrarCanchaDeFutbolPorId(@PathVariable Long id, Model model) {
        var cancha = canchaDeFutbolServicio.buscarPorId(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("cancha", cancha);
        return "canchaDeFutbol";
    }

    @GetMapping("/cancha/nueva")
    public String formularioNuevaCanchaDeFutbol(Model model) {
        model.addAttribute("canchaDeFutbol", new CanchaDeFutbol());
        return "formularios/canchaDeFutbolNueva";
    }

    @PostMapping("/cancha/nueva")
    public String procesarNuevaCanchaDeFutbol(@Valid CanchaDeFutbol canchaDeFutbol, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "formularios/canchaDeFutbolNueva";
        }

        canchaDeFutbolServicio.agregarCanchaDeFutbol(canchaDeFutbol);

        return "redirect:/cancha/" + canchaDeFutbol.getId();
    }
    
    @GetMapping("/cancha/{id}/editar")
    public String editarCanchaDeFutbol(@PathVariable Long id, Model model) {
        var cancha = canchaDeFutbolServicio.buscarPorId(id).orElseThrow();
        model.addAttribute("canchaDeFutbol", cancha);
        model.addAttribute("editar", "Editar");
        return "formularios/canchaDeFutbolNueva";
    }

    @PostMapping("/cancha/{id}/editar")
    public String procesarEditarCanchaDeFutbol(@PathVariable Long id, @Valid CanchaDeFutbol canchaDeFutbol, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "formularios/canchaDeFutbolNueva";
        }

        canchaDeFutbol.setId(id);
        canchaDeFutbolServicio.agregarCanchaDeFutbol(canchaDeFutbol);

        logger.info(canchaDeFutbol.toString());
        return "redirect:/cancha/" + canchaDeFutbol.getId();
    }

    @GetMapping("/cancha/{id}/eliminar")
    public String eliminarCanchaDeFutbol(@PathVariable Long id) {
        var cancha = canchaDeFutbolServicio.buscarPorId(id).orElseThrow();
        canchaDeFutbolServicio.eliminarCanchaDeFutbol(cancha);

        return "redirect:/";
    }
}
