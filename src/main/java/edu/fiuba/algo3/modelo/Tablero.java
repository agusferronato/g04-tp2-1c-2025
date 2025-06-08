package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private List<Seccion> secciones;

    public Tablero() {
        this.secciones = new ArrayList<Seccion>();
    }

    public void agregarSeccion(Seccion seccion) {
        this.secciones.add(seccion);
    }

    /* Metodo para test */
    public int cantidadDeCartasEnTotal() {
        int acumulador = 0;
        for (Seccion seccion : this.secciones) {
            acumulador += seccion.cantidadDeCartas();
        }
        return acumulador;
    }
}
