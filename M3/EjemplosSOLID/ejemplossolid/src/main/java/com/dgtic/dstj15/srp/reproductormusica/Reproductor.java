package com.dgtic.dstj15.srp.reproductormusica;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Reproductor {
    List<Cancion> canciones=new ArrayList<>();
    Set<Cancion> listaReproduccion=new TreeSet<>();

    public Reproductor() {
        canciones.add(new Cancion("One", "Metallica", "And justice for all", 8, "Heavy Metal", "https://www.metallica.com/"));
        canciones.add(new Cancion("Como un Actor", "Los Acosta", "Como un actor", 3, "Cumbia", "https://www.losacosta.com/"));
        canciones.add(new Cancion("Cancion 2", "Artista 3", "Album 3", 300, "Genero 3", "Url 3"));
        canciones.add(new Cancion("Cancion 4", "Artista 4", "Album 4", 400, "Genero 4", "Url 4"));

    }

    public void reproducirCancion(Cancion cancion){
        System.out.println("Reproduciendo cancion: "+cancion.nombre());
    }

    public void pausar(){
        System.out.println("Pausando...");
    }

    public void avanzar(){
        System.out.println("Avanzando...");
    }

    public void retroceder(){
        System.out.println("Retrocediendo...");
    }

    public Optional<Cancion> buscarCancionPorArtista(String artista){
        return canciones.stream().filter(cancion->cancion.artista().equals(artista)).findFirst();
    }

    public Optional<Cancion> buscarCancionPorNombre(String nombre){
        return canciones.stream().filter(cancion->cancion.nombre().equals(nombre)).findFirst();
    }

    public List<Cancion> buscarCancionPorGenero(String genero){
        return canciones.stream().filter(cancion->cancion.genero().equals(genero)).collect(Collectors.toList());
    }

    public void agregarCancionAListaReproduccion(Cancion cancion)
    {
        this.listaReproduccion.add(cancion);
    }

    public void eliminarCancionDeListaReproduccion(Cancion cancion){
        this.listaReproduccion.remove(cancion);
    }

    public void visualizarListaReproduccion(){
        System.out.println(this.listaReproduccion);
    }


}
