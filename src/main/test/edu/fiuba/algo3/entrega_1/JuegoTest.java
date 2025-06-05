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

    private Mazo mazo;
    private Jugador jugador;
    private Mazo mazoSeleccionado;

    @BeforeEach
    public void setUp() {
        mazo = new Mazo();
        for (int i = 0; i < 21; i++) {
            Carta carta = (i < 15) ? new Unidad() : new Especial();
            mazo.agregarCarta(carta);
        }
        List<Mazo> mazos = new ArrayList<>();
        mazos.add(mazo);
        jugador = new Jugador("Matias", mazos);

        mazoSeleccionado = jugador.seleccionarMazo();
    }

    @Test
    public void test01UnJugadorPoseeCartasSuficientesParaEmpezarElJuego() {
        assertEquals(21, mazoSeleccionado.cantidadDeCartas());
    }

    @Test
    public void test02AUnJugadorLeReparten10CartasDeSuMazo(){
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
        Tablero tablero = new Tablero();
        Seccion seccion = new Seccion();
        tablero.agregarSeccion(seccion);

        int puntaje = 25;
        Carta carta = new Unidad(seccion, puntaje);

        /* Act */
        carta.usar();

    }
}
