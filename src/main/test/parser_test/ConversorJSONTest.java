package parser_test;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Modificador.Medico;
import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.ConversorJSON.ConversorJSON;
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
        ConversorJSON conversor = new ConversorJSON();
        /* Act */
        List<Unidad> cartas = conversor.obtenerCartasDe(JUGADOR_UNO);
        /* Assert */
        assertEquals(nombreEsperado, cartas.get(0).getNombre());
    }

    @Test
    public void test02PrimeraCartaJugadorUnoDevuelveSuPuntajeCorrectamente () {
        /* Arrange */
        int puntajeEsperado = 2;
        ConversorJSON conversor = new ConversorJSON();

        /* Act */
        List<Unidad> cartas = conversor.obtenerCartasDe(JUGADOR_UNO);

        /* Assert */
        assertEquals(puntajeEsperado, cartas.get(0).calcularPuntaje(0));
    }

    @Test
    public void test03PrimeraCartaJugadorUnoDevuelveSuTipoCorrectamente () {
        /* Arrange */
        ConversorJSON conversor = new ConversorJSON();
        /* Act */
        List<Unidad> cartas = conversor.obtenerCartasDe(JUGADOR_UNO);
        /* Assert */
        assertEquals(Medico.class, cartas.get(0).getClass());
    }

    @Test
    public void test04PrimeraCartaJugadorUnoDevuelveSuSeccionCorrectamente () {
        /* Arrange */
        ConversorJSON conversor = new ConversorJSON();
        /* Act */
        List<Unidad> cartas = conversor.obtenerCartasDe(JUGADOR_UNO);
        /* Assert */
        assertEquals(Medico.class, cartas.get(0).getClass());
    }
}
