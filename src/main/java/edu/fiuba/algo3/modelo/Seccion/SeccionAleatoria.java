package edu.fiuba.algo3.modelo.Seccion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeccionAleatoria {
    private List<CuerpoACuerpo> secciones;
    public SeccionAleatoria() {
        this.secciones = new ArrayList<>();
    }
    public CuerpoACuerpo obtenerSeccionAleatoria () {
        Collections.shuffle(secciones);
        return secciones.get(0);
    }
}
