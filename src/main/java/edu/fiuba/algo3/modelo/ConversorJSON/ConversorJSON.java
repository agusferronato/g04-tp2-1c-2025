package edu.fiuba.algo3.modelo.ConversorJSON;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Especial.Especial;
import edu.fiuba.algo3.modelo.Carta.Mazo;
import edu.fiuba.algo3.modelo.Carta.Puntaje;
import edu.fiuba.algo3.modelo.Carta.Unidad;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConversorJSON {
    private JsonObject jsonObject;
    private final String RUTA_ARCHIVO = "src/main/resources/json/gwent.json";

    public ConversorJSON() {
        Path path = Paths.get(RUTA_ARCHIVO);
        try {
            Reader reader = Files.newBufferedReader(path);
            jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Unidad parsearUnidad (JsonElement unidad) {
        JsonObject carta = unidad.getAsJsonObject();
        String nombre = carta.get("nombre").getAsString();
        int puntos = carta.get("puntos").getAsInt();
        Puntaje puntaje = new Puntaje(puntos);

        return new Unidad(nombre /* Tipo */, puntaje);
    }


    public List<Unidad> obtenerCartasDe (String jugador) {
        JsonObject mazo = jsonObject.getAsJsonObject(jugador);
        JsonArray unidadesArray = mazo.getAsJsonArray("unidades");

        List<Unidad> cartas = new ArrayList<>();

        JsonElement primeraCarta = unidadesArray.get(0);
        Unidad carta = parsearUnidad(primeraCarta);
        cartas.add(carta);


        return cartas;
    }

}
