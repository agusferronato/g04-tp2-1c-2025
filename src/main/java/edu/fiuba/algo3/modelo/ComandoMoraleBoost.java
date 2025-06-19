package edu.fiuba.algo3.modelo;

import java.util.List;

public class ComandoMoraleBoost implements Comando {
    private List<Unidad> cartas;

    public ComandoMoraleBoost(List<Unidad> cartas) {
        this.cartas = cartas;
    }

    @Override
    public void ejecutar() {
        for (Unidad carta : cartas) {
            carta.duplicarPuntaje();
        }
    }
}
