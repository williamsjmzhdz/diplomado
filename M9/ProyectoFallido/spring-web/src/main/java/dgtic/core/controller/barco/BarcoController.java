package dgtic.core.controller.barco;

import dgtic.core.model.entities.BarcoEntity;
import dgtic.core.model.entities.CaladeroEntity;
import dgtic.core.service.barco.BarcoService;
import dgtic.core.service.caladero.CaladeroService;
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
@RequestMapping(value = "barco")
public class BarcoController {

    @Autowired
    private BarcoService barcoService;

    @GetMapping("lista-barco")
    public String listaBarco(@RequestParam(name = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<BarcoEntity> barcoEntities = barcoService.buscarBarco(pageable);
        RenderPagina<BarcoEntity> renderPagina = new RenderPagina<>("lista-barco", barcoEntities);

        // Agregar datos al modelo
        model.addAttribute("barco", barcoEntities);
        model.addAttribute("page", renderPagina);
        model.addAttribute("contenido", "Lista de Barcos");

        return "barco/lista-barco";
    }

    @GetMapping("alta-barco")
    public String altaBarco(Model model) {
        BarcoEntity barco = new BarcoEntity();
        model.addAttribute("contenido", "Alta de Barco");
        model.addAttribute("barco", barco);
        return "barco/alta-barco";
    }

    @PostMapping("salvar-barco")
    public String salvarBarco(@Valid @ModelAttribute("barco") BarcoEntity barco,
                                 BindingResult result,
                                 Model model,
                                 RedirectAttributes flash) {

        // Verificar si hay errores de validación
        if (result.hasErrors()) {
            model.addAttribute("contenido", "Errores de validación de datos detectados");
            return "barco/alta-barco";  // Volver a la misma vista en caso de error
        }

        // Guardar el barco
        barcoService.guardar(barco);
        flash.addFlashAttribute("success","Se almacenó con éxito.");

        // Redirigir a la lista de barcos
        return "redirect:/barco/lista-barco";
    }

    @GetMapping("modificar-barco/{id}")
    public String saltoModificar(@PathVariable("id") Integer id, Model model) {
        BarcoEntity barco = barcoService.buscarPorId(id);

        // Verificar si el barco existe
        if (barco != null) {
            model.addAttribute("barco", barco);
            model.addAttribute("contenido", "Modificar Barco");
            return "barco/alta-barco";
        }

        // Redirigir a la lista si el barco no existe
        return "redirect:/barco/lista-barco";
    }


    @GetMapping("eliminar-barco/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes flash) {
        barcoService.borrar(id);
        flash.addFlashAttribute("success", "Se borró con éxito el barco");
        return "redirect:/barco/lista-barco";
    }



}
