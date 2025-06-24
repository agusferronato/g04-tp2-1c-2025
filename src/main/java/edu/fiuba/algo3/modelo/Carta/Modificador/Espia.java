package edu.fiuba.algo3.modelo.Carta.Modificador;

import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.CuerpoACuerpo;

public class Espia extends Modificador {
    private final int cartasDelMazoATomar = 2;

    private CuerpoACuerpo seccion;
    public Espia(Unidad cartaBase, CuerpoACuerpo seccion) {
        super(cartaBase);
        this.seccion = seccion;
    }

    @Override
    public void usar (Jugador jugador) {
        cartaBase.ubicarEn(seccion);
        jugador.descartar(this);
        jugador.tomarCartasDelMazo(cartasDelMazoATomar);
        seccion.actualizarValores();
    }
}
