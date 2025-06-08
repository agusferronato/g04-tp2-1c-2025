package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jugador {
    private String nombre;
    private List<Mazo> mazos;
    private ContenedorSecciones secciones;

    public Jugador(String nombre, List<Mazo> mazos, ContenedorSecciones secciones) {
        this.nombre = nombre;
        this.secciones = secciones;
        this.mazos = mazos;
    }

    public Jugador(String nombre, List<Mazo> mazos) {
        this.nombre = nombre;
        this.mazos = mazos;
    }

    public Mazo seleccionarMazo () {
        return this.mazos.get(0);
    }

    public int calcularPuntaje(){
        return secciones.calcularPuntaje();
    }

    public void jugarCarta() {
        Mazo mazo = this.mazos.get(0);
        List<Carta> cartas = mazo.seleccionarCartasAlAzar(1);
        cartas.get(0).usar();
    }
}
