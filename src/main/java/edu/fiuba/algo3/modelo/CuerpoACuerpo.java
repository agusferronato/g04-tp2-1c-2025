package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class CuerpoACuerpo extends Seccion {

    public CuerpoACuerpo () {
        super();
    }

    @Override
    public int cantidadDeCartas() {
        return this.cartas.size();
    }

    @Override
    public int calcularPuntaje () {
        int acumulador = 0;
        for (Unidad unidad : this.cartas) {
            acumulador = unidad.calcularPuntaje(acumulador);
        }
        return acumulador;
    }

    @Override
    public void limpiarSeccion(List<Unidad> pilaDescarte) {
        List<Unidad> cartas = List.copyOf(this.cartas);
        pilaDescarte.addAll(cartas);
        this.cartas.clear();
    }
}
