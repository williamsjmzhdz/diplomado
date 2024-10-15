package dgtic.core.controller.caladero;

import dgtic.core.model.entities.CaladeroEntity;
import dgtic.core.model.entities.CompradorEntity;
import dgtic.core.service.caladero.CaladeroService;
import dgtic.core.service.comprador.CompradorService;
import dgtic.core.util.RenderPagina;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "caladero")
public class CaladeroController {

    @Autowired
    private CaladeroService caladeroService;

    @GetMapping("lista-caladero")
    public String listaCaladero(@RequestParam(name = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<CaladeroEntity> caladeroEntities = caladeroService.buscarCaladero(pageable);
        RenderPagina<CaladeroEntity> renderPagina = new RenderPagina<>("lista-caladero", caladeroEntities);

        // Agregar datos al modelo
        model.addAttribute("caladero", caladeroEntities);
        model.addAttribute("page", renderPagina);
        model.addAttribute("contenido", "Lista de Caladeros");

        return "caladero/lista-caladero";
    }

    @GetMapping("alta-caladero")
    public String altaCaladero(Model model) {
        CaladeroEntity caladero = new CaladeroEntity();
        model.addAttribute("contenido", "Alta de Caladero");
        model.addAttribute("caladero", caladero);
        return "caladero/alta-caladero";
    }

    @PostMapping("salvar-caladero")
    public String salvarCaladero(@Valid @ModelAttribute("caladero") CaladeroEntity caladero,
                                  BindingResult result,
                                  Model model,
                                  RedirectAttributes flash) {

        // Verificar si hay errores de validación
        if (result.hasErrors()) {
            model.addAttribute("contenido", "Errores de validación de datos detectados");
            return "caladero/alta-caladero";  // Volver a la misma vista en caso de error
        }

        // Guardar el caladero
        caladeroService.guardar(caladero);
        flash.addFlashAttribute("success","Se almacenó con éxito.");

        // Redirigir a la lista de caladeros
        return "redirect:/caladero/lista-caladero";
    }

    @GetMapping("modificar-caladero/{id}")
    public String saltoModificar(@PathVariable("id") Integer id, Model model) {
        CaladeroEntity caladero = caladeroService.buscarPorId(id);

        // Verificar si el caladero existe
        if (caladero != null) {
            model.addAttribute("caladero", caladero);
            model.addAttribute("contenido", "Modificar Caladero");
            return "caladero/alta-caladero";
        }

        // Redirigir a la lista si el caladero no existe
        return "redirect:/caladero/lista-caladero";
    }


    @GetMapping("eliminar-caladero/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes flash) {
        caladeroService.borrar(id);
        flash.addFlashAttribute("success", "Se borró con éxito el caladero");
        return "redirect:/caladero/lista-caladero";
    }

}
