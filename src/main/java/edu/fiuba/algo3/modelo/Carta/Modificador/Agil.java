package edu.fiuba.algo3.modelo.Carta.Modificador;

import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Seccion.CuerpoACuerpo;
import edu.fiuba.algo3.modelo.LogicaGeneral.Jugador;
import edu.fiuba.algo3.modelo.Seccion.SeccionAleatoria;

public class Agil extends Unidad {
    private Unidad cartaBase;
    private SeccionAleatoria seccionAleatoria;
    public Agil (Unidad cartaBase, SeccionAleatoria seccionAleatoria) {
        this.cartaBase = cartaBase;
        this.seccionAleatoria = seccionAleatoria;
    }
    public void usar (Jugador jugador) {
        CuerpoACuerpo seccion = seccionAleatoria.obtenerSeccionAleatoria();
        cartaBase.ubicarEn(seccion);
    }
}
