package edu.fiuba.algo3.modelo.ConversorJSON;

import edu.fiuba.algo3.modelo.Carta.Especial.*;
import edu.fiuba.algo3.modelo.ConversorJSON.Creadores.Especiales.CreadorClima;
import edu.fiuba.algo3.modelo.ConversorJSON.Creadores.Especiales.CreadorEspecial;
import edu.fiuba.algo3.modelo.ConversorJSON.Creadores.Especiales.CreadorMoraleBoost;
import edu.fiuba.algo3.modelo.ConversorJSON.Creadores.Especiales.CreadorTierraArrasada;
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
        CreadorEspecial creador = null;
        if (tipo.equals("Clima")) {
            creador = new CreadorClima(nombre, descripcion, conversor, nombresSecciones);
        } else if (tipo.equals("Morale boost")) {
            creador = new CreadorMoraleBoost(conversor, nombre, descripcion);
        } else if (tipo.equals("Tierra arrasada")) {
            creador = new CreadorTierraArrasada(conversor, nombre, descripcion);
        }
        return (creador == null) ? null : creador.crearEspecial();
    }
}
