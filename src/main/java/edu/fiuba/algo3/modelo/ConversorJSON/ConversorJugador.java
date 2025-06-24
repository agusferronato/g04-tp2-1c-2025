package edu.fiuba.algo3.modelo.ConversorJSON;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Mazo;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;
import edu.fiuba.algo3.modelo.Seccion.Rango;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;
import org.json.simple.JSONObject;

import java.util.List;

public interface ConversorJugador {
    Mazo obtenerMazo (JsonObject json);
    Ubicable obtenerSeccion(Ubicable ubicable);
    List<UnidadGeneral> obtenerUnidades(JsonObject jsonObject);
}
