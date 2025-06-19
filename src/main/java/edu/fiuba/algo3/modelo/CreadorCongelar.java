package edu.fiuba.algo3.modelo;

public class CreadorCongelar extends CreadorConCartas {
    @Override
    public Comando crearComando() {
        return new ComandoCongelar(this.cartas);
    }
}
