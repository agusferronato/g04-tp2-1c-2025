package edu.fiuba.algo3.modelo.ConversorJSON;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.Carta.Especial.Clima;
import edu.fiuba.algo3.modelo.Carta.Especial.Especial;
import edu.fiuba.algo3.modelo.Carta.Especial.MoraleBoost;
import edu.fiuba.algo3.modelo.Carta.Mazo;
import edu.fiuba.algo3.modelo.Carta.Modificador.Medico;
import edu.fiuba.algo3.modelo.Carta.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Carta.Puntaje;
import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Carta.UnidadGeneral;
import edu.fiuba.algo3.modelo.Seccion.Asedio;
import edu.fiuba.algo3.modelo.Seccion.ContenedorSecciones;
import edu.fiuba.algo3.modelo.Seccion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

import java.util.ArrayList;
import java.util.List;

public class ConversorPrimerJugador implements ConversorJugador {
    private final String JUGADOR = "mazo_jugador_uno";
    private final int NUMERO_JUGADOR = 1;
    private final int NUMERO_JUGADOR_CONTRARIO = 2;
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
        String nombreSeccionSinEspacios = nombreSeccion.replace(" ", "");
        String [] nombresSecciones = nombreSeccionSinEspacios.split(",");


        Ubicable seccion = ParserSeccion.obtenerSeccion(nombresSecciones[0]);
        Unidad cartaBase = new Unidad(nombre, obtenerSeccion(seccion), puntaje);

        String nombreModificador = "";
        JsonArray arrayModificadores =  carta.get("modificador").getAsJsonArray();
        if (!arrayModificadores.isEmpty()) {
            nombreModificador = arrayModificadores.getAsString();
        }

        if (!nombreModificador.isEmpty()) {
            return ParserModificador.
                    obtenerModificador(this, nombresSecciones, nombreModificador, cartaBase, nombreSeccion);
        }


        return cartaBase;
    }

    @Override
    public Ubicable obtenerSeccion(Ubicable seccion) {
        return instancias.obtenerUbicableDe(NUMERO_JUGADOR, seccion);
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

    @Override
    public Ubicable obtenerSeccionContraria(Ubicable seccion) {
        return instancias.obtenerUbicableDe(NUMERO_JUGADOR_CONTRARIO, seccion);
    }

    @Override
    public ContenedorSecciones obtenerSecciones(List<Ubicable> seccionesParseadas) {
        List<Ubicable> secciones = new ArrayList<>();
        for (Ubicable seccion : seccionesParseadas) {
            secciones.add(instancias.obtenerUbicableDe(NUMERO_JUGADOR, seccion));
        }
        ContenedorSecciones contenedorSecciones = new ContenedorSecciones(secciones);
        return contenedorSecciones;
    }

    @Override
    public List<Especial> obtenerEspeciales(JsonObject json) {
        JsonObject mazoJson = json.getAsJsonObject(JUGADOR);
        JsonArray especialesArray = mazoJson.getAsJsonArray("especiales");

        List<Especial> cartas = new ArrayList<>();

        for (JsonElement especial : especialesArray) {
            Especial carta = parsearEspecial(especial);
            cartas.add(carta);
        }


        return cartas;
    }

    @Override
    public ContenedorSecciones obtenerTablero() {
        return instancias.obtenerInstancias();
    }

    @Override
    public ContenedorSecciones obtenerSeccionesDeAmbos(List<Ubicable> secciones) {
        List<Ubicable> seccionesDeAmbos = new ArrayList<>();
        for (Ubicable seccion : secciones) {
            seccionesDeAmbos.add(instancias.obtenerUbicableDe(NUMERO_JUGADOR, seccion));
            seccionesDeAmbos.add(instancias.obtenerUbicableDe(NUMERO_JUGADOR_CONTRARIO, seccion));
        }
        return new ContenedorSecciones(seccionesDeAmbos);
    }

    private Especial parsearEspecial(JsonElement especial) {
        JsonObject carta = especial.getAsJsonObject();

        String nombre = carta.get("nombre").getAsString();
        String descripcion = carta.get("descripcion").getAsString();

        JsonElement afectado = carta.get("afectado");

        String tipo =  carta.get("tipo").getAsString();
        String[] nombresSecciones = new String[0];

        if (afectado != null) {
            JsonArray arrayAfectados = afectado.getAsJsonArray();
            nombresSecciones = new String[arrayAfectados.size()];
            for (int i = 0; i < arrayAfectados.size(); i++) {
                nombresSecciones[i] = arrayAfectados.get(0).getAsString();
            }
        }


        Especial cartaParseada = ParserEspecial.obtenerCarta(this, tipo, nombre, descripcion, nombresSecciones);
        return cartaParseada;
    }
}
