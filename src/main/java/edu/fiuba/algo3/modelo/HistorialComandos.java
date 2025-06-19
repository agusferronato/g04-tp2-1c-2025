package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class HistorialComandos {
    List<Comando> comandos;

    public HistorialComandos() {
        comandos = new ArrayList<>();
    }


    public void agregarComando(Comando comando){
        comandos.add(comando);
    }

    public void ejecutar () {
        for (Comando comando : comandos) {
            comando.ejecutar();
        }
    }

    public void quitarComandoClima() {
        comandos.removeIf(comando -> comando instanceof Clima);
    }
}
