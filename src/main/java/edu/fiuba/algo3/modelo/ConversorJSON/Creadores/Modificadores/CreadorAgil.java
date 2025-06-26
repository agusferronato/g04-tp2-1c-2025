package edu.fiuba.algo3.modelo.ConversorJSON.Creadores.Modificadores;

import edu.fiuba.algo3.modelo.Carta.Modificador.Agil;
import edu.fiuba.algo3.modelo.Carta.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.ConversorJSON.ConversorJugador;
import edu.fiuba.algo3.modelo.ConversorJSON.ParserSeccion;
import edu.fiuba.algo3.modelo.Seccion.ContenedorSecciones;
import edu.fiuba.algo3.modelo.Seccion.SeccionAleatoria;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

import java.util.List;

public class CreadorAgil implements CreadorModificador {
    private String [] nombresSecciones;
    private ConversorJugador conversor;
    private Unidad cartaBase;

    public CreadorAgil (Unidad cartaBase,  ConversorJugador conversor, String [] nombresSecciones) {
        this.nombresSecciones = nombresSecciones;
        this.conversor = conversor;
        this.cartaBase = cartaBase;
    }

    @Override
    public Modificador crearModificador() {
        List<Ubicable> seccionesParseadas = ParserSeccion.obtenerSeccionesPara(nombresSecciones);
        ContenedorSecciones contenedor = conversor.obtenerSecciones(seccionesParseadas);
        SeccionAleatoria seccionAleatoria = new SeccionAleatoria(contenedor);
        return new Agil(cartaBase, seccionAleatoria);
    }
}
