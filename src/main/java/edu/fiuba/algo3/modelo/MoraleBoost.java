package edu.fiuba.algo3.modelo;

public class MoraleBoost extends ModificadorPuntos{

    public MoraleBoost(Seccion seccion) {
        super(seccion);
    }
    @Override
    public int aplicar(int puntaje){
        return puntaje * 2;
    }
}
