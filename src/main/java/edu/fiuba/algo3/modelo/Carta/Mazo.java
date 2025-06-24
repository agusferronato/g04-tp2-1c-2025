package edu.fiuba.algo3.modelo.Carta;

import java.util.ArrayList;
import java.util.List;

public class Mazo {
    private List<Carta> cartas;

    public Mazo () {
        this.cartas = new ArrayList<Carta>();
    }

    public void agregarCartas (List<? extends Carta> cartas) {
        this.cartas.addAll(cartas);
    }

    public void agregarCarta (Carta carta) {
        this.cartas.add(carta);
    }

    public List<Carta> seleccionarCartasAlAzar (int cantidadDeCartas) {
        List<Carta> cartas = GeneradorAleatorioCartas.cartasAlAzar(this.cartas, cantidadDeCartas);
        return cartas;
    }

    public void quitarCartas(List<Carta> mano) {
        this.cartas.removeAll(mano);
    }

    /* Metodo para test */
    public Carta getCarta (int indice) {
        return this.cartas.get(indice);
    }

    /* Metodo para test */
    public int cantidadDeCartas() {
        return this.cartas.size();
    }
}
