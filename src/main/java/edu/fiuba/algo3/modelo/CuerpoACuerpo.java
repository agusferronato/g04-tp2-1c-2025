package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class CuerpoACuerpo extends Seccion {
    List<Unidad> unidades;

    public CuerpoACuerpo () {
        unidades = new ArrayList<Unidad>();
    }

    public void agregarCarta(Unidad unidad) {
        this.unidades.add(unidad);
    }

    @Override
    public int cantidadDeCartas() {
        return unidades.size();
    }

    @Override
    public int calcularPuntaje () {
        int acumulador = 0;
        for (Unidad unidad : this.unidades) {
            acumulador = unidad.calcularPuntaje(acumulador);
        }
        return acumulador;
    }
}
