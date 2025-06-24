package edu.fiuba.algo3.modelo.ConversorJSON;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Especial.Especial;
import edu.fiuba.algo3.modelo.Carta.Mazo;
import edu.fiuba.algo3.modelo.Carta.Unidad;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConversorJSON {
    private JsonObject jsonObject;
    private final String RUTA_ARCHIVO = "/json/gwent.json";

    public ConversorJSON() {
        URL recurso = getClass().getClassLoader().getResource(RUTA_ARCHIVO);
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(RUTA_ARCHIVO);
        if (inputStream == null) {
            throw new RuntimeException("No se encontró el archivo " + RUTA_ARCHIVO);
        }
        jsonObject = JsonParser.parseReader(new InputStreamReader(inputStream)).getAsJsonObject();
    }

/*
    List<Unidad> obtenerUnidadesPara (JsonObject mazo) {
        JsonArray unidades = mazo.getAsJsonArray("unidades");
        List<Unidad> cartas = new ArrayList<>();

        for (JsonElement unidad : unidades) {
            Unidad carta = parsearUnidad(unidad);
            cartas.add(carta);
        }

        return cartas;
    }

    List<Especial> obtenerEspecialesPara (JsonObject mazo) {
        JsonArray especiales = mazo.getAsJsonArray("especiales");
        return new ArrayList<>();
    }



    private Mazo mazo (String jugador) {
        InputStream inputStream = ConversorJSON.class.getClassLoader().getResourceAsStream(path.toString());
        JsonObject jsonObject = JsonParser.parseReader(new InputStreamReader(inputStream)).getAsJsonObject();

        JsonObject mazo = jsonObject.getAsJsonObject(jugador);

        List<Carta> cartas = new ArrayList<>();
        cartas.addAll(obtenerUnidadesPara(mazo));
        cartas.addAll(obtenerEspecialesPara(mazo));
        return new Mazo();
    }

    public List<Mazo> mazos () {
        Mazo mazoJugador1 = this.mazo("mazo_jugador_uno");
        Mazo mazoJugador2 = this.mazo("mazo_jugador_dos");
        return List.of(mazoJugador1, mazoJugador2);
    }*/

    Unidad parsearUnidad (JsonElement unidad) {
        JsonObject carta = unidad.getAsJsonObject();
        String nombre = carta.get("nombre").getAsString();
        /*int puntos = carta.get("puntos").getAsInt();
        JsonArray modificadores = carta.getAsJsonArray("modificador");

        for  (JsonElement modificador : modificadores) {

        }*/
        return new Unidad(nombre /* Tipo */);
    }


    public List<Carta> obtenerCartasDe (String jugador) {
        JsonArray unidades = jsonObject.getAsJsonArray("unidades");
        List<Carta> cartas = new ArrayList<>();

        JsonElement primeraCarta = unidades.get(0);
        Unidad carta = parsearUnidad(primeraCarta);
        cartas.add(carta);


        return cartas;
    }

}
