package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Seccion {
    private List<Unidad> cartas;

    public Seccion () {
        this.cartas = new ArrayList<Unidad>();
    }

    public void ubicar(Unidad unidad) {
        this.cartas.add(unidad);
    }

    public abstract int calcularPuntaje();

    public abstract void limpiarSeccion(List<Unidad> pilaDescarte);

    /* Metodo para test */
    public abstract int cantidadDeCartas();

}
