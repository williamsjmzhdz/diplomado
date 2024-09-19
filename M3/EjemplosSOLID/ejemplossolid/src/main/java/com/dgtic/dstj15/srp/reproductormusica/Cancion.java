package com.dgtic.dstj15.srp.reproductormusica;

public record Cancion(
    String nombre,
    String artista, 
    String album,
    int duracion,
    String genero,
    String url
) {
    
}
