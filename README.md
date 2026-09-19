# Estructura de datos: Algoritmos de ordenamiento

Aplicación de escritorio desarrollada en Java que implementa y visualiza siete algoritmos clásicos de ordenamiento con una interfaz gráfica modular construida en Swing.

---

## Características

* **7 Algoritmos de Ordenamiento:**
  * Bubble Sort (Burbuja tradicional)
  * Optimized Bubble Sort (Burbuja mejorada)
  * Insertion Sort (Inserción)
  * Selection Sort (Selección)
  * Shell Sort
  * Merge Sort
  * Quick Sort
* **Entrada Flexible de Datos:** Soporte para generación aleatoria de vectores e ingreso manual mediante valores separados por comas.
* **Selección Aleatoria:** Ejecución estocástica de algoritmos para evaluar comportamientos de ordenamiento sobre la misma estructura de datos.
* **Diseño Arquitectónico Clean:** Separación estricta de responsabilidades entre la capa lógica (`act5.logica`) y la capa de presentación (`act5.gui`).

---

## Tecnologías Utilizadas

* **Lenguaje:** Java (JDK 8 o superior)
* **GUI:** Java Swing & AWT
* **IDE:** Apache NetBeans / IntelliJ IDEA
* **Control de Versiones:** Git & GitHub

---

## Estructura del Proyecto

```text
src/
└── act5/
    ├── Act5.java                   # Punto de entrada principal (Main)
    ├── gui/
    │   └── VentanaPrincipal.java   # Interfaz gráfica de usuario (Swing)
    └── logica/
        └── AlgoritmosOrdenamiento.java # Métodos estáticos de ordenamiento
```

Instalación y Ejecución
Clona el repositorio:
```text
git clone [https://github.com/Mcpapuru9/Act5AlgoritmosOrdenamiento.git](https://github.com/Mcpapu9/Act5AlgoritmosOrdenamiento)
```
Abre el proyecto en tu IDE preferido (NetBeans, IntelliJ IDEA o Eclipse).

Ejecuta la aplicación:
Corre el archivo Act5.java como la clase principal.
