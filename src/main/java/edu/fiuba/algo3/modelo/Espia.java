package edu.fiuba.algo3.modelo;

public class Espia extends Unidad {
    private final int cartasDelMazoATomar = 2;
    private Unidad cartaBase;
    private CuerpoACuerpo seccion;
    public Espia(Unidad cartaBase, CuerpoACuerpo seccion) {
        this.cartaBase = cartaBase;
        this.seccion = seccion;
    }

    public void usar (Jugador jugador) {
        cartaBase.ubicarEn(seccion);
        jugador.descartar(this);
        jugador.tomarCartasDelMazo(cartasDelMazoATomar);
    }
}
