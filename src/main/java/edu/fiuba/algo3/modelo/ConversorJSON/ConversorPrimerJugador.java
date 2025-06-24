package edu.fiuba.algo3.modelo.ConversorJSON;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Carta.Mazo;
import edu.fiuba.algo3.modelo.Carta.Modificador.Medico;
import edu.fiuba.algo3.modelo.Carta.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Carta.Puntaje;
import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;
import edu.fiuba.algo3.modelo.Seccion.Asedio;
import edu.fiuba.algo3.modelo.Seccion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

import java.util.ArrayList;
import java.util.List;

public class ConversorPrimerJugador implements ConversorJugador {
    private final String JUGADOR = "mazo_jugador_uno";
    private final int NUMERO_JUGADOR = 1;
    private InstanciasSecciones instancias;

    public ConversorPrimerJugador(InstanciasSecciones instancias) {
        this.instancias = instancias;
    }

    UnidadGeneral parsearUnidad (JsonElement unidad) {
        JsonObject carta = unidad.getAsJsonObject();

        String nombre = carta.get("nombre").getAsString();

        int puntos = carta.get("puntos").getAsInt();
        Puntaje puntaje = new Puntaje(puntos);


        String nombreSeccion = carta.get("seccion").getAsString();
        String [] nombresSecciones = nombreSeccion.split(",");


        Ubicable seccion = ParserSeccion.obtenerSeccion(this, nombresSecciones[0]);
        Unidad cartaBase = new Unidad(nombre, seccion, puntaje);

        /*
        String nombreModificador = carta.get("modificador").getAsJsonArray().getAsString();

        if (!nombreModificador.isEmpty()) {
            return new ParserModificador(this, cartaBase, nombresSecciones);
        } */
        return cartaBase;
    }

    @Override
    public Mazo obtenerMazo(JsonObject json) {
        return new Mazo();
    }

    @Override
    public Ubicable obtenerSeccion(Ubicable ubicable) {
        return instancias.obtenerUbicableDe(NUMERO_JUGADOR, ubicable);
    }

    @Override
    public List<UnidadGeneral> obtenerUnidades(JsonObject json) {
        JsonObject mazoJson = json.getAsJsonObject(JUGADOR);
        JsonArray unidadesArray = mazoJson.getAsJsonArray("unidades");

        List<UnidadGeneral> cartas = new ArrayList<>();

        for (JsonElement unidad : unidadesArray) {
            UnidadGeneral carta = parsearUnidad(unidad);
            cartas.add(carta);
        }

        return cartas;
    }
}
