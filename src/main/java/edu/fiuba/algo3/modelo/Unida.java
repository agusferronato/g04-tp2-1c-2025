package edu.fiuba.algo3.modelo;

public class Unida extends Unidad {
    private Unidad carta;
    private String tipo;
    private CuerpoACuerpo seccion;

    public Unida (Unidad carta, CuerpoACuerpo seccion, String tipo) {
        this.carta = carta;
        this.seccion = seccion;
        this.tipo = tipo;
    }

    public void usar (Jugador jugador) {
        CreadorComandoUnida creador = new CreadorComandoUnida(seccion, tipo);
        seccion.agregarComando(creador);
        jugador.jugarCarta(carta);
        seccion.actualizarValores();
    }
}
