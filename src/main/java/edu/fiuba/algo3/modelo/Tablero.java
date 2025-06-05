package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

import java.util.List;

public class Tablero {
    private List<Seccion> secciones;

    public Tablero() {
        this.secciones = new ArrayList<Seccion>();
    }

    public void agregarSeccion(Seccion seccion) {

    }

    public int cantidadDeCartasEnSeccion(Seccion seccion) {
        return 1;
    }
}
