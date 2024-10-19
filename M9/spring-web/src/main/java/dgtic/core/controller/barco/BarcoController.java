package dgtic.core.controller.barco;

import dgtic.core.model.entities.BarcoEntity;
import dgtic.core.model.entities.CaladeroEntity;
import dgtic.core.service.barco.BarcoService;
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
@RequestMapping("barco")
public class BarcoController {
    @Autowired
    BarcoService barcoService;

    @GetMapping("alta-barco")
    public String altaCaladero(Model model) {
        BarcoEntity barco = new BarcoEntity();
        model.addAttribute("contenido", "Alta de Barco");
        model.addAttribute("barco", barco);

        return "barco/alta-barco";
    }

    @PostMapping("salvar-barco")
    public String salvarBarco(@Valid @ModelAttribute("barco")BarcoEntity barco
            , BindingResult result, Model model,
                                 RedirectAttributes flash){
        System.out.println(barco);
        if(result.hasErrors()){
            model.addAttribute("contenido","Error en el nombre, no debe ser vacío");
            return "barco/alta-barco";
        }
        barcoService.guardar(barco);
        //model.addAttribute("success","Se almaceno lote con éxito");
        //model.addAttribute("lote",lote);
        flash.addFlashAttribute("success","Se almaceno Barco con éxito");
//        return "lote/alta-lote";
        return "redirect:/barco/lista-barco";
    }

    @GetMapping("lista-barco")
    public String listaBarco(@RequestParam(name = "page", defaultValue = "0")int page, Model model){
        Pageable pageable = PageRequest.of(page,2);
        Page<BarcoEntity> barcoEntities = barcoService.buscarBarco(pageable);
        RenderPagina<BarcoEntity> renderPagina = new RenderPagina<>("lista-barco", barcoEntities);
        model.addAttribute("barco", barcoEntities);
        model.addAttribute("page",renderPagina);
        model.addAttribute("contenido","Lista de Barcos");
        return "barco/lista-barco";
    }

    @GetMapping("eliminar-barco/{id}")
    public String eliminarBarco(@PathVariable("id")Integer id,RedirectAttributes flash){
        barcoService.borrar(id);
        flash.addFlashAttribute("success","Se borro con exito Barco");
        return "redirect:/barco/lista-barco";
    }

    @GetMapping("modificar-barco/{id}")
    public String saltoModificar(@PathVariable("id")Integer id, Model model){
        BarcoEntity barco = barcoService.buscarBarcoId(id);
        model.addAttribute("barco",barco);
        model.addAttribute("contenido","Modificar Barco");
        return "barco/alta-barco";
    }
}
