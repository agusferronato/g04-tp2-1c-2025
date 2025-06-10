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
    public void setStrategy(EstrategiaCambioPuntos estrategia) {
        for (Seccion seccion : secciones) {
            seccion.setStrategy(estrategia);
        }
    }

    @Override
    public void actualizarValores() {
        for (Seccion seccion : secciones) {
            seccion.actualizarValores();
        }
    }

    @Override
    public int calcularPuntaje () {
        int acumulador = 0;
        for (Seccion seccion : this.secciones) {
            acumulador += seccion.calcularPuntaje();
        }
        return acumulador;
    }

    @Override
    public void limpiarSeccion (List<Unidad> pilaDescarte) {
        for (Seccion seccion : this.secciones) {
            seccion.limpiarSeccion(pilaDescarte);
        }
    }
}
