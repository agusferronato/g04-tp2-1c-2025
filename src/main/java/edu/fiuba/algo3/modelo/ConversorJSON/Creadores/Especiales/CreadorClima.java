package edu.fiuba.algo3.modelo.ConversorJSON.Creadores.Especiales;

import edu.fiuba.algo3.modelo.Carta.Especial.Clima;
import edu.fiuba.algo3.modelo.Carta.Especial.Especial;
import edu.fiuba.algo3.modelo.Carta.Especial.NeutralizarClima;
import edu.fiuba.algo3.modelo.ConversorJSON.ConversorJugador;
import edu.fiuba.algo3.modelo.ConversorJSON.ParserSeccion;
import edu.fiuba.algo3.modelo.Seccion.ContenedorSecciones;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

import java.util.List;

public class CreadorClima implements CreadorEspecial {
    private String nombre, descripcion;
    private String[] nombresSecciones;
    private ConversorJugador conversor;

    public CreadorClima (String nombre, String descripcion, ConversorJugador conversor, String[] nombresSecciones) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nombresSecciones = nombresSecciones;
        this.conversor = conversor;
    }

    @Override
    public Especial crearEspecial() {
        List<Ubicable> secciones = ParserSeccion.obtenerSeccionesPara(nombresSecciones);
        ContenedorSecciones contenedor = conversor.obtenerSeccionesDeAmbos(secciones);
        if (descripcion.contains("Elimina")) {
            return new NeutralizarClima(nombre, descripcion, contenedor);
        }
        return new Clima(nombre, descripcion, contenedor);
    }
}

