package edu.fiuba.algo3.modelo.Comando;


public abstract class Comando {
    public abstract void ejecutar();

    public boolean esIgualQue(Comando otroComando) {
        return otroComando.mismaClaseQue(this.getClass());
    }

    private boolean mismaClaseQue(Class<?> clase) {
        return this.getClass() == clase;
    }
}