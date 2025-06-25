package edu.fiuba.algo3.modelo.ConversorJSON.Creadores.Modificadores;

import edu.fiuba.algo3.modelo.Carta.Modificador.Medico;
import edu.fiuba.algo3.modelo.Carta.Modificador.Modificador;
import edu.fiuba.algo3.modelo.Carta.Unidad;

public class CreadorMedico implements CreadorModificador {
    private Unidad cartaBase;

    public CreadorMedico (Unidad cartaBase) {
        this.cartaBase = cartaBase;
    }

    @Override
    public Modificador crearModificador() {
        return new Medico(cartaBase);
    }
}
