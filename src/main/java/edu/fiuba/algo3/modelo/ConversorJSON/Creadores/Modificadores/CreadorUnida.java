package edu.fiuba.algo3.modelo.ConversorJSON.Creadores.Modificadores;

import edu.fiuba.algo3.modelo.Carta.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Carta.Modificador.Unida;
import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.ConversorJSON.ConversorJSON;
import edu.fiuba.algo3.modelo.ConversorJSON.ConversorJugador;
import edu.fiuba.algo3.modelo.ConversorJSON.ParserSeccion;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

public class CreadorUnida implements CreadorModificador {

    private Unidad cartaBase;
    private String nombreSeccion, tipo;
    private ConversorJugador conversor;

    public CreadorUnida (Unidad cartaBase, String nombreSeccion, ConversorJugador conversor, String tipo) {
        this.nombreSeccion = nombreSeccion;
        this.conversor = conversor;
        this.tipo = tipo;
        this.cartaBase = cartaBase;
    }

    @Override
    public Modificador crearModificador() {
        Ubicable seccionParseada = ParserSeccion.obtenerSeccion(nombreSeccion);
        Ubicable seccion = conversor.obtenerSeccion(seccionParseada);
        return new Unida(cartaBase, seccion, tipo);
    }
}
