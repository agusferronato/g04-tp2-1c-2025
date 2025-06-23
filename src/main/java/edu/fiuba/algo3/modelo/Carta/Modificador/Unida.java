package edu.fiuba.algo3.modelo.Carta.Modificador;

import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Comando.ComandoUnida;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

public class Unida extends Unidad {
    private Unidad carta;
    private String tipo;
    private Ubicable seccion;

    public Unida (Unidad carta, Ubicable seccion, String tipo) {
        this.carta = carta;
        this.seccion = seccion;
        this.tipo = tipo;
    }

    public void usar (Jugador jugador) {
        ComandoUnida comando = new ComandoUnida(seccion, tipo);
        seccion.agregarComando(comando);
        jugador.jugarCarta(carta);
    }
}
