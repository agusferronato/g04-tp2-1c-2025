package edu.fiuba.algo3.modelo.ConversorJSON.Creadores.Especiales;

import edu.fiuba.algo3.modelo.Carta.Especial.Especial;
import edu.fiuba.algo3.modelo.Carta.Especial.MoraleBoost;
import edu.fiuba.algo3.modelo.ConversorJSON.ConversorJugador;
import edu.fiuba.algo3.modelo.Seccion.*;

import java.util.List;

public class CreadorMoraleBoost implements CreadorEspecial {
    private ConversorJugador conversor;
    private String nombre;
    private String descripcion;

    public CreadorMoraleBoost(ConversorJugador conversor, String nombre, String descripcion) {
        this.conversor = conversor;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public Especial crearEspecial() {
        ContenedorSecciones contenedor = conversor.obtenerSecciones(List.of(
                new CuerpoACuerpo(),
                new Asedio(),
                new Rango()
        ));
        SeccionAleatoria seccionAleatoria = new SeccionAleatoria(contenedor);
        return new MoraleBoost(nombre, descripcion, seccionAleatoria.obtenerSeccionAleatoria());
    }
}
