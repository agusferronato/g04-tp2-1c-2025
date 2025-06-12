package edu.fiuba.algo3.modelo;

import java.util.List;

public class Duplicador implements EstrategiaCambioPuntos {
    private String tipo;
    public Duplicador (String tipo) {
        this.tipo = tipo;
    }
    public void modificarPuntosCartas(List<Unidad> cartas) {
        int acumulador = 0;
        for (Unidad carta : cartas)
            acumulador += carta.esDeTipo(tipo);
        for (Unidad carta : cartas)
            carta.modificarPuntaje(tipo, acumulador);
    }
}
