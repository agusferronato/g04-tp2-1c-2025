package edu.fiuba.algo3.modelo.Carta.Modificador;

import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Comando.ComandoPorCarta;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

public class Legendaria extends Unidad {
    private Unidad cartaBase;
    private Ubicable seccion;

    public Legendaria (Unidad carta, Ubicable seccion) {
        this.cartaBase = carta;
        this.seccion = seccion;
    }

    public void usar (Jugador jugador) {
        seccion.ubicar(this);
    }

    @Override
    public void enviarComando(ComandoPorCarta comando) {
        /* No es afectado por el comando */
    }

    @Override
    public int devolverPuntajeSiSupera (int puntaje) {
        return puntaje;
    }

    @Override
    public boolean superaPuntaje (int puntaje) {
        return false;
    }


    @Override
    public int calcularPuntaje(int acumulador){
        return cartaBase.calcularPuntaje(acumulador);
    }

    @Override
    public void reiniciarPuntaje(){
        cartaBase.reiniciarPuntaje();
    }
}
