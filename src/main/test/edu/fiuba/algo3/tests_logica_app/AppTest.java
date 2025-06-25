package edu.fiuba.algo3.tests_logica_app;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Mazo;
import edu.fiuba.algo3.modelo.ConversorJSON.ConversorJSON;
import edu.fiuba.algo3.modelo.ConversorJSON.ConversorJugador;
import edu.fiuba.algo3.modelo.ConversorJSON.InstanciasSecciones;
import edu.fiuba.algo3.modelo.LogicaGeneral.Juego;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.LogicaGeneral.Moneda;
import edu.fiuba.algo3.modelo.LogicaGeneral.Tablero;
import edu.fiuba.algo3.modelo.Seccion.SeccionAleatoria;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.ConversorJSON.Constantes.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppTest {
    @Test
    public void test01JugadorUnoGanaSiPoneUnaCartaYElContrarioSeRinde () {

        InstanciasSecciones instanciasSecciones = new InstanciasSecciones();
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


        Mazo mazo = conversorJson.obtenerMazo(conversorJugadorUno);

        Carta primeraCarta = mazo.getCarta(0);
        Carta segundaCarta = mazo.getCarta(1);

        Jugador jugadorUno = new Jugador(
                "Agustin",
                mazo,
                instanciasSecciones.obtenerContenedorDe(NUMERO_JUGADOR_UNO)
        );

        Jugador jugadorDos = new Jugador(
                "Faustino",
                conversorJson.obtenerMazo(conversorJugadorDos),
                instanciasSecciones.obtenerContenedorDe(NUMERO_JUGADOR_DOS)
        );

        Tablero tablero = new Tablero();
        tablero.agregarSeccion(instanciasSecciones.obtenerContenedorDe(NUMERO_JUGADOR_UNO));
        tablero.agregarSeccion(instanciasSecciones.obtenerContenedorDe(NUMERO_JUGADOR_DOS));

        Moneda monedaMock = mock(Moneda.class);
        when(monedaMock.jugadorInicial()).thenReturn(jugadorUno);

        Juego juego = new Juego(tablero, monedaMock);
        juego.agregarJugador(jugadorUno);
        juego.agregarJugador(jugadorDos);


        juego.iniciar(); /* Se reparten cartas y se elige el jugador que comienza */

        juego.jugar(primeraCarta); /* JUGADOR 1 comienza */

        juego.pasar(); /* JUGADOR 2 pasa */
        juego.pasar(); /* JUGADOR 1 pasa y gana la primer ronda */

        juego.pasar();
        juego.jugar(segundaCarta);
        juego.pasar(); /* Pasa jugador 1 y gana la partida */


        assertEquals(jugadorUno, juego.ganador());
    }
}
