package edu.fiuba.algo3.modelo.Seccion;

import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;
import edu.fiuba.algo3.modelo.Comando.Comando;
import edu.fiuba.algo3.modelo.Comando.ComandoPorCarta;
import edu.fiuba.algo3.modelo.Comando.HistorialComandos;

import java.util.ArrayList;
import java.util.List;

public abstract class Ubicable extends Seccion {
    private HistorialComandos historialComandos;
    private List<UnidadGeneral> cartas;

    public Ubicable () {
        historialComandos = new HistorialComandos();
        this.cartas = new ArrayList<>();
    }

    private boolean mismaClaseQue (Class<?> clase) {
        return this.getClass() == clase;
    }

    public boolean esIgualQue(Ubicable ubicable) {
        return ubicable.mismaClaseQue(this.getClass());
    }

    @Override
    public int cantidadDeCartas() {
        return this.cartas.size();
    }

    public void ubicar (UnidadGeneral unidad) {
        cartas.add(unidad);
    }


    public void agregarCartasA(ComandoPorCarta comando) {
        comando.agregarCartas(cartas);
    }

    public void agregarComando(Comando comando) {
        historialComandos.agregarComando(comando);
    }

    public void actualizarValores() {
        this.historialComandos.ejecutar();
    }

    public void quitarComando (Comando comando) {
        this.historialComandos.quitarComando(comando);
    }


    private int cantidadDeCartasDeTipo (String tipo) {
        int acumulador = 0;
        for (UnidadGeneral carta : cartas)
            acumulador += carta.esDeTipo(tipo);
        return acumulador;
    }

    public void reiniciarValoresCartas() {
        for (UnidadGeneral carta : cartas) {
            carta.reiniciarPuntaje();
        }
    }

    public void duplicarCartasDeTipo(String tipo) {
        int cantidadDeCartas = cantidadDeCartasDeTipo(tipo);
        for (UnidadGeneral carta : cartas)
            carta.modificarPuntaje(tipo, cantidadDeCartas);
    }


    @Override
    public int puntajeMaximoCartas() {
        int puntajeMaximo = -1;
        for (UnidadGeneral unidad : this.cartas) {
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
        for (UnidadGeneral unidad : this.cartas) {
            acumulador = unidad.calcularPuntaje(acumulador);
        }
        return acumulador;
    }

    @Override
    public void limpiarSeccion(List<UnidadGeneral> pilaDescarte) {
        List<UnidadGeneral> cartas = List.copyOf(this.cartas);
        pilaDescarte.addAll(cartas);
        this.cartas.clear();
    }

}
