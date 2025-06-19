package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Ubicable extends Seccion {
    private HistorialComandos historialComandos;
    private List<Unidad> cartas;

    public Ubicable () {
        historialComandos = new HistorialComandos();
        this.cartas = new ArrayList<>();
    }

    @Override
    public int cantidadDeCartas() {
        return this.cartas.size();
    }

    public void ubicar (Unidad unidad) {
        cartas.add(unidad);
    }


    public void agregarCartasA(CreadorConCartas creador) {
        creador.agregarCartas(cartas);
    }

    public void agregarComando(CreadorComando creador) {
        Comando comando = creador.crearComando();
        historialComandos.agregarComando(comando);
    }

    public void actualizarValores() {
        this.historialComandos.ejecutar();
    }

    public void quitarComandoClima() {
        this.historialComandos.quitarComandoClima();
    }


    private int cantidadDeCartasDeTipo (String tipo) {
        int acumulador = 0;
        for (Unidad carta : cartas)
            acumulador += carta.esDeTipo(tipo);
        return acumulador;
    }


    public void duplicarCartasDeTipo(String tipo) {
        int cantidadDeCartas = cantidadDeCartasDeTipo(tipo);
        for (Unidad carta : cartas)
            carta.modificarPuntaje(tipo, cantidadDeCartas);
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

}
