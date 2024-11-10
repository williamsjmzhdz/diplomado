package mx.unam.dgtic.clienteweb.services;

import mx.unam.dgtic.dto.AlumnoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class AlumnoWebClientService {

    @Autowired
    private WebClient webClient;

    public List<AlumnoDto> getAll() {
        return webClient.get().uri("/").retrieve().bodyToFlux(AlumnoDto.class)
                .collectList().block();
    }

    public AlumnoDto getAlumnoByMatricula(String matricula) {
        return webClient.get().uri("/{matricula}", matricula).retrieve()
                .bodyToMono(AlumnoDto.class).block();
    }

    public AlumnoDto actualizaAlumno(AlumnoDto alumnoDto) {
        return webClient.put().uri("/{matricula}", alumnoDto.getMatricula())
                .bodyValue(alumnoDto).retrieve().bodyToMono(AlumnoDto.class).block();
    }

}
