package edu.fiuba.algo3.modelo.Carta.Especial;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;

public abstract class Especial extends Carta {
    private String descripcion;

    public Especial(String nombre, String descripcion) {
        super(nombre);
        this.descripcion = descripcion;
    }

    public Especial(String nombre) {
        super(nombre);
    }
    public abstract void usar(Jugador jugador);

    /* Metodo para test */
    public String getDescripcion() {
        return descripcion;
    }

    public abstract String getTipo();

    public String getFormato() {
        return getTipo() + "\nTipo: " + getNombre() + "\nDescripcion: " + descripcion;
    }

    public String getFormatoCarta() {return getTipo() + "\nTipo: " + getNombre();}
}
