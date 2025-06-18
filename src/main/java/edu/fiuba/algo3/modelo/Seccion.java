package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Seccion {

    public abstract int calcularPuntaje();

    public abstract void limpiarSeccion(List<Unidad> pilaDescarte);

    public abstract void aplicarClima();

    /* Metodo para test */
    public abstract int cantidadDeCartas();

    public abstract void reestablecerPuntajeCartas();

    public abstract int puntajeMaximoCartas();

    public abstract void quemarCartasDePuntaje (int puntaje);
}
