```mermaid
classDiagram
    class Pintor {
        +void pinta(Collection<Figura> figuras)
        +void pinta(Cuadrado cuadrado)
        +void pinta(Circulo circulo)
    }

    class Figura
    class Cuadrado
    class Circulo

    Pintor --> Figura
    Pintor --> Cuadrado
    Pintor --> Circulo
