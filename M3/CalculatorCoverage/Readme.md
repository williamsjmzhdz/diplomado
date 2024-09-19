# Calculator Project

Este es un proyecto Java simple que incluye una clase `Calculator` con algunas operaciones y pruebas unitarias utilizando JUnit. También se utiliza JaCoCo para generar informes de cobertura de código.

## Ejecutar las Pruebas y Generar el Informe de Cobertura

Asegúrate de tener instalado [Maven](https://maven.apache.org/) en tu sistema.


1. **Ejecutar las Pruebas:**

    ```bash
    mvn clean test
    ```

   Este comando ejecutará las pruebas unitarias y generará los informes de cobertura.

2. **Generar el Informe de Cobertura:**

    ```bash
    mvn jacoco:report
    ```

   Después de ejecutar este comando, encontrarás el informe de cobertura en el directorio `target/site/jacoco/index.html`. Abre este archivo en tu navegador para ver la cobertura de código.

## Estructura del Proyecto

- **src/main/java/com/example/Calculator.java:** Contiene la implementación de la clase `Calculator`.
- **src/test/java/com/example/CalculatorTest.java:** Contiene las pruebas unitarias para la clase `Calculator`.

## Notas Adicionales

- Asegúrate de que tu entorno de desarrollo incluya Java 11 o superior.
- Puedes agregar más funcionalidades a la clase `Calculator` y escribir pruebas adicionales según sea necesario.
- Modifica el contenido de este archivo `README.md` según las necesidades específicas de tu proyecto.

¡Good Luck!
