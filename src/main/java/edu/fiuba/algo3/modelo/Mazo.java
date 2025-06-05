package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

import static edu.fiuba.algo3.modelo.GeneradorAleatorioCartas.*;

public class Mazo {
    private List<Carta> cartas;

    public Mazo() {
        this.cartas = new ArrayList<Carta>();
    }

    public void agregarCarta (Carta carta) {
        this.cartas.add(carta);
    }

    public List<Carta> seleccionarCartasAlAzar(int cantidadDeCartas) {
        List<Carta> cartas = GeneradorAleatorioCartas.cartasAlAzar(this.cartas, cantidadDeCartas);
        // descontas
        return cartas;
    }

    /* Metodo para test */
    public int cantidadDeCartas() {
        return this.cartas.size();
    }
}
