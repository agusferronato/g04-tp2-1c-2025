package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Mazo;
import edu.fiuba.algo3.modelo.ConversorJSON.ConversorJSON;
import edu.fiuba.algo3.modelo.ConversorJSON.ConversorJugador;
import edu.fiuba.algo3.modelo.ConversorJSON.InstanciasSecciones;
import edu.fiuba.algo3.modelo.LogicaGeneral.Juego;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.LogicaGeneral.Moneda;
import edu.fiuba.algo3.modelo.LogicaGeneral.Tablero;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;
import edu.fiuba.algo3.vistas.components.LayoutJuego;

import java.util.List;

import static edu.fiuba.algo3.modelo.ConversorJSON.Constantes.*;
import static edu.fiuba.algo3.modelo.ConversorJSON.Constantes.JUGADOR_DOS;
import static edu.fiuba.algo3.modelo.ConversorJSON.Constantes.NUMERO_JUGADOR_DOS;
import static edu.fiuba.algo3.modelo.ConversorJSON.Constantes.NUMERO_JUGADOR_UNO;

public class ControladorJuego {
    private Juego juego;
    private LayoutJuego layout;
    private Jugador jugador;
    private Jugador adversario;
    private InstanciasSecciones instanciasSecciones;

    public ControladorJuego () {

        instanciasSecciones = new InstanciasSecciones();
        ConversorJSON conversorJson = new ConversorJSON();

        ConversorJugador conversorJugadorUno = new ConversorJugador(
                JUGADOR_UNO,
                NUMERO_JUGADOR_UNO,
                NUMERO_JUGADOR_DOS,
                instanciasSecciones
        );
        ConversorJugador conversorJugadorDos = new ConversorJugador(
                JUGADOR_DOS,
                NUMERO_JUGADOR_DOS,
                NUMERO_JUGADOR_UNO,
                instanciasSecciones
        );

        jugador = new Jugador(
                conversorJson.obtenerMazo(conversorJugadorUno),
                instanciasSecciones.obtenerContenedorDe(NUMERO_JUGADOR_UNO)
        );

        adversario = new Jugador(
                "Faustino",
                conversorJson.obtenerMazo(conversorJugadorDos),
                instanciasSecciones.obtenerContenedorDe(NUMERO_JUGADOR_DOS)
        );

        Tablero tablero = new Tablero();
        tablero.agregarSeccion(
                jugador,
                instanciasSecciones.obtenerContenedorDe(NUMERO_JUGADOR_UNO)
        );
        tablero.agregarSeccion(
                adversario,
                instanciasSecciones.obtenerContenedorDe(NUMERO_JUGADOR_DOS)
        );

        Moneda moneda = new Moneda(jugador, adversario);

        juego = new Juego(tablero, moneda);
        juego.agregarJugador(jugador);
        juego.agregarJugador(adversario);
    }

    public void setVista (LayoutJuego layout) {
        this.layout = layout;
    }

    public void nombreSeleccionado(String nombre) {
        jugador.setNombre(nombre);
    }

    public List<Carta> obtenerCartasJugador() {
        return jugador.obtenerMano();
    }

    public String obtenerNombreJugador () {
        return jugador.getNombre();
    }

    public String obtenerNombreAdversario () {
        return adversario.getNombre();
    }

    public List<Ubicable> obtenerSecciones() {
        return instanciasSecciones.obtenerSecciones();
    }

    public void jugar(Carta carta) {
        jugador.jugarCarta(carta);
    }

    public void iniciarJuego() {
        juego.iniciar();
    }
}
