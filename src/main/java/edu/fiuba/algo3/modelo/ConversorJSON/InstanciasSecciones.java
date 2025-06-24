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

    public Ubicable obtenerUbicableDe(int numeroJugador, Ubicable ubicable) {
        int i = (numeroJugador == 1) ? 0 : 3;
        for (int j = i; j < i + 3; j++) {
            if (secciones.get(i).esIgualQue(ubicable))
                return secciones.get(j);
        }
        return null;
    }

    public Ubicable obtenerSeccion (TipoSeccion seccion) {
        return secciones.get(seccion.ordinal());
    }
}
