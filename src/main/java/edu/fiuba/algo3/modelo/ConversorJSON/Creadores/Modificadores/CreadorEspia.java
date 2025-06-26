package edu.fiuba.algo3.modelo.ConversorJSON.Creadores.Modificadores;

import edu.fiuba.algo3.modelo.Carta.Modificador.Espia;
import edu.fiuba.algo3.modelo.Carta.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.ConversorJSON.ConversorJugador;
import edu.fiuba.algo3.modelo.ConversorJSON.ParserSeccion;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

public class CreadorEspia implements CreadorModificador {
    private String nombreSeccion;
    private ConversorJugador conversor;
    private Unidad cartaBase;

    public CreadorEspia (Unidad cartaBase, ConversorJugador conversor,  String nombreSeccion) {
        this.cartaBase = cartaBase;
        this.conversor = conversor;
        this.nombreSeccion = nombreSeccion;
    }

    @Override
    public Modificador crearModificador() {
        Ubicable seccionParseada = ParserSeccion.obtenerSeccion(nombreSeccion);
        Ubicable seccion = conversor.obtenerSeccionContraria(seccionParseada);
        return new Espia(cartaBase, seccion);
    }
}
