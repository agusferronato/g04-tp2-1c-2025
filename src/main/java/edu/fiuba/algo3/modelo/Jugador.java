package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jugador {

    private String nombre;
    private List<Mazo> mazos;
    private ContenedorSecciones seccion;
    private List<Unidad> pilaDescarte;

    public Jugador(String nombre, List<Mazo> mazos, ContenedorSecciones secciones) {
        this.nombre = nombre;
        this.seccion = secciones;
        this.mazos = mazos;
        this.pilaDescarte = new ArrayList<>();
    }

    public Jugador(String nombre, List<Mazo> mazos) {
        this.nombre = nombre;
        this.mazos = mazos;
    }

    public Mazo seleccionarMazo () {
        return this.mazos.get(0);
    }

    public int calcularPuntaje() {
        return seccion.calcularPuntaje();
    }

    public void jugarCarta() {
        Mazo mazo = this.mazos.get(0);
        Carta carta = mazo.seleccionarCartaAlAzar();
        carta.usar();
    }

    public void descartarCartas() {
        this.seccion.limpiarSeccion(this.pilaDescarte);
    }

    public int cartasEnDescarte() {
        return this.pilaDescarte.size();
    }
}
