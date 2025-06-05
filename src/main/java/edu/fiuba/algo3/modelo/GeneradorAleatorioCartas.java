package edu.fiuba.algo3.modelo;

import java.util.Collections;
import java.util.List;

public class GeneradorAleatorioCartas {
    public static List<Carta> cartasAlAzar (List<Carta> cartas, int cantidad) {
        Collections.shuffle(cartas);
        return cartas.subList(0, cantidad);
    }
}
