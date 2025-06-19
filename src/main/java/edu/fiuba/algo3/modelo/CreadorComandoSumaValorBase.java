package edu.fiuba.algo3.modelo;

public class CreadorComandoSumaValorBase extends CreadorConCartas {
    @Override
    public Comando crearComando() {
        return new ComandoSumaValorBase(cartas);
    }
}
