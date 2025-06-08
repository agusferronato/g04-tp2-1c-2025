package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class ContenedorSecciones extends Seccion {
    private List<Seccion> secciones;
    public ContenedorSecciones () {
        secciones = new ArrayList<>();
    }
    public void agregar(Seccion seccion) {
        secciones.add(seccion);
    }
    @Override
    public int cantidadDeCartas () {
        int acumulador = 0;
        for (Seccion seccion : secciones) {
            acumulador += seccion.cantidadDeCartas();
        }
        return acumulador;
    }

    @Override
    public int calcularPuntaje () {
        int acumulador = 0;
        for (Seccion seccion : this.secciones) {
            acumulador += seccion.calcularPuntaje();
        }
        return acumulador;
    }
}
