package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Seccion {
    protected List<Unidad> cartas;
    private EstrategiaCambioPuntos estrategia;

    public Seccion() {
        this.cartas = new ArrayList<>();
        this.estrategia = new Comun();
    }

    public void ubicar(Unidad carta) {
        this.cartas.add(carta);
    }

    public abstract int calcularPuntaje();

    public abstract void limpiarSeccion(List<Unidad> pilaDescarte);

    /* Metodo para test */
    public abstract int cantidadDeCartas();

    public void setStrategy(EstrategiaCambioPuntos estrategia) {
        this.estrategia = estrategia;
    }

    public void actualizarValores() {
        this.estrategia.modificarPuntosCartas(this.cartas);
    }

}
