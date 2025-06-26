package edu.fiuba.algo3.modelo.ConversorJSON.Creadores.Especiales;

import edu.fiuba.algo3.modelo.Carta.Especial.Especial;
import edu.fiuba.algo3.modelo.Carta.Especial.TierraArrasada;
import edu.fiuba.algo3.modelo.ConversorJSON.ConversorJugador;
import edu.fiuba.algo3.modelo.Seccion.ContenedorSecciones;

public class CreadorTierraArrasada implements CreadorEspecial {
    private ConversorJugador conversor;
    private String nombre, descripcion;

    public CreadorTierraArrasada (ConversorJugador conversor, String nombre, String descripcion) {
        this.conversor = conversor;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public Especial crearEspecial() {
        ContenedorSecciones tablero = conversor.obtenerTablero();
        return new TierraArrasada(nombre, descripcion, tablero);
    }
}
