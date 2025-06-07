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

        List<Mazo> mazos = new ArrayList<>();
        mazos.add(mazo);

        Jugador jugador = new Jugador("Agustin", mazos);

        /* Act */
        Mazo mazoSeleccionado = jugador.seleccionarMazo();

        /* Assert */
        assertEquals(CARTAS_MAZO, mazoSeleccionado.cantidadDeCartas());
    }
    @Test
    public void test02JugadorRecibe10CartasDeSuMazo () {
        /* Arrange */
        Mazo mazo = new Mazo();
        for (int i = 0; i < CARTAS_MAZO; i++) {
            Carta carta = (i < CARTAS_UNIDAD) ? new Unidad() : new Especial();
            mazo.agregarCarta(carta);
        }

        List<Mazo> mazos = new ArrayList<>();
        mazos.add(mazo);

        Jugador jugador = new Jugador("Agustin", mazos);
        Mazo mazoSeleccionado = jugador.seleccionarMazo();

        /* Act */
        List<Carta> mano = mazoSeleccionado.seleccionarCartasAlAzar(CARTAS_MANO);

        /* Assert */
        assertEquals(CARTAS_MANO, mano.size());
    }

    @Test
    public void test03JugadorPuedeColocarUnaCartaEnUnaSeccionDelTablero () {
        /* Arrange */
        int cantidadDeCartasEsperadas = 1;
        Mazo mazo = new Mazo();

        CuerpoACuerpo seccionCuerpoACuerpo = new CuerpoACuerpo();

        ContenedorSecciones contenedor = new ContenedorSecciones();
        contenedor.agregar(seccionCuerpoACuerpo);

        Unidad unidad = new Unidad(seccionCuerpoACuerpo);
        mazo.agregarCarta(unidad);

        List<Mazo> mazos = new ArrayList<>();
        mazos.add(mazo);

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Faustino", mazos, contenedor);

        seccionCuerpoACuerpo.agregarCarta(unidad);
        tablero.agregarSeccion(contenedor);

        /* Act */
        jugador.jugarCarta();

        /* Assert */
        assertEquals(cantidadDeCartasEsperadas, tablero.cantidadDeCartasEnTotal());
    }


    @Test
    public void test04VerificarQueUnJugadorTieneUnPuntajeParcialAlJugarUnaCarta() {
        /* Arrange */
        int puntajeEsperado = 25;
        Mazo mazo = new Mazo();

        CuerpoACuerpo seccionCuerpoACuerpo = new CuerpoACuerpo();

        ContenedorSecciones contenedor = new ContenedorSecciones();
        contenedor.agregar(seccionCuerpoACuerpo);

        Unidad unidad = new Unidad(seccionCuerpoACuerpo, puntajeEsperado);
        mazo.agregarCarta(unidad);

        List<Mazo> mazos = new ArrayList<>();
        mazos.add(mazo);

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Faustino", mazos, contenedor);

        seccionCuerpoACuerpo.agregarCarta(unidad);
        tablero.agregarSeccion(contenedor);

        /* Act */
        jugador.jugarCarta();

        /* Assert */
        assertEquals(puntajeEsperado, jugador.calcularPuntaje());
    }

    @Test
    public void test05VerificarQueLasCartasPasenADescarte () {
        /* Arrange */
        CuerpoACuerpo seccionCuerpoACuerpo = new CuerpoACuerpo();
        ContenedorSecciones contenedor = new ContenedorSecciones();
        contenedor.agregar(seccionCuerpoACuerpo);
        Mazo mazo = new Mazo();
        for (int i = 0; i < CARTAS_MAZO; i++) {
            if (i < CARTAS_UNIDAD) {
                Unidad carta = new Unidad(seccionCuerpoACuerpo);
                seccionCuerpoACuerpo.agregarCarta(carta);
                mazo.agregarCarta(carta);
            } else {
                Especial carta = new Especial();
                mazo.agregarCarta(carta);
               }
        }


        List<Mazo> mazos = new ArrayList<>();
        mazos.add(mazo);

        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Faustino", mazos, contenedor);
        tablero.agregarSeccion(contenedor);

        Juego juego = new Juego(tablero);
        juego.agregarJugador(jugador);
        jugador.jugarCarta();

        /* Act */
        juego.pasarDeRonda();

        /* Assert */
        assertEquals(15, jugador.cartasEnDescarte());
    }


}
