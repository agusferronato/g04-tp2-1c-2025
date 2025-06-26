package edu.fiuba.algo3.modelo.Carta;

import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;

public abstract class Carta {
    private String tipo;

    public Carta(String tipo) {
        this.tipo = tipo;
    }

    public boolean tengoMismoTipoQue(String tipo) {
        return tipo.equals(this.tipo);
    }

    public abstract void usar(Jugador jugador);

    public int esDeTipo (String tipo) {
        return tipo.equals(this.tipo) ? 1 : 0;
    }

    /* Metodo para test */
    public String getNombre() {
        return tipo;
    }

    public abstract String getFormato();
}
