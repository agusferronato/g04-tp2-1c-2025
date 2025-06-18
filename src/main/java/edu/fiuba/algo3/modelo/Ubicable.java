package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Ubicable extends Seccion {
    private EstrategiaCambioPuntos estrategia;
    private List<Unidad> cartas;

    public Ubicable () {
        estrategia = new Comun();
        this.cartas = new ArrayList<>();
    }

    @Override
    public int cantidadDeCartas() {
        return this.cartas.size();
    }

    public void ubicar (Unidad unidad) {
        cartas.add(unidad);
    }

    @Override
    public void reestablecerPuntajeCartas() {
        for (Unidad unidad : this.cartas) {
            unidad.reestablecerValor();
        }
    }

    public void setStrategy(EstrategiaCambioPuntos estrategia) {
        this.estrategia = estrategia;
    }


    public void actualizarValores(){
        this.estrategia.modificarPuntosCartas(cartas);
    }


    @Override
    public int puntajeMaximoCartas() {
        int puntajeMaximo = -1;
        for (Unidad unidad : this.cartas) {
            puntajeMaximo = unidad.devolverPuntajeSiSupera(puntajeMaximo);
        }
        return puntajeMaximo;
    }

    @Override
    public void quemarCartasDePuntaje(int puntaje) {
        this.cartas.removeIf(unidad -> unidad.superaPuntaje(puntaje));
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

    @Override
    public void aplicarModificadorPuntos(ModificadorPuntos modificadorPuntos) {
        for (Unidad unidad : this.cartas) {
            unidad.aplicarModificadorPuntos(modificadorPuntos);
        }
    }

    public void sumarUnoATodasLasCartas() {
        for (Unidad unidad : this.cartas) {
            unidad.aumentarUnoEnElPuntaje();
        }
    }
}
