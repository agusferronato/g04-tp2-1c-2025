package parser_test;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Mazo;
import edu.fiuba.algo3.modelo.Carta.Modificador.Medico;
import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;
import edu.fiuba.algo3.modelo.ConversorJSON.*;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConversorJSONTest {
    private final String JUGADOR_UNO = "mazo_jugador_uno";
    private final String JUGADOR_DOS = "mazo_jugador_dos";

    @Test
    public void test01PrimeraCartaJugadorUnoDevuelveSuNombreCorrectamente () {
        /* Arrange */
        String nombreEsperado = "Birna Bran";
        InstanciasSecciones instanciasSecciones = new InstanciasSecciones();
        ConversorJugador conversor = new ConversorPrimerJugador(instanciasSecciones);

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
        ConversorJugador conversor = new ConversorPrimerJugador(instanciasSecciones);
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
        ConversorJugador conversor = new ConversorPrimerJugador(instanciasSecciones);
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
        ConversorJugador conversor = new ConversorPrimerJugador(instanciasSecciones);
        ConversorJSON conversorJson = new ConversorJSON();
        /* Act */
        List<UnidadGeneral> cartas = conversorJson.obtenerUnidades(conversor);
        /* Assert */
        assertEquals(CuerpoACuerpo.class, cartas.get(0).getSeccion().getClass());
    }
}
