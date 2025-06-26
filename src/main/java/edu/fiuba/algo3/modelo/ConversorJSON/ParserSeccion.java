package edu.fiuba.algo3.modelo.ConversorJSON;

import edu.fiuba.algo3.modelo.Seccion.Asedio;
import edu.fiuba.algo3.modelo.Seccion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.Seccion.Rango;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

import java.util.ArrayList;
import java.util.List;

public class ParserSeccion {

    public static Ubicable obtenerSeccion(String nombreSeccion) {
        switch (nombreSeccion) {
            case "CuerpoaCuerpo":
            case "Cuerpo a Cuerpo":
            case "Combate Cuerpo a Cuerpo":
                return new CuerpoACuerpo();
            case "Combate a Distancia":
            case "Rango":
                return new Rango();
            case "Asedio":
                return new Asedio();
            default:
                return null;
        }
    }

    public static List<Ubicable> obtenerSeccionesPara(String[] nombresSecciones) {
        List<Ubicable> seccionesParseadas = new ArrayList<>();
        for (String nombreSeccion : nombresSecciones) {
            seccionesParseadas.add(obtenerSeccion(nombreSeccion));
        }
        return seccionesParseadas;
    }
}
