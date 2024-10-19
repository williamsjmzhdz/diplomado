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
    CompradorService compradorService;

    @GetMapping("alta-comprador")
    public String altaComprador(Model model) {
        CompradorEntity comprador = new CompradorEntity();
        model.addAttribute("contenido", "Alta de Comprador");
        model.addAttribute("comprador", comprador);

        return "comprador/alta-comprador";
    }

    @PostMapping("salvar-comprador")
    public String salvarComprador(@Valid @ModelAttribute("comprador")CompradorEntity comprador
            , BindingResult result, Model model,
                             RedirectAttributes flash){
        System.out.println(comprador);
        if(result.hasErrors()){
            model.addAttribute("contenido","Error en el nombre, no debe ser vacío");
            return "comprador/alta-comprador";
        }
        compradorService.guardar(comprador);
        //model.addAttribute("success","Se almaceno lote con éxito");
        //model.addAttribute("lote",lote);
        flash.addFlashAttribute("success","Se almaceno lote con éxito");
//        return "lote/alta-lote";
        return "redirect:/comprador/lista-comprador";
    }

    @GetMapping("lista-comprador")
    public String listaComprador(@RequestParam(name = "page", defaultValue = "0")int page, Model model){
        Pageable pageable = PageRequest.of(page,2);
        Page<CompradorEntity> compradorEntities = compradorService.buscarcomprador(pageable);
        RenderPagina<CompradorEntity> renderPagina = new RenderPagina<>("lista-comprador", compradorEntities);
        model.addAttribute("comprador", compradorEntities);
        model.addAttribute("page",renderPagina);
        model.addAttribute("contenido","Lista de Compradores");
        return "comprador/lista-comprador";
    }

    @GetMapping("eliminar-comprador/{id}")
    public String eliminarComprador(@PathVariable("id")Integer id,RedirectAttributes flash){
        compradorService.borrar(id);
        flash.addFlashAttribute("success","Se borro con exito Comprador");
        return "redirect:/comprador/lista-comprador";
    }

    @GetMapping("modificar-comprador/{id}")
    public String saltoModificar(@PathVariable("id")Integer id, Model model){
        CompradorEntity comprador = compradorService.buscarCompradorId(id);
        model.addAttribute("comprador",comprador);
        model.addAttribute("contenido","Modificar Comprador");
        return "comprador/alta-comprador";
    }

}
