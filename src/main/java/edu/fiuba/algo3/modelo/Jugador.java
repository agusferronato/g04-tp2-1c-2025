package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jugador {
    private final int CARTAS_MANO = 10;
    private List<Carta> mano;
    private String nombre;
    private Mazo mazo;
    private ContenedorSecciones seccion;
    private List<Unidad> pilaDescarte;

    public Jugador(String nombre, Mazo mazo, ContenedorSecciones secciones) {
        this.nombre = nombre;
        this.seccion = secciones;
        this.mazo = mazo;
        this.pilaDescarte = new ArrayList<>();
        this.mano = new ArrayList<>();
    }

    public Jugador(String nombre, Mazo mazo) {
        this.nombre = nombre;
        this.mazo = mazo;
        this.pilaDescarte = new ArrayList<>();
        this.mano = new ArrayList<>();
    }

    public int calcularPuntaje() {
        return seccion.calcularPuntaje();
    }

    public void jugarCarta(Carta carta) {
        carta.usar(this);
    }

    public void descartarCartas() {
        this.seccion.limpiarSeccion(this.pilaDescarte);
    }

    public int cartasEnDescarte() {
        return this.pilaDescarte.size();
    }

    public void tomarCartasDelMazo(int cartasDelMazoATomar) {
        List<Carta> cartas = this.mazo.seleccionarCartasAlAzar(cartasDelMazoATomar);
        this.mazo.quitarCartas(cartas);
        this.mano.addAll(cartas);
    }

    /* Metodo para test */
    public int cantidadDeCartasEnMano() {
        return this.mano.size();
    }

    public void descartar(Carta carta) {
        this.mano.remove(carta);
    }

    /* Metodo para test */
    public int cantidadDeCartasEnMazo () {
        return this.mazo.cantidadDeCartas();
    }

    /* Metodo para test */
    public void agregarADescarte(Unidad carta) {
        this.pilaDescarte.add(carta);
    }

    public Unidad tomarDePilaDescarte() {
        Unidad carta = GeneradorAleatorioCartas.cartasAlAzar(this.pilaDescarte);
        this.pilaDescarte.remove(carta);
        this.mano.add(carta);
        return carta;
    }
}
