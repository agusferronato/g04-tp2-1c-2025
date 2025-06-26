package edu.fiuba.algo3.modelo.ConversorJSON.Creadores.Modificadores;

import edu.fiuba.algo3.modelo.Carta.Modificador.Legendaria;
import edu.fiuba.algo3.modelo.Carta.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.ConversorJSON.ConversorJugador;
import edu.fiuba.algo3.modelo.ConversorJSON.ParserSeccion;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

public class CreadorLegendaria implements CreadorModificador {
    private String nombreSeccion;
    private Unidad cartaBase;
    private ConversorJugador conversor;

    public CreadorLegendaria(ConversorJugador conversor, Unidad cartaBase, String nombreSeccion) {
        this.cartaBase = cartaBase;
        this.conversor = conversor;
        this.nombreSeccion = nombreSeccion;
    }

    @Override
    public Modificador crearModificador() {
        Ubicable seccionParseada = ParserSeccion.obtenerSeccion(nombreSeccion);
        Ubicable seccion = conversor.obtenerSeccion(seccionParseada);
        return new Legendaria(cartaBase, seccion);
    }
}
