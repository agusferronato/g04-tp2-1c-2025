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

    @Test
    public void test01UnJugadorPoseeCartasSuficientesParaEmpezarElJuego() {
        /* Arrange */
        Mazo mazo = new Mazo();
        for (int i = 0; i < 21; i++) {
            Carta carta = (i < 15) ? new Unidad() : new Especial();
            mazo.agregarCarta(carta);
        }

        List<Mazo> mazos = new ArrayList<>();
        mazos.add(mazo);

        Jugador jugador = new Jugador("Matias", mazos);

        /* Act */
        Mazo mazoSeleccionado = jugador.seleccionarMazo();

        /* Assert */
        assertEquals(21, mazoSeleccionado.cantidadDeCartas());
    }

    @Test
    public void test02AUnJugadorLeReparten10CartasDeSuMazo(){
        /* Arrange */
        Mazo mazo = new Mazo();
        for (int i = 0; i < 21; i++) {
            Carta carta = (i < 15) ? new Unidad() : new Especial();
            mazo.agregarCarta(carta);
        }

        List<Mazo> mazos = new ArrayList<>();
        mazos.add(mazo);

        Jugador jugador = new Jugador("Matias", mazos);
        Mazo mazoSeleccionado = jugador.seleccionarMazo();

        /* Act */
        List<Carta> mano = mazoSeleccionado.seleccionarCartasAlAzar(10);

        /* Assert */
        assertEquals(10, mano.size());
    }

    @Test
    public void test03JugadorPuedeColocarUnaCartaEnUnaSeccion() {
        /* Arrange */
        Seccion seccion = new Seccion();
        Tablero tablero = new Tablero();
        tablero.agregarSeccion(seccion);

        Jugador jugadorMock = mock(Jugador.class);
        when(jugadorMock.seleccionarCarta()).thenReturn(new Unidad(seccion));

        Carta carta = jugadorMock.seleccionarCarta();

        /* Act */
        carta.usar();

        /* Assert */
        assertEquals(1, tablero.cantidadDeCartasEnSeccion(seccion));
    }

    @Test
    public void test04JugadorJuegaCartaDeSuMazoYTienePuntajeParcial(){
        /* Arrange */
        int puntaje = 25;
        Seccion seccion = new Seccion();
        Carta carta = new Unidad(seccion, puntaje);

        Mazo mazo = new Mazo();
        mazo.agregarCarta(carta);

        List<Mazo> mazos = new ArrayList<>();
        mazos.add(mazo);

        Jugador jugador = new Jugador("Matias", mazos);

        Tablero tablero = new Tablero();
        tablero.agregarSeccion(seccion);

        jugador.agregarSeccion(seccion);

        /* Act */
        carta.usar();

        int puntajeJugador = jugador.calcularPuntaje();

        /* Assert */
        assertEquals(puntaje, puntajeJugador);
    }

    /*
    @Test
    public void test05LasCartasPasenAPilaDescarte(){
        // Arrange
        Seccion seccion = new Seccion();
        Mazo mazo = new Mazo();
        for (int i = 0; i < 21; i++) {
            Carta carta = (i < 15) ? new Unidad(seccion) : new Especial();
            mazo.agregarCarta(carta);
        }

        List<Mazo> mazos = new ArrayList<>();
        mazos.add(mazo);

        Jugador jugador = new Jugador("Matias", mazos);

        Tablero tablero = new Tablero();
        tablero.agregarSeccion(seccion);

        jugador.agregarSeccion(seccion);

        Juego juego = new Juego(tablero);
        juego.agregarJugador(jugador);

        Carta carta = jugador.seleccionarCarta();
        carta.usar();

        // Act

        juego.cambiarDeRonda();

        // Assert
        assertEquals(1, jugador.largoPilaDescarte());
    }
    */
}
