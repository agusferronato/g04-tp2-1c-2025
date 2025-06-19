package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Seccion {

    public abstract int calcularPuntaje();

    public abstract void limpiarSeccion(List<Unidad> pilaDescarte);

    /* Metodo para test */
    public abstract int cantidadDeCartas();

    public abstract int puntajeMaximoCartas();

    public abstract void quemarCartasDePuntaje (int puntaje);

    public abstract void agregarCartasA(CreadorConCartas creador);

    public abstract void agregarComando(CreadorComando creador);

    public abstract void actualizarValores();

    public abstract void quitarComandoClima();

}
