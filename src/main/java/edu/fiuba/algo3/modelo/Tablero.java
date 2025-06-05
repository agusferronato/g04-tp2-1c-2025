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
    public int cantidadDeCartasEnSeccion(Seccion seccion) {
        for (Seccion seccionActual : this.secciones) {
            if (seccionActual.equals(seccion))
                return seccionActual.cantidadDeCartas();
        }
        return 0;
    }
}
