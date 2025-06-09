package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Seccion {
    protected List<Unidad> cartas;

    public Seccion () {
        this.cartas = new ArrayList<>();
    }

    public void ubicar(Unidad carta) {
        this.cartas.add(carta);
    }

    public abstract int calcularPuntaje ();

    public abstract void limpiarSeccion (List<Unidad> pilaDescarte);

    /* Metodo para test */
    public abstract int cantidadDeCartas ();

}
