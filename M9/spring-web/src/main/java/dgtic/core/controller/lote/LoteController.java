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
//endpoint localhost:8080/lote/lote-tipo
@RequestMapping(value = "lote")
public class LoteController {
    @Autowired
    LoteService loteService;

    @GetMapping("alta-lote")
    public String altaTipo(Model model) {
        LoteEntity lote = new LoteEntity();
        model.addAttribute("contenido", "Alta de Tipo");
        model.addAttribute("lote",lote);

        return "lote/alta-lote";
    }



    @PostMapping("salvar-lote")
    public String salvarLote(@Valid @ModelAttribute("lote")LoteEntity lote
            , BindingResult result,Model model,
                             RedirectAttributes flash){
        System.out.println(lote);
        if(result.hasErrors()){
            model.addAttribute("contenido","Error en el nombre, no debe ser vacío");
            return "lote/alta-lote";
        }
        loteService.guardar(lote);
        //model.addAttribute("success","Se almaceno lote con éxito");
        //model.addAttribute("lote",lote);
        flash.addFlashAttribute("success","Se almaceno lote con éxito");
//        return "lote/alta-lote";
        return "redirect:/lote/lista-lote";
    }

    @GetMapping("lista-lote")
    public String listaLote(@RequestParam(name = "page", defaultValue = "0")int page, Model model){
        Pageable pageable = PageRequest.of(page,2);
        Page<LoteEntity> loteEntities = loteService.buscarLote(pageable);
        RenderPagina<LoteEntity> renderPagina = new RenderPagina<>("lista-lote", loteEntities);
        model.addAttribute("lote", loteEntities);
        model.addAttribute("page",renderPagina);
        model.addAttribute("contenido","Lista de lotes de Peces");
        return "lote/lista-lote";
    }

    @GetMapping("eliminar-lote/{id}")
    public String eliminar(@PathVariable("id")Integer id,RedirectAttributes flash){
        loteService.borrar(id);
        flash.addFlashAttribute("success","Se borro con exito Lote");
        return "redirect:/lote/lista-lote";
    }

    @GetMapping("modificar-lote/{id}")
    public String saltoModificar(@PathVariable("id")Integer id, Model model){
        LoteEntity lote = loteService.buscarLoteId(id);
        model.addAttribute("lote",lote);
        model.addAttribute("contenido","Modificar lotes");
        return "lote/alta-lote";
    }
}
