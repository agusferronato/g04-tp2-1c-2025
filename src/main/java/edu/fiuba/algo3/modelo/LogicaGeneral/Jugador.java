package edu.fiuba.algo3.modelo.LogicaGeneral;

import edu.fiuba.algo3.modelo.Carta.*;
import edu.fiuba.algo3.modelo.Seccion.ContenedorSecciones;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jugador {
    private final int CARTAS_MANO = 10;
    private boolean pasoDeRonda;
    private List<Carta> mano;
    private String nombre;
    private Mazo mazo;
    private ContenedorSecciones seccion;
    private List<UnidadGeneral> pilaDescarte;
    private int rondasGanadas;

    public Jugador(String nombre, Mazo mazo, ContenedorSecciones secciones) {
        this.nombre = nombre;
        this.seccion = secciones;
        this.mazo = mazo;
        pasoDeRonda = false;
        rondasGanadas = 0;
        this.pilaDescarte = new ArrayList<>();
        this.mano = new ArrayList<>();
    }

    public Jugador(String nombre, Mazo mazo) {
        this.nombre = nombre;
        this.mazo = mazo;
        pasoDeRonda = false;
        rondasGanadas = 0;
        this.pilaDescarte = new ArrayList<>();
        this.mano = new ArrayList<>();
    }

    public Jugador() {
        pasoDeRonda = false;
        rondasGanadas = 0;
    }

    public Jugador(String nombre) {
        this.nombre =  nombre;
    }

    public Jugador(Mazo mazo, ContenedorSecciones contenedorSecciones) {
        this.mazo = mazo;
        pasoDeRonda = false;
        rondasGanadas = 0;
        this.pilaDescarte = new ArrayList<>();
        this.mano = new ArrayList<>();
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public int calcularPuntaje() {
        return seccion.calcularPuntaje();
    }

    public void jugarCarta(Carta carta) {
        if (!mano.contains(carta)) {
            throw new CartaYaJugadaError("La carta no se encuentra en la mano");
        }
        carta.usar(this);
        mano.remove(carta);
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
    public void agregarADescarte(UnidadGeneral carta) {
        this.pilaDescarte.add(carta);
    }

    public UnidadGeneral tomarDePilaDescarte() {
        if (!pilaDescarte.isEmpty()) {
            UnidadGeneral carta = GeneradorAleatorioCartas.cartasAlAzar(this.pilaDescarte);
            this.pilaDescarte.remove(carta);
            this.mano.add(carta);
            return carta;
        }
        return null;
    }

    public void descartarCartasDe(Ubicable ubicable) {
        pasoDeRonda = false;
        ubicable.limpiarSeccion(this.pilaDescarte);
    }

    public boolean pasoDeRonda() {
        return pasoDeRonda;
    }

    public void pasarDeRonda() {
        pasoDeRonda = true;
    }

    public boolean tieneDiferenciaDeDosCon(Jugador otroJugador) {
        return (otroJugador.tieneMasDeDosRondas(rondasGanadas));
    }

    private boolean tieneMasDeDosRondas(int rondas) {
        return rondasGanadas >= 2 || rondas >= 2;
    }

    public void ganaRondaSiTieneMasPuntosQue(Jugador jugador) {
        int puntos = seccion.calcularPuntaje();
        if (jugador.tieneMenosPuntosQue(puntos))
            rondasGanadas++;
    }

    private boolean tieneMenosPuntosQue(int puntos) {
        return seccion.calcularPuntaje() < puntos;
    }

    public Jugador siTieneMasRondasGanadasQue(Jugador jugador) {
        if (jugador.tieneMasRondasGanadasQue(this))
            return jugador;
        else if (tieneMasRondasGanadasQue(jugador))
            return this;
        return null;
    }

    private boolean tieneMasRondasGanadasQue(Jugador jugador) {
        return jugador.tieneMenosRondasGanadasQue(rondasGanadas);
    }

    private boolean tieneMenosRondasGanadasQue(int rondas) {
        return rondasGanadas < rondas;
    }


    public List<Carta> obtenerMano() {
        return mano;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void tomarDosCartasDelMazo() {
        List<Carta> cartasSeleccionadas = this.mazo.seleccionarCartasAlAzar(2);
        Collections.shuffle(mano);
        mano.addAll(cartasSeleccionadas);
        mazo.quitarCartas(cartasSeleccionadas);
        mano.remove(0);
        mano.remove(0);
    }
}
