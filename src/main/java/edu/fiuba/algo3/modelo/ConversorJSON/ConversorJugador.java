package edu.fiuba.algo3.modelo.ConversorJSON;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Carta.*;
import edu.fiuba.algo3.modelo.Carta.Especial.Especial;
import edu.fiuba.algo3.modelo.Carta.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Seccion.ContenedorSecciones;
import edu.fiuba.algo3.modelo.Seccion.Rango;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConversorJugador {
    private String jugador;
    private int numeroJugador, numeroJugadorContrario;
    private InstanciasSecciones instancias;

    public ConversorJugador(String jugador, int numeroJugador, int numeroJugadorContrario, InstanciasSecciones instancias) {
        this.instancias = instancias;
        this.jugador = jugador;
        this.numeroJugador = numeroJugador;
        this.numeroJugadorContrario = numeroJugadorContrario;
    }

    UnidadGeneral parsearUnidad (JsonElement unidad) {
        JsonObject carta = unidad.getAsJsonObject();

        String nombre = carta.get("nombre").getAsString();

        String imagen = carta.get("imagen").getAsString();

        int puntos = carta.get("puntos").getAsInt();
        Puntaje puntaje = new Puntaje(puntos);

        String nombreSeccion = carta.get("seccion").getAsString();
        String nombreSeccionSinEspacios = nombreSeccion.replace(" ", "");
        String [] nombresSecciones = nombreSeccionSinEspacios.split(",");


        Ubicable seccion = ParserSeccion.obtenerSeccion(nombresSecciones[0]);
        Unidad cartaBase = new Unidad(nombre, obtenerSeccion(seccion), puntaje);

        cartaBase.setImage(imagen);

        String nombreModificador = "";
        JsonArray arrayModificadores =  carta.get("modificador").getAsJsonArray();
        if (!arrayModificadores.isEmpty()) {
            nombreModificador = arrayModificadores.getAsString();
        }

        if (!nombreModificador.isEmpty()) {

            Modificador modificador =  ParserModificador.
                    obtenerModificador(this, nombresSecciones, nombreModificador, cartaBase, nombre);
            modificador.setImage(imagen);
            return modificador;
        }
        return cartaBase;
    }

    public Ubicable obtenerSeccion(Ubicable seccion) {
        return instancias.obtenerUbicableDe(numeroJugador, seccion);
    }

    public List<UnidadGeneral> obtenerUnidades(JsonObject json) {
        JsonObject mazoJson = json.getAsJsonObject(jugador);
        JsonArray unidadesArray = mazoJson.getAsJsonArray("unidades");

        List<UnidadGeneral> cartas = new ArrayList<>();

        for (JsonElement unidad : unidadesArray) {
            UnidadGeneral carta = parsearUnidad(unidad);
            cartas.add(carta);
        }

        return cartas;
    }

    public Ubicable obtenerSeccionContraria(Ubicable seccion) {
        return instancias.obtenerUbicableDe(numeroJugadorContrario, seccion);
    }

    public ContenedorSecciones obtenerSecciones(List<Ubicable> seccionesParseadas) {
        List<Ubicable> secciones = new ArrayList<>();
        for (Ubicable seccion : seccionesParseadas) {
            secciones.add(instancias.obtenerUbicableDe(numeroJugador, seccion));
        }
        ContenedorSecciones contenedorSecciones = new ContenedorSecciones(secciones);
        return contenedorSecciones;
    }

    public List<Especial> obtenerEspeciales(JsonObject json) {
        JsonObject mazoJson = json.getAsJsonObject(jugador);
        JsonArray especialesArray = mazoJson.getAsJsonArray("especiales");

        List<Especial> cartas = new ArrayList<>();

        for (JsonElement especial : especialesArray) {
            Especial carta = parsearEspecial(especial);
            cartas.add(carta);
        }
        return cartas;
    }

    public ContenedorSecciones obtenerTablero() {
        return instancias.obtenerInstancias();
    }

    public ContenedorSecciones obtenerSeccionesDeAmbos(List<Ubicable> secciones) {
        List<Ubicable> seccionesDeAmbos = new ArrayList<>();
        for (Ubicable seccion : secciones) {
            seccionesDeAmbos.add(instancias.obtenerUbicableDe(1, seccion));
            seccionesDeAmbos.add(instancias.obtenerUbicableDe(2, seccion));
        }
        return new ContenedorSecciones(seccionesDeAmbos);
    }

    private Especial parsearEspecial(JsonElement especial) {
        JsonObject carta = especial.getAsJsonObject();

        String nombre = carta.get("nombre").getAsString();
        String descripcion = carta.get("descripcion").getAsString();
        String imagen = carta.get("imagen").getAsString();

        JsonElement afectado = carta.get("afectado");

        String tipo =  carta.get("tipo").getAsString();
        String[] nombresSecciones = new String[0];

        if (afectado != null) {
            JsonArray arrayAfectados = afectado.getAsJsonArray();
            nombresSecciones = new String[arrayAfectados.size()];
            for (int i = 0; i < arrayAfectados.size(); i++) {
                nombresSecciones[i] = arrayAfectados.get(i).getAsString();
            }
        }

        Especial cartaParseada = ParserEspecial.obtenerCarta(this, tipo, nombre, descripcion, nombresSecciones);
        if (cartaParseada != null) {
            cartaParseada.setImage(imagen);
        }
        return cartaParseada;
    }
}
