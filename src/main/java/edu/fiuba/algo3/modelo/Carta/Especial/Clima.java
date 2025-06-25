package edu.fiuba.algo3.modelo.Carta.Especial;

import edu.fiuba.algo3.modelo.Comando.ComandoCongelar;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.Seccion;

public class Clima extends Especial {
    private Seccion seccion;

    public Clima (String nombre, String descripcion) {
        super(nombre, descripcion);
    }

    public Clima(String nombre, String descripcion, Seccion seccion) {
        super(nombre, descripcion);
        this.seccion = seccion;
    }

    public Clima(Seccion seccion) {
        super(null);
        this.seccion = seccion;
    }

    public void usar (Jugador jugador) {
        ComandoCongelar comando = new ComandoCongelar();
        this.seccion.agregarCartasA(comando);
        this.seccion.agregarComando(comando);
        this.seccion.actualizarValores();
    }

}
