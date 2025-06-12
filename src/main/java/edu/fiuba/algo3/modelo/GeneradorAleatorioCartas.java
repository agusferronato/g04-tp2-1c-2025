package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneradorAleatorioCartas {
    public static List<Carta> cartasAlAzar(List<Carta> cartas, int cantidad) {
        List<Carta> copia = new ArrayList<>(cartas);
        Collections.shuffle(copia);
        return new ArrayList<>(copia.subList(0, Math.min(cantidad, copia.size())));
    }
}
