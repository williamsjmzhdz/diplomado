package dgtic.core.controller.lote;

import dgtic.core.model.entities.LoteEntity;
import dgtic.core.model.entities.TipoEntity;
import dgtic.core.service.lote.LoteService;
import dgtic.core.service.tipo.TipoService;
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

    /*
    @PostMapping("salvar-tipo")
    public String salvarTipo(@RequestParam("nombre") String nombre, Model model,
                             RedirectAttributes flash) {
        System.out.println("Formulario: " + nombre);
        flash.addFlashAttribute("success", "Se almacenó con éxito.");
        //model.addAttribute("contenido", "Alta de Tipo");
        //model.addAttribute("success", "Se almacenó con éxito.");
        //model.addAttribute("nombre", nombre);
        //return "tipo/alta-tipo";
        return "redirect:/inicio";
    }
    */

    @PostMapping("salvar-lote")
    public String salvarLote(@Valid @ModelAttribute("lote") LoteEntity lote,
                             BindingResult result,
                             Model model,
                             RedirectAttributes flash) {
        System.out.println(lote);
        if (result.hasErrors()) {
            model.addAttribute("contenido", "Errores de validación de datos detectados");
            return "lote/alta-lote";
        }
        loteService.guardar(lote);
        model.addAttribute("success", "Se almacenó el lote con éxito");
        model.addAttribute("lote", lote);
        return "lote/alta-lote";
    }

    @GetMapping("lista-lote")
    public String listLote(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<LoteEntity> loteEntities = loteService.buscarLote(pageable);
        RenderPagina<LoteEntity> renderPagina = new RenderPagina<>("lista-lote", loteEntities);
        System.out.println(loteEntities);
        model.addAttribute("lote", loteEntities);
        model.addAttribute("page", renderPagina);
        model.addAttribute("contenido", "Lista de Lotes");
        return "lote/lista-lote";
    }


}
