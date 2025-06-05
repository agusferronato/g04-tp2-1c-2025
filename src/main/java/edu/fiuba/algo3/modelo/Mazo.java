package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Mazo {
    private List<Carta> cartas;

    public Mazo(int cant_cartas){
        this.cartas = new ArrayList<>();
        for(int i = 0; i < cant_cartas; i++){
            this.cartas.add(new Carta());
        }
    }
    public int cantidad_cartas() {
        return cartas.size();
    }

    public List<Carta> seleccionarCartasAlAzar(int cantidad){

    }
}
