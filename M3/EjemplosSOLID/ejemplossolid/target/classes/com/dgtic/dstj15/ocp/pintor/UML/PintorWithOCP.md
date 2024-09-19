```mermaid
classDiagram
    class Figura {
        <<Interface>>
        pinta()
    }

    class Cuadrado {
        +void pinta()
    }

    class Circulo {
        +void pinta()
    }

    class Pintor {
        +void pinta(Collection<Figura> figuras)
    }

    Figura <|.. Cuadrado
    Figura <|.. Circulo
    Pintor --> Figura
