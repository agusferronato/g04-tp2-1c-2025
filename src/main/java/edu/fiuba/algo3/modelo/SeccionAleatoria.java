package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeccionAleatoria {
    private List<Seccion> secciones;
    public SeccionAleatoria() {
        this.secciones = new ArrayList<>();
    }
    public Seccion obtenerSeccionAleatoria () {
        Collections.shuffle(secciones);
        return secciones.get(0);
    }
}
