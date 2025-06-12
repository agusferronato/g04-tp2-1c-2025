package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Entrega2Test {
    private final int CARTAS_MAZO = 21;
    private final int CARTAS_UNIDAD = 15;

    @Test
    public void test01SePuedeEliminarElEfectoDeClima () {
        /* Arrange */
        int puntajeTotalEsperado = 20;
        int puntajeCarta = 20;

        CuerpoACuerpo seccion = new CuerpoACuerpo();
        ContenedorSecciones contenedorSecciones = new ContenedorSecciones();
        contenedorSecciones.agregar(seccion);

        Unidad unidad = new Unidad(seccion, puntajeCarta);
        Clima clima = new Clima(contenedorSecciones);
        NeutralizarClima neutralizador = new NeutralizarClima(contenedorSecciones);

        Mazo mazo = new Mazo();
        mazo.agregarCarta(unidad);
        mazo.agregarCarta(clima);
        mazo.agregarCarta(neutralizador);

        Jugador jugador = new Jugador("Agustin", mazo, contenedorSecciones);
        jugador.tomarCartasDelMazo(3);

        jugador.jugarCarta(unidad);
        jugador.jugarCarta(clima);

        /* Act */
        jugador.jugarCarta(neutralizador);

        /* Assert */
        assertEquals(puntajeTotalEsperado, contenedorSecciones.calcularPuntaje());
    }

    @Test
    public void test02SiSeUsaTierraArrasadaSeQuemanLasCartasMasFuertes () {
        /* Arrange */
        int cantidadDeCartasEsperadas = 1;
        int puntajeMaximoCartas = 15;
        int puntajeMinimoCartas = 5;
        CuerpoACuerpo seccionJugador1 = new CuerpoACuerpo();
        CuerpoACuerpo seccionJugador2 = new CuerpoACuerpo();
        ContenedorSecciones contenedorJugador1 = new ContenedorSecciones();
        ContenedorSecciones contenedorJugador2 = new ContenedorSecciones();
        contenedorJugador1.agregar(seccionJugador1);
        contenedorJugador2.agregar(seccionJugador2);
        ContenedorSecciones contenedor = new ContenedorSecciones();
        contenedor.agregar(seccionJugador1);
        contenedor.agregar(seccionJugador2);

        Unidad cartaJugador1 = new Unidad(seccionJugador1, puntajeMaximoCartas);
        Unidad cartaJugador2 = new Unidad(seccionJugador2, puntajeMinimoCartas);
        TierraArrasada tierraArrasada = new TierraArrasada(contenedor);

        Mazo mazoJugador1 = new Mazo();
        mazoJugador1.agregarCarta(cartaJugador1);

        Mazo mazoJugador2 = new Mazo();
        mazoJugador2.agregarCarta(cartaJugador2);
        mazoJugador2.agregarCarta(tierraArrasada);

        Jugador jugador1 = new Jugador("Jose", mazoJugador1, contenedorJugador1);
        Jugador jugador2 = new Jugador("Jose", mazoJugador2, contenedorJugador2);

        Tablero tablero = new Tablero();
        tablero.agregarSeccion(contenedorJugador1);
        tablero.agregarSeccion(contenedorJugador2);

        jugador1.tomarCartasDelMazo(1);
        jugador2.tomarCartasDelMazo(2);

        jugador2.jugarCarta(cartaJugador2);
        jugador1.jugarCarta(cartaJugador1);

        /* Act */
        jugador2.jugarCarta(tierraArrasada);

        /* Assert */
        assertEquals(cantidadDeCartasEsperadas, tablero.cantidadDeCartasEnTotal());
    }

    @Test
    public void test03PuntajeMaximoDeUnaSeccionDevuelveCorrectamenteSuValor () {
        /* Arrange */
        int puntajeEsperado = 30;
        int puntajeMaximoCartas = 30;
        int puntajeMinimoCartas = 10;

        ContenedorSecciones contenedorSecciones = new ContenedorSecciones();
        CuerpoACuerpo cuerpoACuerpo = new CuerpoACuerpo();
        CuerpoACuerpo cuerpoACuerpo2 = new CuerpoACuerpo();
        Unidad unidad = new Unidad(cuerpoACuerpo, puntajeMaximoCartas);
        Unidad unidad2 = new Unidad(cuerpoACuerpo2, puntajeMinimoCartas);
        contenedorSecciones.agregar(cuerpoACuerpo);
        contenedorSecciones.agregar(cuerpoACuerpo2);
        cuerpoACuerpo2.ubicar(unidad);
        cuerpoACuerpo.ubicar(unidad2);

        /* Act */
        int puntajeObtenido = contenedorSecciones.puntajeMaximoCartas();

        /* Assert */
        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void test04CartaEspiaPermiteObtenerDosCartas () {
        /* Arrange */
        int cantidadDeCartasEnManoEsperada = 2;
        CuerpoACuerpo seccionJugador1 = new CuerpoACuerpo();
        CuerpoACuerpo seccionJugador2 = new CuerpoACuerpo();

        Unidad cartaBase = new Unidad(seccionJugador1);
        Espia espia = new Espia(cartaBase, seccionJugador2);

        Mazo mazo = new Mazo();
        mazo.agregarCarta(espia);

        Jugador jugador = new Jugador("Agustin", mazo);
        jugador.tomarCartasDelMazo(1);

        mazo.agregarCarta(new Unidad(seccionJugador1));
        mazo.agregarCarta(new Unidad(seccionJugador1));

        /* Act */
        jugador.jugarCarta(espia);

        /* Assert */
        assertEquals(cantidadDeCartasEnManoEsperada, jugador.cantidadDeCartasEnMano());
    }
    @Test
    public void test05CartaEspiaSeUbicaEnLaSeccionContraria () {
        /* Arrange */
        int cantidadDeCartasEsperada = 2;

        ContenedorSecciones contenedorJugador1 = new ContenedorSecciones();
        ContenedorSecciones contenedorJugador2 = new ContenedorSecciones();

        CuerpoACuerpo seccionJugador1 = new CuerpoACuerpo();
        CuerpoACuerpo seccionJugador2 = new CuerpoACuerpo();

        contenedorJugador1.agregar(seccionJugador1);
        contenedorJugador2.agregar(seccionJugador2);

        Unidad cartaBase = new Unidad(seccionJugador1);
        Espia espia = new Espia(cartaBase, seccionJugador2);

        Mazo mazoJugador1 = new Mazo();
        mazoJugador1.agregarCarta(espia);

        Unidad cartaJugador2 = new Unidad(seccionJugador2);
        Mazo mazoJugador2 = new Mazo();
        mazoJugador2.agregarCarta(cartaJugador2);

        Jugador jugador1 = new Jugador("Matias", mazoJugador1, contenedorJugador1);
        jugador1.tomarCartasDelMazo(1);
        Jugador jugador2 = new Jugador("Agustin", mazoJugador2, contenedorJugador2);
        jugador2.tomarCartasDelMazo(1);

        jugador2.jugarCarta(cartaJugador2);

        /* Act */
        jugador1.jugarCarta(espia);

        /* Assert */
        assertEquals(cantidadDeCartasEsperada, seccionJugador2.cantidadDeCartas());
    }

    @Test
    public void test06CartaAgilPuedeUbicarseEnVariasSecciones () {
        /* Arrange */
        int cantidadDeCartasEsperada = 1;
        ContenedorSecciones secciones = new ContenedorSecciones();
        CuerpoACuerpo cuerpoACuerpo1 = new CuerpoACuerpo();
        CuerpoACuerpo cuerpoACuerpo2 = new CuerpoACuerpo();
        secciones.agregar(cuerpoACuerpo1);
        secciones.agregar(cuerpoACuerpo2);

        SeccionAleatoria seleccionador = mock(SeccionAleatoria.class);
        when(seleccionador.obtenerSeccionAleatoria()).thenReturn(cuerpoACuerpo1);

        Unidad cartaBase = new Unidad();
        Agil carta = new Agil(cartaBase, seleccionador);
        Mazo mazo = new Mazo();
        mazo.agregarCarta(carta);

        Jugador jugador = new Jugador("Agustin", mazo, secciones);
        jugador.tomarCartasDelMazo(1);

        /* Act */
        jugador.jugarCarta(carta);

        /* Assert */
        assertEquals(cantidadDeCartasEsperada, cuerpoACuerpo1.cantidadDeCartas());
    }

    @Test
    public void test07SiSeJuegaUnaCartaMedicoPuedeAgarrarDeLaPilaDeDescarte(){
        int cantidadCartasEsperada = 2;

        ContenedorSecciones secciones = new ContenedorSecciones();
        CuerpoACuerpo cuerpoACuerpo = new CuerpoACuerpo();
        secciones.agregar(cuerpoACuerpo);

        Mazo mazo = new Mazo();
        Unidad cartaBase = new Unidad(cuerpoACuerpo);
        Medico cartaMedica = new Medico(cartaBase);
        Unidad carta = new Unidad(cuerpoACuerpo);

        mazo.agregarCarta(cartaMedica);
        Jugador jugador = new Jugador("Agustin", mazo, secciones);
        jugador.tomarCartasDelMazo(1);

        jugador.agregarADescarte(carta);


        /* Act */
        jugador.jugarCarta(cartaMedica);

        /* Assert */

        assertEquals(cantidadCartasEsperada, cuerpoACuerpo.cantidadDeCartas());
    }
}
