package edu.fiuba.algo3.parser_test;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Especial.Clima;
import edu.fiuba.algo3.modelo.Carta.Especial.Especial;
import edu.fiuba.algo3.modelo.Carta.Especial.MoraleBoost;
import edu.fiuba.algo3.modelo.Carta.Mazo;
import edu.fiuba.algo3.modelo.Carta.Modificador.Medico;
import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;
import edu.fiuba.algo3.modelo.ConversorJSON.*;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

import static edu.fiuba.algo3.modelo.ConversorJSON.Constantes.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversorJSONTest {

    @Test
    public void test01PrimeraCartaJugadorUnoDevuelveSuNombreCorrectamente () {
        /* Arrange */
        String nombreEsperado = "Birna Bran";
        InstanciasSecciones instanciasSecciones = new InstanciasSecciones();
        ConversorJugador conversor = new ConversorJugador(
                JUGADOR_UNO,
                NUMERO_JUGADOR_UNO,
                NUMERO_JUGADOR_DOS,
                instanciasSecciones
        );

        ConversorJSON conversorJson = new ConversorJSON();
        /* Act */
        List<UnidadGeneral> cartas = conversorJson.obtenerUnidades(conversor);
        /* Assert */
        assertEquals(nombreEsperado, cartas.get(0).getNombre());
    }

    @Test
    public void test02PrimeraCartaJugadorUnoDevuelveSuPuntajeCorrectamente () {
        /* Arrange */
        int puntajeEsperado = 2;
        InstanciasSecciones instanciasSecciones = new InstanciasSecciones();
        ConversorJugador conversor = new ConversorJugador(
                JUGADOR_UNO,
                NUMERO_JUGADOR_UNO,
                NUMERO_JUGADOR_DOS,
                instanciasSecciones
        );;
        ConversorJSON conversorJson = new ConversorJSON();

        /* Act */
        List<UnidadGeneral> cartas = conversorJson.obtenerUnidades(conversor);

        /* Assert */
        assertEquals(puntajeEsperado, cartas.get(0).calcularPuntaje(0));
    }

    @Test
    public void test03PrimeraCartaJugadorUnoDevuelveSuTipoCorrectamente () {
        /* Arrange */
        InstanciasSecciones instanciasSecciones = new InstanciasSecciones();
        ConversorJugador conversor = new ConversorJugador(
                JUGADOR_UNO,
                NUMERO_JUGADOR_UNO,
                NUMERO_JUGADOR_DOS,
                instanciasSecciones
        );
        ConversorJSON conversorJson = new ConversorJSON();
        /* Act */
        List<UnidadGeneral> cartas = conversorJson.obtenerUnidades(conversor);
        /* Assert */
        assertEquals(Medico.class, cartas.get(0).getClass());
    }

    @Test
    public void test04PrimeraCartaJugadorUnoDevuelveSuSeccionCorrectamente () {
        /* Arrange */
        InstanciasSecciones instanciasSecciones = new InstanciasSecciones();
        ConversorJugador conversor = new ConversorJugador(
                JUGADOR_UNO,
                NUMERO_JUGADOR_UNO,
                NUMERO_JUGADOR_DOS,
                instanciasSecciones
        );;
        ConversorJSON conversorJson = new ConversorJSON();
        /* Act */
        List<UnidadGeneral> cartas = conversorJson.obtenerUnidades(conversor);
        /* Assert */
        assertEquals(
                instanciasSecciones.obtenerUbicableDe(1, new CuerpoACuerpo()),
                cartas.get(0).getSeccion()
        );
    }


    @Test
    public void test05PrimeraCartaEspecialDevuelveNombreCorrectamente () {
        /* Arrange */

        String nombreEsperado = "Cuerno del comandante";
        ConversorJugador conversor = new ConversorJugador(
                JUGADOR_UNO,
                NUMERO_JUGADOR_UNO,
                NUMERO_JUGADOR_DOS,
                new InstanciasSecciones()
        );
        ConversorJSON conversorJson = new ConversorJSON();

        /* Act */
        List<Especial> cartas = conversorJson.obtenerEspeciales(conversor);

        /* Assert */
        assertEquals(nombreEsperado, cartas.get(0).getNombre());
    }


    @Test
    public void test06PrimeraCartaEspecialDevuelveDescripcionCorrectamente () {
        /* Arrange */
        String descripcionEsperada = "Duplica la fuerza de todas las cartas de una sección específica.";
        ConversorJugador conversor = new ConversorJugador(
                JUGADOR_UNO,
                NUMERO_JUGADOR_UNO,
                NUMERO_JUGADOR_DOS,
                new InstanciasSecciones()
        );
        ConversorJSON conversorJson = new ConversorJSON();

        /* Act */
        List<Especial> cartas = conversorJson.obtenerEspeciales(conversor);

        /* Assert */
        assertEquals(descripcionEsperada, cartas.get(0).getDescripcion());
    }

    @Test
    public void test07PrimeraCartaEspecialDevuelveSuTipoCorrectamente () {
        /* Arrange */
        ConversorJugador conversor = new ConversorJugador(
                JUGADOR_UNO,
                NUMERO_JUGADOR_UNO,
                NUMERO_JUGADOR_DOS,
                new InstanciasSecciones()
        );
        ConversorJSON conversorJson = new ConversorJSON();

        /* Act */
        List<Especial> cartas = conversorJson.obtenerEspeciales(conversor);

        /* Assert */
        assertEquals(MoraleBoost.class, cartas.get(0).getClass());
    }

    @Test
    public void test08JugadorDosRecibe21Cartas () {
        /* Arrange */
        int cantidadEsperada = 21;
        ConversorJugador conversor = new ConversorJugador(
                JUGADOR_DOS,
                NUMERO_JUGADOR_DOS,
                NUMERO_JUGADOR_UNO,
                new InstanciasSecciones()
        );
        ConversorJSON conversorJson = new ConversorJSON();

        /* Act */
        List <Carta> cartas = conversorJson.obtenerCartasJugador(conversor);

        /* Assert */
        assertEquals(cantidadEsperada, cartas.size());
    }
}
