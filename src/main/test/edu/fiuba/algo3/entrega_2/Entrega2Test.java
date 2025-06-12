package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega2Test {
    @Test
    public void test01sePuedeEliminarElEfectoDeClima () {
        int puntajeEsperado = 10;
        int puntajeCarta = 5;
        CuerpoACuerpo cuerpoACuerpoJ1 = new CuerpoACuerpo();
        CuerpoACuerpo cuerpoACuerpoJ2 = new CuerpoACuerpo();

        Unidad cartaJ1 = new Unidad(cuerpoACuerpoJ1, puntajeCarta);
        Unidad cartaJ2 = new Unidad(cuerpoACuerpoJ2, puntajeCarta);

        ContenedorSecciones contenedorSecciones = new ContenedorSecciones();
        contenedorSecciones.agregar(cuerpoACuerpoJ1);
        contenedorSecciones.agregar(cuerpoACuerpoJ2);
        Clima clima = new Clima(contenedorSecciones);
        NeutralizarClima carta = new NeutralizarClima(contenedorSecciones);

        cartaJ1.usar();
        cartaJ2.usar();
        clima.usar();

        /* Act */
        carta.usar();

        /* Assert */
        assertEquals(puntajeEsperado, contenedorSecciones.calcularPuntaje());
    }
    @Test
    public void test02SiSeUsaTierraArrasadaSeQuemanLasCartasMasFuertes () {
        /* Arrange */
        int puntajeMaximo = 30;
        int puntajeMinimo = 5;
        int cantidadDeCartasEsperada = 1;
        CuerpoACuerpo cuerpoACuerpoJ1 = new CuerpoACuerpo();
        CuerpoACuerpo cuerpoACuerpoJ2 = new CuerpoACuerpo();

        Unidad primeraCartaJ1 = new Unidad(cuerpoACuerpoJ1, puntajeMaximo);
        Unidad segundaCartaJ1 = new Unidad(cuerpoACuerpoJ1, puntajeMinimo);
        Unidad cartaJ2 = new Unidad(cuerpoACuerpoJ2, puntajeMaximo);

        ContenedorSecciones secciones = new ContenedorSecciones();
        secciones.agregar(cuerpoACuerpoJ1);
        secciones.agregar(cuerpoACuerpoJ2);

        ContenedorSecciones seccionesJugador1 = new ContenedorSecciones();
        seccionesJugador1.agregar(cuerpoACuerpoJ1);
        ContenedorSecciones seccionesJugador2 = new ContenedorSecciones();
        seccionesJugador2.agregar(cuerpoACuerpoJ2);

        Tablero tablero = new Tablero();
        tablero.agregarSeccion(seccionesJugador1);
        tablero.agregarSeccion(seccionesJugador2);

        TierraArrasada carta = new TierraArrasada(secciones);

        primeraCartaJ1.usar();
        segundaCartaJ1.usar();
        cartaJ2.usar();

        /* Act */
        carta.usar();

        /* Assert */
        assertEquals(cantidadDeCartasEsperada, tablero.cantidadDeCartasEnTotal());
    }
}
