package dgtic.core.controller.comprador;

import dgtic.core.model.entities.CompradorEntity;
import dgtic.core.model.entities.LoteEntity;
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
@RequestMapping(value = "comprador")
public class CompradorController {

    @Autowired
    private CompradorService compradorService;

    @GetMapping("lista-comprador")
    public String listaComprador(@RequestParam(name = "page", defaultValue = "0") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<CompradorEntity> compradorEntities = compradorService.buscarComprador(pageable);
        RenderPagina<CompradorEntity> renderPagina = new RenderPagina<>("lista-comprador", compradorEntities);

        // Agregar datos al modelo
        model.addAttribute("comprador", compradorEntities);
        model.addAttribute("page", renderPagina);
        model.addAttribute("contenido", "Lista de Compradores");

        return "comprador/lista-comprador";
    }

    @GetMapping("alta-comprador")
    public String altaComprador(Model model) {
        CompradorEntity comprador = new CompradorEntity();
        model.addAttribute("contenido", "Alta de Comprador");
        model.addAttribute("comprador", comprador);
        return "comprador/alta-comprador";
    }

    @PostMapping("salvar-comprador")
    public String salvarComprador(@Valid @ModelAttribute("comprador") CompradorEntity comprador,
                             BindingResult result,
                             Model model,
                             RedirectAttributes flash) {

        // Verificar si hay errores de validación
        if (result.hasErrors()) {
            model.addAttribute("contenido", "Errores de validación de datos detectados");
            return "comprador/alta-comprador";  // Volver a la misma vista en caso de error
        }

        // Guardar el comprador
        compradorService.guardar(comprador);
        flash.addFlashAttribute("success","Se almacenó con éxito.");

        // Redirigir a la lista de compradores
        return "redirect:/comprador/lista-comprador";
    }

    @GetMapping("modificar-comprador/{id}")
    public String saltoModificar(@PathVariable("id") Integer id, Model model) {
        CompradorEntity comprador = compradorService.buscarPorId(id);

        // Verificar si el comprador existe
        if (comprador != null) {
            model.addAttribute("comprador", comprador);
            model.addAttribute("contenido", "Modificar Comprador");
            return "comprador/alta-comprador";
        }

        // Redirigir a la lista si el comprador no existe
        return "redirect:/comprador/lista-comprador";
    }


    @GetMapping("eliminar-comprador/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes flash) {
        compradorService.borrar(id);
        flash.addFlashAttribute("success", "Se borró con éxito el comprador");
        return "redirect:/comprador/lista-comprador";
    }

}
