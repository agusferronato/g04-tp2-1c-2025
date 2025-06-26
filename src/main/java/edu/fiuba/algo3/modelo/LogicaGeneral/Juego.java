package edu.fiuba.algo3.modelo.LogicaGeneral;

import edu.fiuba.algo3.modelo.Carta.Carta;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private static int CARTAS_DEL_MAZO_A_TOMAR = 10;
    private int rondas;
    private boolean juegoFinalizado;
    private Jugador ganador, jugadorActual;
    private Moneda moneda;
    private List<Jugador> jugadores;
    private Tablero tablero;

    public Juego (Tablero tablero) {
        rondas = 0;
        this.jugadores = new ArrayList<>();
        this.tablero = tablero;
    }

    public Juego(Tablero tablero, Moneda moneda) {
        this.jugadores = new ArrayList<>();
        rondas = 0;
        this.tablero = tablero;
        this.moneda = moneda;
    }

    public void agregarJugador (Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public void pasarDeRonda () {
        for (Jugador jugador : this.jugadores) {
            jugador.descartarCartas();
        }
    }

    private Jugador jugadorContrarioA (Jugador jugador) {
        return (jugador.equals(jugadores.get(0)) ? jugadores.get(1) : jugadores.get(0));
    }


    public void repartirCartas () {
        for (Jugador jugador : this.jugadores) {
            jugador.tomarCartasDelMazo(CARTAS_DEL_MAZO_A_TOMAR);
        }
    }

    public void iniciar() {
        jugadorActual = moneda.jugadorInicial();
    }


    public void jugar (Carta carta) {
        jugadorActual.jugarCarta(carta);
        cambiarTurno();
    }

    public void cambiarTurno () {
        Jugador jugadorContrario = jugadorContrarioA(jugadorActual);
        if (!jugadorContrario.pasoDeRonda()) {
            jugadorActual = jugadorContrario;
        } else if (jugadorActual.pasoDeRonda() && jugadorContrario.pasoDeRonda()) {
            cambiarDeRonda();
        }
    }

    public void cambiarDeRonda () {
        Jugador jugadorContrario = jugadorContrarioA(jugadorActual);
        calcularGanadorRonda();
        if (rondas == 3 || jugadorActual.tieneDiferenciaDeDosCon(jugadorContrario)) {
            juegoFinalizado = true;
            ganador = calcularGanadorJuego();
        } else {
            rondas++;
        }
        tablero.levantarCartasPara(jugadorActual);
        tablero.levantarCartasPara(jugadorContrario);
        tablero.limpiarComandos();
        cambiarTurno();
    }

    public void calcularGanadorRonda () {
        jugadorActual.ganaRondaSiTieneMasPuntosQue(jugadorContrarioA(jugadorActual));
    }

    public Jugador calcularGanadorJuego () {
        return jugadorActual.siTieneMasRondasGanadasQue(jugadorContrarioA(jugadorActual));
    }

    public Jugador obtenerGanador () {
        return ganador;
    }

    public void pasar() {
        jugadorActual.pasarDeRonda();
        cambiarTurno();
    }

    public void repartirCartas(int cantidadDeCartasATomar) {
        for (Jugador jugador : this.jugadores) {
            jugador.tomarCartasDelMazo(cantidadDeCartasATomar);
        }
    }
}
