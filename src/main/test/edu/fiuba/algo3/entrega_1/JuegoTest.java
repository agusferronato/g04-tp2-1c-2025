package edu.fiuba.algo3.entrega_1;

import java.util.ArrayList;
import java.util.List;
import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class JuegoTest {

    private final int CARTAS_MAZO = 21;
    private final int CARTAS_UNIDAD = 15;
    private final int CARTAS_MANO = 10;

    @Test
    public void test01JugadorPoseeCartasSuficientes () {
        /* Arrange */
        Mazo mazo = new Mazo();
        for (int i = 0; i < CARTAS_MAZO; i++) {
            Carta carta = (i < CARTAS_UNIDAD) ? new Unidad() : new Especial();
            mazo.agregarCarta(carta);
        }

        Jugador jugador = new Jugador("Agustin", mazo);

        /* Act */
        int cantidadDeCartasEnMazo = jugador.cantidadDeCartasEnMazo();

        /* Assert */
        assertEquals(CARTAS_MAZO, cantidadDeCartasEnMazo);
    }
    @Test
    public void test02JugadorRecibe10CartasDeSuMazo () {
        /* Arrange */
        Mazo mazo = new Mazo();
        for (int i = 0; i < CARTAS_MAZO; i++) {
            Carta carta = (i < CARTAS_UNIDAD) ? new Unidad() : new Especial();
            mazo.agregarCarta(carta);
        }

        Jugador jugador = new Jugador("Agustin", mazo);
        jugador.tomarCartasDelMazo(CARTAS_MANO);

        /* Act */
        int cantidadDeCartasEnMano = jugador.cantidadDeCartasEnMano();

        /* Assert */
        assertEquals(CARTAS_MANO, cantidadDeCartasEnMano);
    }

    @Test
    public void test03JugadorPuedeColocarUnaCartaEnUnaSeccionDelTablero () {
        /* Arrange */
        int cantidadDeCartasEsperadas = 1;
        Mazo mazo = new Mazo();

        CuerpoACuerpo seccion = new CuerpoACuerpo();

        ContenedorSecciones contenedor = new ContenedorSecciones();
        contenedor.agregar(seccion);

        Unidad unidad = new Unidad(seccion);
        mazo.agregarCarta(unidad);

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Faustino", mazo, contenedor);
        jugador.tomarCartasDelMazo(1);

        tablero.agregarSeccion(contenedor);

        /* Act */
        jugador.jugarCarta(unidad);

        /* Assert */
        assertEquals(cantidadDeCartasEsperadas, tablero.cantidadDeCartasEnTotal());
    }


    @Test
    public void test04VerificarQueUnJugadorTieneUnPuntajeParcialAlJugarUnaCarta() {
        /* Arrange */
        int puntajeEsperado = 25;
        Mazo mazo = new Mazo();

        CuerpoACuerpo seccion = new CuerpoACuerpo();

        ContenedorSecciones contenedor = new ContenedorSecciones();
        contenedor.agregar(seccion);
        Puntaje puntaje = new Puntaje(puntajeEsperado);
        Unidad unidad = new Unidad(seccion, puntaje);
        mazo.agregarCarta(unidad);

        Jugador jugador = new Jugador("Faustino", mazo, contenedor);
        jugador.tomarCartasDelMazo(1);

        /* Act */
        jugador.jugarCarta(unidad);

        /* Assert */
        assertEquals(puntajeEsperado, jugador.calcularPuntaje());
    }

    @Test
    public void test05VerificarQueLasCartasPasenADescarte () {
        /* Arrange */
        int cartasEnDescarteEsperadas = 1;

        CuerpoACuerpo seccion = new CuerpoACuerpo();
        ContenedorSecciones contenedor = new ContenedorSecciones();
        contenedor.agregar(seccion);

        Mazo mazo = new Mazo();
        Carta carta = new Unidad(seccion);
        mazo.agregarCarta(carta);

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Faustino", mazo, contenedor);
        tablero.agregarSeccion(contenedor);

        Juego juego = new Juego(tablero);
        juego.agregarJugador(jugador);
        jugador.tomarCartasDelMazo(1);
        jugador.jugarCarta(carta);

        /* Act */
        juego.pasarDeRonda();

        /* Assert */
        assertEquals(cartasEnDescarteEsperadas, jugador.cartasEnDescarte());
    }

    @Test
    public void test06CartasUnidasDeMismoTipoAcumulanSuPuntaje () {
        /* Arrange */
        int puntajeEsperado = 20;
        int puntajeCartas = 5;
        String tipo = "Catapulta";

        Puntaje puntajeCarta1 = new Puntaje(puntajeCartas);
        Puntaje puntajeCarta2 = new Puntaje(puntajeCartas);
        CuerpoACuerpo seccion = new CuerpoACuerpo();
        Unidad primeraCarta = new Unidad(tipo, seccion, puntajeCarta1);
        Unidad segundaCarta = new Unidad(tipo, seccion, puntajeCarta2);
        Unida cartaModificada = new Unida(primeraCarta, seccion, tipo);

        Mazo mazo = new Mazo();
        mazo.agregarCarta(cartaModificada);
        mazo.agregarCarta(segundaCarta);

        ContenedorSecciones contenedor = new ContenedorSecciones();
        contenedor.agregar(seccion);

        Jugador jugador = new Jugador("Agustin", mazo, contenedor);
        jugador.tomarCartasDelMazo(2);
        jugador.jugarCarta(cartaModificada);

        /* Act */
        jugador.jugarCarta(primeraCarta);

        /* Assert */
        assertEquals(puntajeEsperado, jugador.calcularPuntaje());
    }
    @Test
    public void test07ClimaReduceElValorDeLasCartasDeUnaSeccion () {
        /* Arrange */
        int puntosCarta = 10;
        int puntajeTotalEsperado = 2;

        CuerpoACuerpo seccionJugador1 = new CuerpoACuerpo();
        CuerpoACuerpo seccionJugador2 = new CuerpoACuerpo();

        ContenedorSecciones contenedor = new ContenedorSecciones();
        contenedor.agregar(seccionJugador1);
        contenedor.agregar(seccionJugador2);

        // Jugador 1
        ContenedorSecciones contenedorJugador1 = new ContenedorSecciones();
        contenedorJugador1.agregar(seccionJugador1);
        Puntaje puntaje1 = new Puntaje(puntosCarta);
        Unidad cartaJugador1 = new Unidad(seccionJugador1, puntaje1);
        Mazo mazoJugador1 = new Mazo();
        mazoJugador1.agregarCarta(cartaJugador1);

        Jugador jugador1 = new Jugador("Santiago", mazoJugador1, contenedorJugador1);
        jugador1.tomarCartasDelMazo(2);

        // Jugador 2
        ContenedorSecciones contenedorJugador2 = new ContenedorSecciones();
        contenedorJugador2.agregar(seccionJugador2);
        Puntaje puntaje2 = new Puntaje(puntosCarta);
        Unidad cartaJugador2 = new Unidad(seccionJugador2, puntaje2);
        Clima climaJugador2 = new Clima(contenedor);

        Mazo mazoJugador2 = new Mazo();
        mazoJugador2.agregarCarta(cartaJugador2);
        mazoJugador2.agregarCarta(climaJugador2);

        Jugador jugador2 = new Jugador("Agustin", mazoJugador2, contenedorJugador2);
        jugador2.tomarCartasDelMazo(2);

        jugador1.jugarCarta(cartaJugador1);
        jugador2.jugarCarta(cartaJugador2);

        /* Act */
        jugador2.jugarCarta(climaJugador2);

        /* Assert */
        assertEquals(puntajeTotalEsperado, contenedor.calcularPuntaje());
    }
}