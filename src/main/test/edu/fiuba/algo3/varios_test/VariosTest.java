package edu.fiuba.algo3.varios_test;
import edu.fiuba.algo3.modelo.Carta.*;
import edu.fiuba.algo3.modelo.Carta.Especial.Clima;
import edu.fiuba.algo3.modelo.Carta.Especial.MoraleBoost;
import edu.fiuba.algo3.modelo.Carta.Especial.TierraArrasada;
import edu.fiuba.algo3.modelo.Carta.Modificador.Legendaria;
import edu.fiuba.algo3.modelo.Carta.Modificador.SumaValoresBase;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.LogicaGeneral.Tablero;
import edu.fiuba.algo3.modelo.Seccion.ContenedorSecciones;
import edu.fiuba.algo3.modelo.Seccion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.Seccion.Rango;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class VariosTest {
    @Test
    public void test01SumaValoresBaseSumaUnoALasCartasDeUnaSeccion(){
        int puntajeEsperado = 48;
        int puntajeCartas = 15;

        CuerpoACuerpo seccionJugador = new CuerpoACuerpo();
        ContenedorSecciones contenedorJugador = new ContenedorSecciones();
        contenedorJugador.agregar(seccionJugador);

        Puntaje puntaje1 = new Puntaje(puntajeCartas);
        Unidad carta1 = new Unidad(seccionJugador, puntaje1);
        Puntaje puntaje2 = new Puntaje(puntajeCartas);
        Unidad carta2 = new Unidad(seccionJugador, puntaje2);
        Puntaje puntaje3 = new Puntaje(puntajeCartas);
        Unidad carta3 = new Unidad(seccionJugador, puntaje3);

        SumaValoresBase sumaValoresBase = new SumaValoresBase(carta3, seccionJugador);

        Mazo mazoJugador = new Mazo();
        mazoJugador.agregarCarta(carta1);
        mazoJugador.agregarCarta(carta2);
        mazoJugador.agregarCarta(sumaValoresBase);

        Jugador jugador = new Jugador("Faustino", mazoJugador, contenedorJugador);

        jugador.tomarCartasDelMazo(3);

        jugador.jugarCarta(carta1);
        jugador.jugarCarta(carta2);
        jugador.jugarCarta(sumaValoresBase);

        int puntajeObtenido = jugador.calcularPuntaje();

        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void test02CartaLegendariaNoEsAfectadaPorOtrosModificadores(){
        int puntajeEsperado = 50;
        int puntajeCartas = 50;

        CuerpoACuerpo seccionJugador = new CuerpoACuerpo();
        ContenedorSecciones contenedorJugador = new ContenedorSecciones();
        contenedorJugador.agregar(seccionJugador);
        ContenedorSecciones contenedor = new ContenedorSecciones();
        contenedor.agregar(seccionJugador);

        Puntaje puntaje1 = new Puntaje(puntajeCartas);
        Unidad carta1 = new Unidad(seccionJugador, puntaje1);
        Puntaje puntaje2 = new Puntaje(puntajeCartas);
        Unidad carta2 = new Unidad(seccionJugador, puntaje2);

        Clima clima = new Clima(contenedor);

        SumaValoresBase sumaValoresBase = new SumaValoresBase(carta2, seccionJugador);
        Legendaria legendaria = new Legendaria(carta1, seccionJugador);

        Mazo mazoJugador = new Mazo();
        mazoJugador.agregarCarta(legendaria);
        mazoJugador.agregarCarta(sumaValoresBase);
        mazoJugador.agregarCarta(clima);

        Jugador jugador = new Jugador("Jose", mazoJugador, contenedorJugador);

        jugador.tomarCartasDelMazo(3);

        jugador.jugarCarta(legendaria);
        jugador.jugarCarta(sumaValoresBase);
        jugador.jugarCarta(clima);

        int puntajeObtenido = legendaria.calcularPuntaje(0);

        assertEquals(puntajeEsperado, puntajeObtenido);
    }
    @Test
    public void test03MoraleBoostDuplicaLosPuntosDeTodasLasCartasDeLaSeccion(){
        int puntajeEsperado = 100;
        int puntajeCartas = 25;

        CuerpoACuerpo seccionJugador = new CuerpoACuerpo();
        ContenedorSecciones contenedorJugador = new ContenedorSecciones();
        contenedorJugador.agregar(seccionJugador);
        ContenedorSecciones contenedor = new ContenedorSecciones();
        contenedor.agregar(seccionJugador);

        Puntaje puntaje1 = new Puntaje(puntajeCartas);
        Unidad carta1 = new Unidad(seccionJugador, puntaje1);
        Puntaje puntaje2 = new Puntaje(puntajeCartas);
        Unidad carta2 = new Unidad(seccionJugador, puntaje2);

        MoraleBoost moraleBoost = new MoraleBoost(seccionJugador);



        Mazo mazoJugador = new Mazo();
        mazoJugador.agregarCarta(carta1);
        mazoJugador.agregarCarta(carta2);
        mazoJugador.agregarCarta(moraleBoost);

        Jugador jugador = new Jugador("Jose", mazoJugador, contenedorJugador);

        jugador.tomarCartasDelMazo(3);

        jugador.jugarCarta(carta1);
        jugador.jugarCarta(carta2);
        jugador.jugarCarta(moraleBoost);

        int puntajeObtenido = seccionJugador.calcularPuntaje();

        assertEquals(puntajeEsperado, puntajeObtenido);
    }

    @Test
    public void test04CartaLegendariaNoEsQuemadaPorTierraArrasada () {
        /* Arrange */
        int cantidadEsperada = 1;

        Rango rango = new Rango();
        CuerpoACuerpo cuerpoACuerpo = new CuerpoACuerpo();

        ContenedorSecciones contenedor = new ContenedorSecciones();
        contenedor.agregar(cuerpoACuerpo);
        contenedor.agregar(rango);

        TierraArrasada tierraArrasada = new TierraArrasada(contenedor);

        Puntaje puntajeOtraCarta = new Puntaje(10);
        Unidad otraCarta = new Unidad(rango, puntajeOtraCarta);

        Puntaje puntajeCartaBase = new Puntaje(100);
        Unidad cartaBase = new Unidad(cuerpoACuerpo, puntajeCartaBase);
        Legendaria legendaria = new Legendaria(cartaBase, cuerpoACuerpo);

        Mazo mazo = new Mazo();
        mazo.agregarCarta(legendaria);
        mazo.agregarCarta(otraCarta);
        mazo.agregarCarta(tierraArrasada);

        Jugador jugador = new Jugador("Matias", mazo, contenedor);
        Tablero tablero = new Tablero();
        tablero.agregarSeccion(contenedor);


        jugador.tomarCartasDelMazo(3);

        jugador.jugarCarta(otraCarta);
        jugador.jugarCarta(legendaria);

        /* Act */
        jugador.jugarCarta(tierraArrasada);

        /* Assert */
        assertEquals(cantidadEsperada, tablero.cantidadDeCartasEnTotal());
    }

    @Test
    public void test05JugadorJuegaUnaCartaYNoPuedeVolverAUsarla () {
        Rango rango = new Rango();

        Unidad carta = new Unidad(rango);
        Mazo mazo = new Mazo();
        mazo.agregarCarta(carta);

        Jugador jugador = new Jugador("Agustin", mazo);

        jugador.tomarCartasDelMazo(1);

        jugador.jugarCarta(carta);

        assertThrows(CartaYaJugadaError.class, () -> {
            jugador.jugarCarta(carta);
        });
    }


}
