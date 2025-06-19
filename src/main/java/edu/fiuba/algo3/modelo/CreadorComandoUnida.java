package edu.fiuba.algo3.modelo;

public class CreadorComandoUnida extends CreadorComando {
    private Ubicable seccion;
    private String tipo;

    public CreadorComandoUnida(Ubicable seccion, String tipo) {
        this.seccion = seccion;
        this.tipo = tipo;
    }

    @Override
    public Comando crearComando() {
        return new ComandoUnida(seccion, tipo);
    }
}
