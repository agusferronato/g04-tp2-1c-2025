package edu.fiuba.algo3.modelo;

public class ComandoUnida implements Comando {
    private String tipo;
    private Ubicable seccion;

    public ComandoUnida (Ubicable seccion, String tipo) {
        this.seccion = seccion;
        this.tipo = tipo;
    }

    @Override
    public void ejecutar() {
        this.seccion.duplicarCartasDeTipo(tipo);
    }
}
