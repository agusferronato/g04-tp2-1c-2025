package edu.fiuba.algo3.modelo.Carta;

import edu.fiuba.algo3.modelo.Comando.ComandoPorCarta;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.Seccion;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

public abstract class UnidadGeneral extends Carta {
    protected Ubicable seccion;
    protected Puntaje puntaje;

    public UnidadGeneral () {
        super(null);
    }

    public UnidadGeneral (String tipo, Ubicable seccion, Puntaje puntaje) {
        super(tipo);
        this.seccion = seccion;
        this.puntaje = puntaje;
    }

    public UnidadGeneral (Ubicable seccion, Puntaje puntaje) {
        super(null);
        this.seccion = seccion;
        this.puntaje = puntaje;
    }

    public UnidadGeneral (Ubicable seccion) {
        super(null);
        this.seccion = seccion;
    }

    public UnidadGeneral (String nombre) {
        super(nombre);
    }

    public UnidadGeneral (String nombre, Puntaje puntos) {
        super(nombre);
        this.puntaje = puntos;
    }

    public int calcularPuntaje(int acumulador){
        return puntaje.calcularPuntaje(acumulador);
    }

    public abstract void usar (Jugador jugador);


    public void modificarPuntaje(String tipo, int acumulador) {
        if (tengoMismoTipoQue(tipo)) {
            puntaje.modificarPuntaje(acumulador);
        }
    }

    public int devolverPuntajeSiSupera (int puntaje) {
        return this.puntaje.devolverPuntajeSiSupera(puntaje);
    }

    public boolean superaPuntaje (int puntaje) {
        return this.puntaje.superaPuntaje(puntaje);
    }

    public void ubicar () {
        this.seccion.ubicar(this);
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


    /* Metodo para test */
    public Ubicable getSeccion() {
        return seccion;
    }
}
