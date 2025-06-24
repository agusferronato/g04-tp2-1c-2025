package edu.fiuba.algo3.modelo.Carta.Especial;

import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.ContenedorSecciones;

public class TierraArrasada extends Especial {
    private ContenedorSecciones secciones;

    public TierraArrasada(ContenedorSecciones secciones) {
        super(null);
        this.secciones = secciones;
    }

    public void usar (Jugador jugador) {
        secciones.quemarCartasMasFuertes();
    }

}
