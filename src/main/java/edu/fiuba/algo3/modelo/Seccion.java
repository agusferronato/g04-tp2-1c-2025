package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Seccion {
    protected List<Unidad> cartas;

    public Seccion() {
        this.cartas = new ArrayList<>();
    }

    public abstract int calcularPuntaje();

    public abstract void limpiarSeccion(List<Unidad> pilaDescarte);

    public void ubicar (Unidad unidad) {
        cartas.add(unidad);
    }

    /* Metodo para test */
    public abstract int cantidadDeCartas();

    public abstract void setStrategy(EstrategiaCambioPuntos estrategia);

    public abstract void actualizarValores();

    public abstract void reestablecerPuntajeCartas();

    public abstract int puntajeMaximoCartas();

    public abstract void quemarCartasDePuntaje (int puntaje);
}
