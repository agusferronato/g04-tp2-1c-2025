package edu.fiuba.algo3.modelo.LogicaGeneral;

import edu.fiuba.algo3.modelo.Seccion.Seccion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tablero {
    private Map<Jugador, Seccion> secciones;

    public Tablero() {
        this.secciones = new HashMap<>();
    }

    public void agregarSeccion(Seccion seccion) {
        this.secciones.put(new Jugador(), seccion);
    }

    public void agregarSeccion (Jugador jugador, Seccion seccion) {
        this.secciones.put(jugador, seccion);
    }

    /* Metodo para test */
    public int cantidadDeCartasEnTotal() {
        int acumulador = 0;
        for (Seccion seccion : secciones.values()) {
            acumulador += seccion.cantidadDeCartas();
        }
        return acumulador;
    }

    public void levantarCartasPara(Jugador jugador) {
        Seccion seccion = secciones.get(jugador);
        seccion.levantarCartasPara(jugador);
    }

    public void limpiarComandos() {
        for (Seccion seccion : secciones.values()) {
            seccion.quitarComandos();
        }
    }
}
