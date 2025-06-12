package edu.fiuba.algo3.modelo;

public class NeutralizarClima extends Especial {
    private ContenedorSecciones secciones;

    public NeutralizarClima(ContenedorSecciones secciones) {
        this.secciones = secciones;
    }

    @Override
    public void usar() {
        secciones.reestablecerPuntajeCartas();
    }
}
