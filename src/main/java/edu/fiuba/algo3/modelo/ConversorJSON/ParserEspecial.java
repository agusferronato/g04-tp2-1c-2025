package edu.fiuba.algo3.modelo.ConversorJSON;

import edu.fiuba.algo3.modelo.Carta.Especial.*;
import edu.fiuba.algo3.modelo.Seccion.*;

import java.util.ArrayList;
import java.util.List;

public class ParserEspecial {
    public static Especial obtenerCarta (ConversorJugador conversor,
                                         String tipo,
                                         String nombre,
                                         String descripcion,
                                         String [] nombresSecciones
    ) {
        if (tipo.equals("Clima")) {
            List<Ubicable> secciones = ParserSeccion.obtenerSeccionesPara(nombresSecciones);
            ContenedorSecciones contenedor = conversor.obtenerSeccionesDeAmbos(secciones);
            if (descripcion.contains("Elimina")) {
                return new NeutralizarClima(nombre, descripcion, contenedor);
            }
            return new Clima(nombre, descripcion, contenedor);
        } else if (tipo.equals("Morale boost")) {
            ContenedorSecciones contenedor = conversor.obtenerSecciones(List.of(
                    new CuerpoACuerpo(),
                    new Asedio(),
                    new Rango()
            ));
            SeccionAleatoria seccionAleatoria = new SeccionAleatoria(contenedor);
            Ubicable seccion = seccionAleatoria.obtenerSeccionAleatoria();
            return new MoraleBoost(nombre, descripcion, seccion);
        } else if (tipo.equals("Tierra Arrasada")) {
            ContenedorSecciones tablero = conversor.obtenerTablero();
            return new TierraArrasada(nombre, descripcion, tablero);
        }
        return null;
    }
}
