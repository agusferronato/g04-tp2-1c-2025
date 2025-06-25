package edu.fiuba.algo3.modelo.ConversorJSON.Creadores.Modificadores;

import edu.fiuba.algo3.modelo.Carta.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Carta.Modificador.SumaValoresBase;
import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.ConversorJSON.ConversorJugador;
import edu.fiuba.algo3.modelo.ConversorJSON.ParserSeccion;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

public class CreadorSumaValorBase implements CreadorModificador {
    private ConversorJugador conversor;
    private Unidad cartaBase;
    private String nombreSeccion;

    public CreadorSumaValorBase (String nombreSeccion, ConversorJugador conversor, Unidad cartaBase) {
        this.conversor = conversor;
        this.cartaBase = cartaBase;
        this.nombreSeccion = nombreSeccion;
    }

    @Override
    public Modificador crearModificador() {
        Ubicable seccionParseada =  ParserSeccion.obtenerSeccion(nombreSeccion);
        Ubicable seccion =  conversor.obtenerSeccion(seccionParseada);
        return new SumaValoresBase(cartaBase, seccion);
    }
}
