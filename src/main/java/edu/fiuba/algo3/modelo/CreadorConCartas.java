package edu.fiuba.algo3.modelo;

import java.util.List;

public abstract class CreadorConCartas extends CreadorComando {
    protected List<Unidad> cartas;
    public void agregarCartas (List<Unidad> cartas) {
        this.cartas = cartas;
    }
    public abstract Comando crearComando();
}
