package edu.fiuba.algo3.modelo.ConversorJSON;

import edu.fiuba.algo3.modelo.Seccion.Asedio;
import edu.fiuba.algo3.modelo.Seccion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.Seccion.Rango;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InstanciasSecciones {
    List<Ubicable> secciones;

    public InstanciasSecciones() {
        secciones = new ArrayList<>();
        secciones.add(new CuerpoACuerpo());
        secciones.add(new Rango());
        secciones.add(new Asedio());
        secciones.add(new CuerpoACuerpo());
        secciones.add(new Rango());
        secciones.add(new Asedio());
    }

    public Ubicable obtenerSeccion (TipoSeccion seccion) {
        return secciones.get(seccion.ordinal());
    }
}
