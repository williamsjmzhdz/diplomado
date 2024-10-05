package dgtic.core.controller.tipo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// endpoint localhost:8080/tipo/alta-tipo
@RequestMapping(value = "tipo")
public class TipoController {

    @GetMapping("alta-tipo")
    public String altaTipo(Model model) {
        model.addAttribute("contenido", "Alta de Tipo");
        return "tipo/alta-tipo";
    }

    @PostMapping("salvar-tipo")
    public String salvarTipo(@RequestParam("nombre") String nombre, Model model) {
        System.out.println("Formulario: " + nombre);
        model.addAttribute("contenido", "Alta de Tipo");
        model.addAttribute("success", "Se almacenó con éxito.");
        model.addAttribute("nombre", nombre);
        //return "tipo/alta-tipo";
        return "redirect:/inicio";
    }

}
