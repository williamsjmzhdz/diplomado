package com.dgtic.dstj15.poobasicos.record;

public record Computadora(
    String version, 
    String procesador, 
    int ram, 
    String uuid) {

        public Computadora{ // Constructor
            // Validate something
        }
}
