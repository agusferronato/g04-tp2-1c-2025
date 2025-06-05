package edu.fiuba.algo3.modelo;

import java.util.List;

public class Seccion {
    List<Carta> cartas;
    public int sumarPuntos(){
        int puntos = 0;
        for (Carta carta : this.cartas) {
            puntos = carta.calcularPuntaje(puntos);
        }
        return puntos;
    }
    public Seccion() {

    }

    public void colocarCarta(Carta nuevaCarta){
        cartas.add(nuevaCarta);
    }
}
