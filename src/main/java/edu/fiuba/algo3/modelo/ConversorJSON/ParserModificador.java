package edu.fiuba.algo3.modelo.ConversorJSON;

import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Especial.TierraArrasada;
import edu.fiuba.algo3.modelo.Carta.Modificador.*;
import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;
import edu.fiuba.algo3.modelo.ConversorJSON.Creadores.Modificadores.*;
import edu.fiuba.algo3.modelo.Seccion.*;

import java.util.List;

public class ParserModificador {

    public static Modificador obtenerModificador(ConversorJugador conversor,
                                                 String [] nombresSecciones,
                                                 String nombreModificador,
                                                 Unidad cartaBase,
                                                 String tipo
    ) {
        CreadorModificador creador = null;
        switch (nombreModificador) {
            case "Carta Unida":
                creador = new CreadorUnida(cartaBase, nombresSecciones[0], conversor, tipo);
                break;
            case "Medico":
                creador = new CreadorMedico(cartaBase);
                break;
            case "Espia":
                creador = new CreadorEspia(cartaBase, conversor, nombresSecciones[0]);
                break;
            case "Agil":
                creador = new CreadorAgil(cartaBase, conversor, nombresSecciones);
                break;
            case "Legendaria":
                creador = new CreadorLegendaria(conversor, cartaBase, nombresSecciones[0]);
                break;
            case "Suma Valor Base":
                creador = new CreadorSumaValorBase(nombresSecciones[0], conversor, cartaBase);
                break;
        }
        return (creador != null) ? creador.crearModificador() : null;

    }

}
