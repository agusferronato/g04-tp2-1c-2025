package edu.fiuba.algo3.modelo.Comando;
import edu.fiuba.algo3.modelo.Carta.Carta;
import edu.fiuba.algo3.modelo.Carta.Puntaje;
import edu.fiuba.algo3.modelo.Carta.Unidad;
import edu.fiuba.algo3.modelo.Seccion.Ubicable;
import java.util.List;

public class ComandoUnida extends Comando {
    private String tipo;
    private Ubicable seccion;

    public ComandoUnida (Ubicable seccion, String tipo) {
        this.seccion = seccion;
        this.tipo = tipo;
    }

    @Override
    public void ejecutar() {
        this.seccion.duplicarCartasDeTipo(this.tipo);
    }
}
