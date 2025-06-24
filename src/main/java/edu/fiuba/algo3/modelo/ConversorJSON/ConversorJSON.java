package edu.fiuba.algo3.modelo.ConversorJSON;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import edu.fiuba.algo3.modelo.Carta.*;
import edu.fiuba.algo3.modelo.Carta.Especial.Especial;
import edu.fiuba.algo3.modelo.Carta.Modificador.Medico;
import edu.fiuba.algo3.modelo.Seccion.Asedio;
import edu.fiuba.algo3.modelo.Seccion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

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


    public List<UnidadGeneral> obtenerUnidades (ConversorJugador conversor) {
        return conversor.obtenerUnidades(jsonObject);
    }


    public Mazo obtenerMazo (ConversorJugador conversor) {
        return conversor.obtenerMazo(jsonObject);
    }

}
