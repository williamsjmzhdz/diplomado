package dgtic.core.controller.especie;

import dgtic.core.model.entities.EspecieEntity;
import dgtic.core.model.entities.LoteEntity;
import dgtic.core.model.entities.TipoEntity;
import dgtic.core.service.especie.EspecieService;
import dgtic.core.service.lote.LoteService;
import dgtic.core.service.tipo.TipoService;
import dgtic.core.util.Archivos;
import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping(value = "especie")
@SessionAttributes("especie")
public class EspecieController {
    @Value("${ejemplo.imagen.ruta}")
    private String archivoRuta;

    @Autowired
    LoteService loteService;

    @Autowired
    TipoService tipoService;

    @Autowired
    EspecieService especieService;

    @GetMapping("alta-especie")
    public String verEspecie(Model model){
        EspecieEntity especie = new EspecieEntity();
        List<LoteEntity> selectLote = loteService.lotes();
        List<TipoEntity> selectTipo = tipoService.tipos();

        model.addAttribute("contenido", "Alta Especie");
        model.addAttribute("especie", especie);
        model.addAttribute("selectLote", selectLote);
        model.addAttribute("selectTipo", selectTipo);

        return "especie/alta-especie";


    }

    @PostMapping(value = "salvar-especie")
    public String guardarEspecie(@Valid @ModelAttribute("especie") EspecieEntity especie,
                                 BindingResult result,
                                 Model model, RedirectAttributes flash,
                                 SessionStatus sesion){
        List<LoteEntity> selectLote = loteService.lotes();
        List<TipoEntity> selectTipo = tipoService.tipos();
        model.addAttribute("selectLote", selectLote);
        model.addAttribute("selectTipo", selectTipo);
        if (result.hasErrors()) {
            model.addAttribute("contenido", "Error en la entra de datos");
            return "especie/alta-especie";
        }
        if(especie.getImagen()!=null){
            especieService.guardar(especie);
            sesion.setComplete();
            model.addAttribute("success","Almacenamiento correcto");
        }
        return "especie/alta-especie";
    }

    @PostMapping(value = "salvar-imagen")
    public String guardarImagen(@RequestParam("imagenarchivo")MultipartFile multipartFile,
                                HttpSession session, Model model){
        EspecieEntity especie = new EspecieEntity();
        if (!multipartFile.isEmpty()) {
            String imagenNombre = Archivos.almacenar(multipartFile, archivoRuta);
            if (imagenNombre != null) {
                especie = (EspecieEntity) session.getAttribute("especie");
                especie.setImagen(imagenNombre);
            }
        }
        List<LoteEntity> selectLote = loteService.lotes();
        List<TipoEntity> selectTipo = tipoService.tipos();
        model.addAttribute("selectLote", selectLote);
        model.addAttribute("selectTipo", selectTipo);
        model.addAttribute("especie", especie);
        return "especie/alta-especie";
    }

    @GetMapping("pdf")
    public String generarPdf(Model model, HttpSession sesion) {
        //obteniendo la variable de sesión
        EspecieEntity esp = (EspecieEntity) sesion.getAttribute("especie");
        List<EspecieEntity> lista = especieService.buscarEspecie(esp.getId_epe());
        model.addAttribute("datos", lista);
        model.addAttribute("ruta", archivoRuta);
        return "especie/especie-pdf";
    }

    @PostMapping("buscar-especie")
    public String buscarReservaconTabla(@Valid @ModelAttribute("especie") EspecieEntity especie
            , BindingResult result, Model model, RedirectAttributes flash) {
        List<EspecieEntity> especies = especieService.buscarEspecie(especie.getId_epe());
        model.addAttribute("datos", especies);
        return "especie/buscar-especie";
    }

    @GetMapping(value = "buscar-especie")
    public String buscarEspeciePagina(Model model) {
        EspecieEntity entity = new EspecieEntity();
        List<EspecieEntity> lista = new ArrayList<>();
        model.addAttribute("especie", entity);
        model.addAttribute("datos", lista);
        model.addAttribute("contenido", "Buscar especie por nombre");
        return "especie/buscar-especie";
    }

    @GetMapping(value = "buscar-especie-nombre/{dato}", produces = "application/json")
    public @ResponseBody List<EspecieEntity> buscarEspecie(@PathVariable String dato) {
        return especieService.buscarEspeciePatron(dato);
    }

    @GetMapping("correo")
    private String gmail(Model model, HttpSession sesion) {
        EspecieEntity esp = (EspecieEntity) sesion.getAttribute("especie");
        System.out.println(esp.getImagen() + "<----");
        List<EspecieEntity> lista = especieService.buscarEspecie(esp.getId_epe());
        String gmail = "";
        String pswd = "";
        Properties p = System.getProperties();
        p.setProperty("mail.smtps.host", "smpt.gmail.com");
        p.setProperty("mail.smtps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        p.setProperty("mail.smtps.socketFactory.fallback", "false");
        p.setProperty("mail.smtp.port", "465");
        p.setProperty("mail.smtp.socketFactory.port", "465");
        p.setProperty("mail.smtps.auth", "true");
        p.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        p.setProperty("mail.smtps.ssl.trust", "smtp.gmail.com");
        p.setProperty("mail.smtp.ssl.quitwait", "false");

        String cadena = "<h2>Nombre de la especie</br>";
        for (EspecieEntity s : lista) {
            cadena += "<h2>" +
                    s.getNombre() +
                    "</h2></br>";
        }

        try {
            Session session = Session.getInstance(p, null);
            MimeMessage message = new MimeMessage(session);

            MimeBodyPart texto = new MimeBodyPart();
            texto.setContent(cadena, "text/html;charset=utf-8");
            //adjuntar la imagen
            BodyPart adjunto = new MimeBodyPart();
            String r = archivoRuta + lista.get(0).getImagen() + ".pdf";
            adjunto.setDataHandler(new DataHandler(new FileDataSource(r)));
            adjunto.setFileName("especie.pdf");
            Multipart multiple = new MimeMultipart();
            multiple.addBodyPart(texto);
            multiple.addBodyPart(adjunto);

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(" ", false));
            message.setSubject("Especie Registrada en B.D");
            message.setContent(multiple);
            message.setSentDate(new Date());
            Transport transport = (Transport) session.getTransport("smtps");
            transport.connect("smtp.gmail.com", gmail, pswd);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("success", "El correo se mando con éxito");
        model.addAttribute("datos", lista);
        model.addAttribute("ruta", archivoRuta);
        return "especie/buscar-especie";
    }

}
