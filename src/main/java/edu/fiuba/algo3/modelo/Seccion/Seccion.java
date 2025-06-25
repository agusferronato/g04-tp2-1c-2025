package edu.fiuba.algo3.modelo.Seccion;

import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;
import edu.fiuba.algo3.modelo.Comando.Comando;
import edu.fiuba.algo3.modelo.Comando.ComandoPorCarta;
import edu.fiuba.algo3.modelo.Comando.ComandoUnida;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;

import java.util.List;

public abstract class Seccion {

    public abstract int calcularPuntaje();

    public abstract void limpiarSeccion(List<UnidadGeneral> pilaDescarte);

    /* Metodo para test */
    public abstract int cantidadDeCartas();

    public abstract void reiniciarValoresCartas();

    public abstract int puntajeMaximoCartas();

    public abstract void quemarCartasDePuntaje (int puntaje);

    public abstract void agregarCartasA(ComandoPorCarta comando);

    public abstract void agregarComando(Comando comando);

    public abstract void actualizarValores();

    public abstract void quitarComando(Comando comando);

    public abstract void levantarCartasPara(Jugador jugador);

    public abstract void quitarComandos();
}
