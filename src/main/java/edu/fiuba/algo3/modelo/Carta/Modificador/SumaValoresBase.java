package edu.fiuba.algo3.modelo.Carta.Modificador;

import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Comando.ComandoSumaValorBase;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

public class SumaValoresBase extends Unidad {
    private Unidad cartaBase;
    private Ubicable seccion;
    public SumaValoresBase(Unidad unidad, Ubicable seccion){
        cartaBase = unidad;
        this.seccion = seccion;
    }

    public void usar(Jugador jugador){
        ComandoSumaValorBase comando  = new ComandoSumaValorBase();
        cartaBase.ubicar();
        seccion.actualizarValores();
        seccion.agregarCartasA(comando);
        seccion.agregarComando(comando);
        seccion.actualizarValores();
    }
}
