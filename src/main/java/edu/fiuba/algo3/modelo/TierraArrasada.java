package edu.fiuba.algo3.modelo;

public class TierraArrasada extends Especial {
    private ContenedorSecciones secciones;

    public TierraArrasada(ContenedorSecciones secciones) {
        this.secciones = secciones;
    }

    public void usar (Jugador jugador) {
        secciones.quemarCartasMasFuertes();
    }

}
