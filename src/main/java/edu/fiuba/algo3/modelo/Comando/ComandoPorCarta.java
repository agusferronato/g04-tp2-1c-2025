package edu.fiuba.algo3.modelo.Comando;
import edu.fiuba.algo3.modelo.Carta.Puntaje;
import edu.fiuba.algo3.modelo.Carta.Unidad;

import java.util.ArrayList;
import java.util.List;

public abstract class ComandoPorCarta extends Comando {
    private List<Unidad> cartas;

    ComandoPorCarta() {
        cartas = new ArrayList<Unidad>();
    }

    public abstract void afectar(Puntaje puntaje);

    public void agregarCartas(List<Unidad> cartas) {
        this.cartas.addAll(cartas);
    }

    @Override
    public void ejecutar() {
        for (Unidad carta : cartas) {
            carta.enviarComando(this);
        }
    }
}
