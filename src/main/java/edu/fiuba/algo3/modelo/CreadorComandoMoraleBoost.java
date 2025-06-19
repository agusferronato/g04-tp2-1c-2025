package edu.fiuba.algo3.modelo;

public class CreadorComandoMoraleBoost extends CreadorConCartas {
    @Override
    public Comando crearComando() {
        return new ComandoMoraleBoost(cartas);
    }
}
