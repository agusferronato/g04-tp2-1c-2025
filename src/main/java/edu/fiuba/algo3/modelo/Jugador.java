package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private List<Mazo> mazos;
    private List<Seccion> secciones;


    public Jugador() {
        this.secciones = new ArrayList<Seccion>();
    }

    public void agregarSeccion(Seccion seccion) {
        secciones.add(seccion);

    }

    public Jugador(String nombre, List<Mazo> mazos) {
        this.nombre = nombre;
        this.mazos = mazos;
        this.secciones = new ArrayList<Seccion>();
    }

    public Mazo seleccionarMazo () {
        return this.mazos.get(0);
    }

    public Carta seleccionarCarta() {
        return new Unidad();
    }

    public int calcularPuntaje(){
        int acumulador = 0;
        for (Seccion seccion : this.secciones) {
            acumulador += seccion.calcularPuntaje();
        }
        return acumulador;
    }
}
