package edu.fiuba.algo3.modelo.Carta;

import edu.fiuba.algo3.modelo.Comando.Comando;
import edu.fiuba.algo3.modelo.Comando.ComandoCongelar;
import edu.fiuba.algo3.modelo.Comando.ComandoPorCarta;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

public class Unidad extends UnidadGeneral {

    public Unidad () {}

    public Unidad (String tipo, Ubicable seccion, Puntaje puntaje) {
        super(tipo, seccion, puntaje);;
    }

    public Unidad(Ubicable seccion, Puntaje puntaje) {
        super(seccion, puntaje);
    }

    public Unidad(Ubicable seccion) {
        super(seccion);
    }

    public Unidad(String nombre) {
        super(nombre);
    }

    public Unidad(String nombre, Puntaje puntos) {
        super(nombre, puntos);
    }

    public int calcularPuntaje(int acumulador){
        return puntaje.calcularPuntaje(acumulador);
    }

    @Override
    public void usar (Jugador jugador) {
        this.seccion.ubicar(this);
        this.seccion.actualizarValores();
    }
}
