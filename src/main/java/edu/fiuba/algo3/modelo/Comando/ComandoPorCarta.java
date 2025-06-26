package edu.fiuba.algo3.modelo.Comando;
import edu.fiuba.algo3.modelo.Carta.Puntaje;
import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;

import java.util.ArrayList;
import java.util.List;

public abstract class ComandoPorCarta extends Comando {
    private List<UnidadGeneral> cartas;

    ComandoPorCarta() {
        cartas = new ArrayList<UnidadGeneral>();
    }

    public abstract void afectar(Puntaje puntaje);

    public void agregarCartas(List<UnidadGeneral> cartas) {
        this.cartas.addAll(cartas);
    }

    @Override
    public void ejecutar() {
        for (UnidadGeneral carta : cartas) {
            carta.enviarComando(this);
        }
    }
}
