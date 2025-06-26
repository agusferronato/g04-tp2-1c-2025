package edu.fiuba.algo3.modelo.Seccion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeccionAleatoria {
    private ContenedorSecciones contenedor;

    public SeccionAleatoria(ContenedorSecciones contenedor) {
        this.contenedor = contenedor;
    }

    public Ubicable obtenerSeccionAleatoria () {
        return contenedor.obtenerSeccionAlAzar(this);
    }

    public Ubicable obtenerSeccionAleatoria (List<Ubicable> secciones) {
        Collections.shuffle(secciones);
        return secciones.get(0);
    }
}
