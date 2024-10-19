package dgtic.core.controller.lote;

import dgtic.core.model.entities.LoteEntity;
import dgtic.core.service.lote.LoteService;
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
@RequestMapping(value = "lote")
public class LoteController {

    @Autowired
    private LoteService loteService;

    @GetMapping("alta-lote")
    public String altaLote(Model model) {
        LoteEntity lote = new LoteEntity();
        model.addAttribute("contenido", "Alta de Lote");
        model.addAttribute("lote", lote);
        return "lote/alta-lote";
    }


    @PostMapping("salvar-lote")
    public String salvarLote(@Valid @ModelAttribute("lote") LoteEntity lote,
                             BindingResult result,
                             Model model,
                             RedirectAttributes flash) {

        // Verificar si hay errores de validación
        if (result.hasErrors()) {
            model.addAttribute("contenido", "Errores de validación de datos detectados");
            return "lote/alta-lote";  // Volver a la misma vista en caso de error
        }

        // Guardar el lote
        loteService.guardar(lote);
        flash.addFlashAttribute("success","Se almacenó con éxito.");

        // Redirigir a la lista de lotes
        return "redirect:/lote/lista-lote";
    }


    @GetMapping("lista-lote")
    public String listLote(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<LoteEntity> loteEntities = loteService.buscarLote(pageable);
        RenderPagina<LoteEntity> renderPagina = new RenderPagina<>("lista-lote", loteEntities);

        // Agregar datos al modelo
        model.addAttribute("lote", loteEntities);
        model.addAttribute("page", renderPagina);
        model.addAttribute("contenido", "Lista de Lotes");

        return "lote/lista-lote";
    }


    @GetMapping("modificar-lote/{id}")
    public String saltoModificar(@PathVariable("id") Integer id, Model model) {
        LoteEntity lote = loteService.buscarPorId(id);

        // Verificar si el lote existe
        if (lote != null) {
            model.addAttribute("lote", lote);
            model.addAttribute("contenido", "Modificar Lote");
            return "lote/alta-lote";
        }

        // Redirigir a la lista si el lote no existe
        return "redirect:/lote/lista-lote";
    }


    @GetMapping("eliminar-lote/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes flash) {
        loteService.borrar(id);
        flash.addFlashAttribute("success", "Se borró con éxito el lote");
        return "redirect:/lote/lista-lote";
    }

}
