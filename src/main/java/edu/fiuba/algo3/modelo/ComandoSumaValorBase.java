package edu.fiuba.algo3.modelo;

import java.util.List;

public class ComandoSumaValorBase implements Comando {
    private List<Unidad> cartas;

    public ComandoSumaValorBase (List<Unidad> cartas) {
        this.cartas = cartas;
    }

    @Override
    public void ejecutar() {
        for (Unidad carta : cartas) {
            carta.aumentarPuntaje();
        }
    }
}
