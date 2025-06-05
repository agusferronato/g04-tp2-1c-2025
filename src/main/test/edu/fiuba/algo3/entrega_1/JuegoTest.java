package edu.fiuba.algo3.entrega_1;

import java.util.List;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Mazo;
import edu.fiuba.algo3.modelo.Mano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JuegoTest {

    @Test
    public void test01UnJugadorPoseeCartasSuficientesParaEmpezarElJuego() {
        Mazo mazoInicial = new Mazo(25);
        Jugador jugador = new Jugador("Matias", mazoInicial);
        int cantidad_cartas = jugador.cantidad_cartas_mazo();

        assertEquals(25,cantidad_cartas);
    } // si le dan 10 cartas y puede cambiar 2 quedaria 12 cartas minimas para tener a disposicion

    @Test
    public void test02AUnJugadorLeReparten10CartasDeSuMazo(){
        Mazo mazoInicial = new Mazo(25);
        Jugador jugador = new Jugador("Matias", mazoInicial);
        List<Carta> cartas_seleccionadas = mazoInicial.seleccionarCartasAlAzar(10);
        Mano mano = new Mano(cartas_seleccionadas);
    }

    /*@Test
    public void messageGreetingDefaultLanguage() {
        Message message = new Message("Hola Mundo!", "Hello world!");

        assertEquals("Hola Mundo!", message.greet());
    }

    @Test
    public void messageGreetingDefaultLanguage2() {
        Message message = new Message("Hola Mundo!", "Hello world!");

        assertEquals("Hola Mundo!", message.greet());
    }*/
}
