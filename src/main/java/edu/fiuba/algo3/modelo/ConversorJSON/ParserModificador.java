package edu.fiuba.algo3.modelo.ConversorJSON;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Modificador.*;
import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;
import edu.fiuba.algo3.modelo.Seccion.*;

import java.util.List;

public class ParserModificador {

    public static Modificador obtenerModificador(ConversorJugador conversor,
                                                 String [] nombresSecciones,
                                                 String nombreModificador,
                                                 Unidad cartaBase,
                                                 String tipo
    ) {
        if (nombreModificador.equals("Carta Unida")) {

            Ubicable seccionParseada = ParserSeccion.obtenerSeccion(nombresSecciones[0]);
            Ubicable seccion = conversor.obtenerSeccion(seccionParseada);
            return new Unida(cartaBase, seccion, tipo);

        } else if (nombreModificador.equals("Medico")) {

            return new Medico(cartaBase);

        } else if (nombreModificador.equals("Espia")) {

            Ubicable seccionParseada = ParserSeccion.obtenerSeccion(nombresSecciones[0]);
            Ubicable seccion = conversor.obtenerSeccionContraria(seccionParseada);
            return new Espia(cartaBase, seccion);

        }  else if (nombreModificador.equals("Agil")) {

            List<Ubicable> seccionesParseadas = ParserSeccion.obtenerSeccionesPara(nombresSecciones);
            ContenedorSecciones contenedor = conversor.obtenerSecciones(seccionesParseadas);
            SeccionAleatoria seccionAleatoria = new SeccionAleatoria(contenedor);
            return new Agil(cartaBase, seccionAleatoria);

        } else if (nombreModificador.equals("Legendaria")) {

            Ubicable seccionParseada = ParserSeccion.obtenerSeccion(nombresSecciones[0]);
            Ubicable seccion = conversor.obtenerSeccionContraria(seccionParseada);
            return new Legendaria(cartaBase, seccion);

        }
        return null;

    }

}
