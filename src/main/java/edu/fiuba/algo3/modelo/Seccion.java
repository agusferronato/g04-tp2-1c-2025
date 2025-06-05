package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Seccion {
    private List<Unidad> cartas;


    public Seccion () {
        this.cartas = new ArrayList<Unidad>();
    }

    public void ubicar(Unidad unidad) {
        this.cartas.add(unidad);
    }

    public int calcularPuntaje(){
        int acumulador = 0;
        for (Unidad carta : this.cartas) {
            acumulador = carta.calcularPuntaje(acumulador);
        }
        return acumulador;
    }


    /* Metodo para test */
    public int cantidadDeCartas() {
        return this.cartas.size();
    }

}
