package dgtic.core.controller.caladero;

import dgtic.core.model.entities.CaladeroEntity;
import dgtic.core.model.entities.CompradorEntity;
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
@RequestMapping(value = "caladero")
public class CaladeroController {
    @Autowired
    CaladeroService caladeroService;

    @GetMapping("alta-caladero")
    public String altaCaladero(Model model) {
        CaladeroEntity caladero = new CaladeroEntity();
        model.addAttribute("contenido", "Alta de Caladero");
        model.addAttribute("caladero", caladero);

        return "caladero/alta-caladero";
    }

    @PostMapping("salvar-caladero")
    public String salvarCaladero(@Valid @ModelAttribute("caladero")CaladeroEntity caladero
            , BindingResult result, Model model,
                                  RedirectAttributes flash){
        System.out.println(caladero);
        if(result.hasErrors()){
            model.addAttribute("contenido","Error en el nombre, no debe ser vacío");
            return "caladero/alta-caladero";
        }
        caladeroService.guardar(caladero);
        //model.addAttribute("success","Se almaceno lote con éxito");
        //model.addAttribute("lote",lote);
        flash.addFlashAttribute("success","Se almaceno Caladero con éxito");
//        return "lote/alta-lote";
        return "redirect:/caladero/lista-caladero";
    }

    @GetMapping("lista-caladero")
    public String listaCaladero(@RequestParam(name = "page", defaultValue = "0")int page, Model model){
        Pageable pageable = PageRequest.of(page,2);
        Page<CaladeroEntity> caladeroEntities = caladeroService.buscarCaladero(pageable);
        RenderPagina<CaladeroEntity> renderPagina = new RenderPagina<>("lista-caladero", caladeroEntities);
        model.addAttribute("caladero", caladeroEntities);
        model.addAttribute("page",renderPagina);
        model.addAttribute("contenido","Lista de Caladeros");
        return "caladero/lista-caladero";
    }

    @GetMapping("eliminar-caladero/{id}")
    public String eliminarCaladero(@PathVariable("id")Integer id,RedirectAttributes flash){
        caladeroService.borrar(id);
        flash.addFlashAttribute("success","Se borro con exito Caladero");
        return "redirect:/caladero/lista-caladero";
    }

    @GetMapping("modificar-caladero/{id}")
    public String saltoModificar(@PathVariable("id")Integer id, Model model){
        CaladeroEntity caladero = caladeroService.buscarCaladeroId(id);
        model.addAttribute("caladero",caladero);
        model.addAttribute("contenido","Modificar Caladero");
        return "caladero/alta-caladero";
    }
}
