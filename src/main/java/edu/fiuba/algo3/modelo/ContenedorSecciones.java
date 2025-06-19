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
    public int puntajeMaximoCartas() {
        int puntajeMaximo = -1;
        for (Seccion seccion : secciones) {
            int puntaje = seccion.puntajeMaximoCartas();
            if (puntaje >= puntajeMaximo)
                puntajeMaximo = puntaje;
        }
        return puntajeMaximo;
    }

    @Override
    public void quemarCartasDePuntaje(int puntaje) {
        for (Seccion seccion : secciones) {
            seccion.quemarCartasDePuntaje(puntaje);
        }
    }


    @Override
    public void agregarCartasA(CreadorConCartas creador) {
        for (Seccion seccion : secciones) {
            seccion.agregarCartasA(creador);
        }
    }

    @Override
    public void agregarComando(CreadorComando creador) {
        for (Seccion seccion : secciones) {
            seccion.agregarComando(creador);
        }
    }

    @Override
    public void actualizarValores() {
        for (Seccion seccion : secciones) {
            seccion.actualizarValores();
        }
    }

    @Override
    public void quitarComandoClima() {
        for (Seccion seccion : secciones) {
            seccion.quitarComandoClima();
        }
    }


    public void quemarCartasMasFuertes() {
        int puntajeMaximo = -1;
        for (Seccion seccion : secciones) {
            int puntaje = seccion.puntajeMaximoCartas();
            if (puntaje >= puntajeMaximo)
                puntajeMaximo = puntaje;
        }
        for (Seccion seccion : secciones) {
            seccion.quemarCartasDePuntaje(puntajeMaximo);
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
