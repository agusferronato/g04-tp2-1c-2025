package edu.fiuba.algo3.modelo.Carta;

import edu.fiuba.algo3.modelo.Comando.Comando;
import edu.fiuba.algo3.modelo.Comando.ComandoCongelar;
import edu.fiuba.algo3.modelo.Comando.ComandoPorCarta;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

public class Unidad implements Carta {
    protected String tipo;
    protected Ubicable seccion;
    private Puntaje puntaje;

    public Unidad () {}

    public Unidad (String tipo, Ubicable seccion, Puntaje puntaje) {
        this.seccion = seccion;
        this.tipo = tipo;
        this.puntaje = puntaje;
    }

    public Unidad(Ubicable seccion, Puntaje puntaje) {
        this.seccion = seccion;
        this.puntaje = puntaje;
    }

    public Unidad(Ubicable seccion) {
        this.seccion = seccion;
    }

    public int calcularPuntaje(int acumulador){
        return puntaje.calcularPuntaje(acumulador);
    }

    public void usar (Jugador jugador) {
        this.seccion.ubicar(this);
        this.seccion.actualizarValores();
    }

    public int esDeTipo (String tipo) {
        return tipo.equals(this.tipo) ? 1 : 0;
    }


    public void modificarPuntaje(String tipo, int acumulador) {
        if (this.tipo.equals(tipo)) {
            puntaje.modificarPuntaje(acumulador);
        }
    }

    public int devolverPuntajeSiSupera (int puntaje) {
        return this.puntaje.devolverPuntajeSiSupera(puntaje);
    }

    public boolean superaPuntaje (int puntaje) {
        return this.puntaje.superaPuntaje(puntaje);
    }

    public void ubicarEn(Ubicable seccion) {
        seccion.ubicar(this);
    }


    public void enviarComando(ComandoPorCarta comando) {
        comando.afectar(this.puntaje);
    }

    public void reiniciarPuntaje() {
        puntaje.reiniciarPuntaje();
    }
}
