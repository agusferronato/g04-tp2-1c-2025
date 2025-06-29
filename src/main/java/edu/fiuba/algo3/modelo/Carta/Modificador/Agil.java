package edu.fiuba.algo3.modelo.Carta.Modificador;

import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Seccion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.SeccionAleatoria;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;

public class Agil extends Modificador {
    private SeccionAleatoria seccionAleatoria;

    public Agil (Unidad cartaBase, SeccionAleatoria seccionAleatoria) {
        super(cartaBase);
        this.seccionAleatoria = seccionAleatoria;
    }

    @Override
    public void usar (Jugador jugador) {
        Ubicable seccion = seccionAleatoria.obtenerSeccionAleatoria();
        cartaBase.ubicarEn(seccion);
        seccion.actualizarValores();
    }

    @Override
    public String getTipo () {
        return "Agil";
    }
}
