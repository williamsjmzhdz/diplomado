package dgtic.core.controller.tipo;

import dgtic.core.converter.MayusculasConverter;
import dgtic.core.model.entities.TipoEntity;
import dgtic.core.service.tipo.TipoService;
import dgtic.core.util.RenderPagina;
import dgtic.core.validation.TipoValidacion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "tipo")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @Autowired
    private TipoValidacion tipoValidacion;

    @GetMapping("alta-tipo")
    public String altaTipo(Model model) {
        TipoEntity tipo = new TipoEntity();
        model.addAttribute("contenido", "Alta de Tipo");
        model.addAttribute("tipo", tipo);
        return "tipo/alta-tipo";
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

    @PostMapping("salvar-tipo")
    public String salvarTipo(@Valid @ModelAttribute("tipo") TipoEntity tipo, BindingResult result, Model model,
                             RedirectAttributes flash) {
        if (result.hasErrors()) {
            model.addAttribute("contenido", "Error en el nombre, no debe ser vacío.");
            return "tipo/alta-tipo";
        }

        System.out.println("Formulario: " + tipo.getNombre() + " " + tipo.getId_tpo());
        tipoService.guardar(tipo);
        //flash.addFlashAttribute("success", "Se almacenó con éxito.");
        //model.addAttribute("contenido", "Alta de Tipo");
        flash.addFlashAttribute("success", "Se almacenó con éxito.");
        //model.addAttribute("tipo", tipo);
        //return "tipo/alta-tipo";
        return "redirect:/tipo/lista-tipo";
    }

    @GetMapping("lista-tipo")
    public String listaTipo(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<TipoEntity> tipoEntities = tipoService.buscarTipo(pageable);
        RenderPagina<TipoEntity> renderPagina = new RenderPagina<>("lista-tipo", tipoEntities);
        model.addAttribute("tipo", tipoEntities);
        model.addAttribute("page", renderPagina);
        model.addAttribute("contenido", "Lista de Tipos de Peces");
        return "tipo/lista-tipo";

    }

    @GetMapping("eliminar-tipo/{id}")
    public String eliminar(@PathVariable("id") Integer id, RedirectAttributes flash) {
        tipoService.borrar(id);
        flash.addFlashAttribute("success", "Se borró con éxito Tipo");
        return "redirect:/tipo/lista-tipo";
    }

    @GetMapping("modificar-tipo/{id}")
    public String saltoModificar(@PathVariable("id") Integer id, Model model) {
        TipoEntity tipo = tipoService.buscarPorId(id);
        model.addAttribute("tipo", tipo);
        model.addAttribute("contenido", "Modificar Tipo de Peces");
        return "tipo/alta-tipo";
    }


    @InitBinder("tipo")
    public void nombreTipo(WebDataBinder binder) {
        //binder.addValidators(tipoValidacion);
        binder.registerCustomEditor(String.class, "nombre", new MayusculasConverter());
    }

}
