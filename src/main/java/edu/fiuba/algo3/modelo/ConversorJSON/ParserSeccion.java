package edu.fiuba.algo3.modelo.ConversorJSON;

import edu.fiuba.algo3.modelo.Seccion.Asedio;
import edu.fiuba.algo3.modelo.Seccion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.Seccion.Rango;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

public class ParserSeccion {

    public static Ubicable obtenerSeccion(ConversorJugador conversor, String nombreSeccion) {
        switch (nombreSeccion) {
            case "Cuerpo a Cuerpo":
                return conversor.obtenerSeccion(new CuerpoACuerpo());
            case "Rango":
                return conversor.obtenerSeccion(new Rango());
            case "Asedio":
                return conversor.obtenerSeccion(new Asedio());
            default:
                return null;
        }
    }
}
