package edu.fiuba.algo3.modelo;

public class Agil extends Unidad {
    private Unidad cartaBase;
    private SeccionAleatoria seccionAleatoria;
    public Agil (Unidad cartaBase, SeccionAleatoria seccionAleatoria) {
        this.cartaBase = cartaBase;
        this.seccionAleatoria = seccionAleatoria;
    }
    public void usar (Jugador jugador) {
        CuerpoACuerpo seccion = seccionAleatoria.obtenerSeccionAleatoria();
        cartaBase.ubicarEn(seccion);
    }
}
