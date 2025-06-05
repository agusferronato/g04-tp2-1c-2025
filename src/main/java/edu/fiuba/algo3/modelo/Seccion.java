package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Seccion {
    private List<Carta> cartas;


    public Seccion () {
        this.cartas = new ArrayList<Carta>();
    }

    public void ubicar(Unidad unidad) {
        this.cartas.add(unidad);
    }

    /* Metodo para test */
    public int cantidadDeCartas() {
        return this.cartas.size();
    }

}
